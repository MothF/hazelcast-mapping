package com.liqui.controller;

import com.liqui.model.v1.HzStoredModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface CacheController {
    @GetMapping("/put/{key}")
    ResponseEntity<String> put(@PathVariable String key);

    @GetMapping("/get/{key}")
    ResponseEntity<HzStoredModel> get(@PathVariable String key);

    @GetMapping("/clear")
    ResponseEntity<Object> clear();
}
