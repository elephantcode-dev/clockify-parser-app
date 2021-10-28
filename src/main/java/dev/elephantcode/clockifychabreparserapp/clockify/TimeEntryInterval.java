package dev.elephantcode.clockifychabreparserapp.clockify;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Duration;
import java.time.LocalDateTime;
import lombok.Data;

@Data
class TimeEntryInterval {

    @JsonProperty("duration")
    Duration duration;
    @JsonProperty("start")
    LocalDateTime start;
    @JsonProperty("end")
    LocalDateTime end;
}
