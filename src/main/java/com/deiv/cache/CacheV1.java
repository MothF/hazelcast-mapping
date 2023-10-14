package com.deiv.cache;

import com.hazelcast.core.HazelcastInstance;
import com.deiv.model.v1.HzStoredModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CacheV1 implements Cache<HzStoredModel> {
    private static final Logger log = LoggerFactory.getLogger(CacheV1.class);

    private static final String CACHE_NAME = "0_model_v1_cache";

    private final HazelcastInstance hazelcastInstance;

    public CacheV1(HazelcastInstance hazelcastInstance) {
        this.hazelcastInstance = hazelcastInstance;
    }

    @Override
    public Optional<HzStoredModel> get(String key) {
        try {
            var map = hazelcastInstance.getMap(CACHE_NAME);
            var o = (HzStoredModel) map.get(key);
            return Optional.ofNullable(o);
        } catch (Exception ex) {
            log.error("Unable to get from cache {}", key, ex);
            return Optional.empty();
        }
    }

    @Override
    public boolean put(String key, HzStoredModel value) {
        try {
            var map = hazelcastInstance.getMap(CACHE_NAME);
            map.put(key, value);
            return true;
        } catch (Exception ex) {
            log.error("Unable to put to cache by {}", key, ex);
            return false;
        }
    }

    @Override
    public boolean clear() {
        try {
            hazelcastInstance.getMap(CACHE_NAME).clear();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
