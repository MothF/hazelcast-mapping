package com.liqui.cache;

import com.liqui.model.ModelMarker;
import com.liqui.model.v1.HzStoredModel;

import java.util.Optional;

public interface Cache<T extends ModelMarker> {
    Optional<T> get(String key);

    boolean put(String key, T value);

    boolean clear();
}
