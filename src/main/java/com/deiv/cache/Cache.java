package com.deiv.cache;

import com.deiv.model.ModelMarker;

import java.util.Optional;

public interface Cache<T extends ModelMarker> {
    Optional<T> get(String key);

    boolean put(String key, T value);

    boolean clear();
}
