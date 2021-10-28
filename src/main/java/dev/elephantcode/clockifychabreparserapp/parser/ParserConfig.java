package dev.elephantcode.clockifychabreparserapp.parser;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class ParserConfig {

    private LocalDateTime from;
    private LocalDateTime to;

    @Value("${range.from:}")
    private void setFrom(String value) {
        if (value == null || value.isEmpty()) {
            from = LocalDateTime.of(LocalDate.now().withDayOfMonth(1), LocalTime.MIN);
        } else {
            from = LocalDate.parse(value).atStartOfDay();
        }
    }

    @Value("${range.to:}")
    private void setTo(String value) {
        if (value == null || value.isEmpty()) {
            LocalDate now = LocalDate.now();
            to = LocalDateTime.of(now.withDayOfMonth(now.lengthOfMonth()), LocalTime.MAX);
        } else {
            to = LocalDateTime.of(LocalDate.parse(value), LocalTime.MAX);
        }
    }

}
