package dev.elephantcode.clockifychabreparserapp.clockify;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
class ClockifyClientConfig {

    @Bean
    RestTemplate clockifyClient(ClockifyConfig config, RestTemplateBuilder builder) {
        return builder.defaultHeader("X-Api-Key", config.getApiKey())
            .build();
    }
}
