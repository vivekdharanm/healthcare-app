package com.healthcare_application.HealthCare.search.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;

@Configuration
public class ElasticsearchConfig extends ElasticsearchConfiguration {

    @Override
    public ClientConfiguration clientConfiguration() {
        // Configure your Elasticsearch host here
        return ClientConfiguration.builder()
                .connectedTo("localhost:9200") // replace with your host:port
                .build();
    }

    // ElasticsearchConfiguration will automatically create RestHighLevelClient bean
}
