package com.liqui.controller;

import com.liqui.cache.Cache;
import com.liqui.cache.CacheV1;
import com.liqui.model.v1.HzStoredModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RestController
public class ControllerV1 implements CacheController {

    private final Cache<HzStoredModel> cacheV1;

    public ControllerV1(Cache<HzStoredModel> cacheV1) {
        this.cacheV1 = cacheV1;
    }

    @Override
    public ResponseEntity<String> put(String key) {
        var success = cacheV1.put(key, createModel(key));
        if (success) return ResponseEntity.ok(key);
        return ResponseEntity.badRequest().build();
    }

    @Override
    public ResponseEntity<HzStoredModel> get(String key) {
        return cacheV1.get(key)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Object> clear() {
        var success = cacheV1.clear();
        if (success) return ResponseEntity.ok().build();
        return ResponseEntity.internalServerError().build();
    }

    private HzStoredModel createModel(String key) {
        var hzStoredModel = new HzStoredModel();
        hzStoredModel.setAmount(Integer.parseInt(key));
        hzStoredModel.setValue("value");
        return hzStoredModel;
    }
}
