package dev.elephantcode.clockifychabreparserapp.clockify;

import java.time.LocalDateTime;
import lombok.NonNull;
import lombok.Value;

@Value(staticConstructor = "of")
public class TimeEntryRequest {

    @NonNull LocalDateTime start;
    @NonNull LocalDateTime end;

}
