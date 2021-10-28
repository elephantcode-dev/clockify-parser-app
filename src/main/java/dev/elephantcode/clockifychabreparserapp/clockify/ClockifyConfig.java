package dev.elephantcode.clockifychabreparserapp.clockify;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "clockify")
class ClockifyConfig {

    private String workspaceId;
    private String userId;
    private String apiKey;
    private String timeEntriesPath;
    private String userPath;

}
