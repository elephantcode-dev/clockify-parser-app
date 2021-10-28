package dev.elephantcode.clockifychabreparserapp.model;

import java.time.Duration;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class TimeEntryDto {

    LocalDate date;
    Duration duration;
    String description;
}
