package dev.elephantcode.clockifychabreparserapp.clockify;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
class TimeEntryResponse {

    @JsonProperty("description")
    private String description;
    @JsonProperty("timeInterval")
    private TimeEntryInterval timeEntryInterval;
}
