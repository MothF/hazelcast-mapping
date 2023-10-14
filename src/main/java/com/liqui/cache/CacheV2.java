package com.liqui.cache;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.HazelcastJsonValue;
import com.liqui.model.v1.HzStoredModel;
import com.liqui.model.v2.MutableModelButJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CacheV2 implements Cache<MutableModelButJson> {

    private static final Logger log = LoggerFactory.getLogger(CacheV2.class);

    private static final String CACHE_NAME = "json_model_v1_cache";

//    private final HazelcastInstance
    private final ObjectMapper objectMapper;

    public CacheV2(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Optional<MutableModelButJson> get(String key) {
//        var model = hazelcastInstance.<String, HazelcastJsonValue>getMap(CACHE_NAME).get(key);
        return Optional.empty();
    }

    @Override
    public boolean put(String key, MutableModelButJson value) {
        return false;
    }

    @Override
    public boolean clear() {
        return false;
    }

    private HazelcastJsonValue fromModel(MutableModelButJson model) throws JsonProcessingException {
        var s = objectMapper.writeValueAsString(model);
        return new HazelcastJsonValue(s);
    }

    private MutableModelButJson toModel() {

    }
}
