package com.liqui.controller;

import com.liqui.model.v1.HzStoredModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v2")
@RestController
public class ControllerV2 implements CacheController {


    @Override
    public ResponseEntity<String> put(String key) {
        return null;
    }

    @Override
    public ResponseEntity<HzStoredModel> get(String key) {
        return null;
    }

    @Override
    public ResponseEntity<Object> clear() {
        return null;
    }
}
