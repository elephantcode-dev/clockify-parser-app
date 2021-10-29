package dev.elephantcode.clockifychabreparserapp.chabre;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "chabre")
class ChabreConfig {

    private String consoleDelimiter;

}
