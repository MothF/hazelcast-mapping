package com.deiv.controller;

import com.deiv.model.ModelMarker;
import com.deiv.model.v1.HzStoredModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface CacheController<T extends ModelMarker> {
    @GetMapping("/put/{key}")
    ResponseEntity<String> put(@PathVariable String key);

    @GetMapping("/get/{key}")
    ResponseEntity<T> get(@PathVariable String key);

    @GetMapping("/clear")
    ResponseEntity<Object> clear();
}
