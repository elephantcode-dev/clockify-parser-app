package dev.elephantcode.clockifychabreparserapp.clockify;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import lombok.Data;

@Data
class UserResponse {

    @JsonProperty("activeWorkspace")
    private String workspace;
    @JsonProperty("id")
    private String id;

    Map<String, Object> toMap() {
        return Map.of(
            "workspace", workspace,
            "user-id", id
        );
    }
}
