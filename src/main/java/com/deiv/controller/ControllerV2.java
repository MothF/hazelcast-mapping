package com.deiv.controller;

import com.deiv.cache.Cache;
import com.deiv.model.v2.MutableModelButJson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v2")
@RestController
public class ControllerV2 implements CacheController<MutableModelButJson> {

    private final Cache<MutableModelButJson> cacheV2;

    public ControllerV2(Cache<MutableModelButJson> cacheV2) {
        this.cacheV2 = cacheV2;
    }


    @Override
    public ResponseEntity<String> put(String key) {
        var success = cacheV2.put(key, new MutableModelButJson(key));
        if (success) return ResponseEntity.ok(key);
        return ResponseEntity.badRequest().build();
    }

    @Override
    public ResponseEntity<MutableModelButJson> get(String key) {
        return cacheV2.get(key)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Object> clear() {
        var success = cacheV2.clear();
        if (success) return ResponseEntity.ok().build();
        return ResponseEntity.internalServerError().build();
    }
}
