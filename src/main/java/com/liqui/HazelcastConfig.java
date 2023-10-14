package com.liqui;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import info.jerrinot.subzero.SubZero;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelcastConfig {

    @Bean
    HazelcastInstance hazelcastInstance() {
        ClientConfig config = new ClientConfig();
        config.getNetworkConfig().addAddress("127.0.0.1:5701", "localhost:5701");

        config.setInstanceName("main-hz");
        SubZero.useAsGlobalSerializer(config);
        return HazelcastClient.newHazelcastClient(config);
    }
}
