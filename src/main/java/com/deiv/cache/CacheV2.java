package com.deiv.cache;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.HazelcastJsonValue;
import com.deiv.model.v2.MutableModelButJson;
import com.hazelcast.core.IMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CacheV2 implements Cache<MutableModelButJson> {

    private static final Logger log = LoggerFactory.getLogger(CacheV2.class);

    private static final String CACHE_NAME = "0_json_model_v1_cache";

    private final HazelcastInstance hazelcastInstance;
    private final ObjectMapper objectMapper;

    public CacheV2(HazelcastInstance hazelcastInstance, ObjectMapper objectMapper) {
        this.hazelcastInstance = hazelcastInstance;
        this.objectMapper = objectMapper;
    }

    @Override
    public Optional<MutableModelButJson> get(String key) {
        var hazelcastJsonValue = getMap().get(key);
        try {
            var mutableModelButJson = objectMapper.readValue(hazelcastJsonValue.toString(), MutableModelButJson.class);
            return Optional.ofNullable(mutableModelButJson);
        } catch (Exception ex) {
            log.error("Object deserialization error key={}", key, ex);
            return Optional.empty();
        }
    }

    @Override
    public boolean put(String key, MutableModelButJson value) {
        try {
            var s = objectMapper.writeValueAsString(value);
            getMap().put(key, new HazelcastJsonValue(s));
            return true;
        } catch (Exception ex) {
            log.error("Object serialization error key={}", key, ex);
            return false;
        }
    }

    @Override
    public boolean clear() {
        try {
            getMap().clear();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    private IMap<String, HazelcastJsonValue> getMap() {
        return hazelcastInstance.getMap(CACHE_NAME);
    }
}
