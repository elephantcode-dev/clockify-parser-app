package dev.elephantcode.clockifychabreparserapp.chabre;

import dev.elephantcode.clockifychabreparserapp.model.TimeEntryDto;
import dev.elephantcode.clockifychabreparserapp.mapper.TimeEntryMapper;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.format.DateTimeFormatter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChabreTimeEntryParser implements TimeEntryMapper {

    private static final String TEMPLATE = "{date}{delimiter}{name}{delimiter}Vodeno{delimiter}{duration}{delimiter}0{delimiter}{description}";

    private final ChabreConfig chabreConfig;

    @Override
    public String parse(TimeEntryDto line) {
        return TEMPLATE
            .replace("{date}", line.getDate().format(DateTimeFormatter.ISO_DATE))
            .replace("{delimiter}", chabreConfig.getConsoleDelimiter())
            .replace("{name}", chabreConfig.getName())
            .replace("{duration}", getDuration(line)).replace(".", ",")
            .replace("{description}", line.getDescription());
    }

    private String getDuration(TimeEntryDto entry) {
        return BigDecimal.valueOf(entry.getDuration().toMinutes()).divide(BigDecimal.valueOf(60), 1, RoundingMode.UNNECESSARY).toString();
    }
}
