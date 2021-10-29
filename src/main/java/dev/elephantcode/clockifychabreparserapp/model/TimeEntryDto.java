package dev.elephantcode.clockifychabreparserapp.model;

import java.time.Duration;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class TimeEntryDto {

    LocalDateTime date;
    Duration duration;
    String description;
    String name;
}
