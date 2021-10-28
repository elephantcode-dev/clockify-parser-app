package dev.elephantcode.clockifychabreparserapp.chabre;

import dev.elephantcode.clockifychabreparserapp.clockify.ClockifyAdapter;
import dev.elephantcode.clockifychabreparserapp.clockify.TimeEntryRequest;
import dev.elephantcode.clockifychabreparserapp.mapper.TimeEntryMapper;
import dev.elephantcode.clockifychabreparserapp.model.TimeEntryDto;
import dev.elephantcode.clockifychabreparserapp.output.Printer;
import dev.elephantcode.clockifychabreparserapp.parser.Parser;
import dev.elephantcode.clockifychabreparserapp.parser.ParserConfig;
import java.util.Comparator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ChabreConsoleParser implements Parser {

    private final ClockifyAdapter clockifyAdapter;
    private final TimeEntryMapper mapper;
    private final Printer printer;
    private final ParserConfig config;

    @Override
    public void parse() {
        try {
            clockifyAdapter.getEntries(TimeEntryRequest.of(
                    config.getFrom(), config.getTo()))
                .stream()
                .filter(timeEntry -> !timeEntry.getDuration().isZero())
                .sorted(Comparator.comparing(TimeEntryDto::getDate))
                .map(mapper::parse)
                .forEach(printer::print);

        } catch (Exception e) {
            log.error("Failed to parse time entries", e);
        }
    }
}
