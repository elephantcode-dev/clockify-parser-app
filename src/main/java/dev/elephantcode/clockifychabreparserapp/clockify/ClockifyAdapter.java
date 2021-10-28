package dev.elephantcode.clockifychabreparserapp.clockify;

import dev.elephantcode.clockifychabreparserapp.model.TimeEntryDto;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@RequiredArgsConstructor
@Component
public class ClockifyAdapter {

    private final RestTemplate clockifyClient;
    private final ClockifyConfig clockifyConfig;

    public List<TimeEntryDto> getEntries(TimeEntryRequest request) {
        String uri = UriComponentsBuilder.fromHttpUrl(clockifyConfig.getTimeEntriesPath())
            .uriVariables(getUserData().toMap())
            .queryParam("start", format(request.getStart()))
            .queryParam("end", format(request.getEnd()))
            .queryParam("page-size", 4999L)
            .encode()
            .toUriString();
        return Optional.ofNullable(
                clockifyClient
                    .getForEntity(uri, TimeEntryResponse[].class)
                    .getBody())
            .map(Arrays::asList)
            .map(this::toDto)
            .orElse(Collections.emptyList());
    }

    private UserResponse getUserData() {
        return clockifyClient
            .getForEntity(clockifyConfig.getUserPath(), UserResponse.class)
            .getBody();
    }

    private List<TimeEntryDto> toDto(List<TimeEntryResponse> timeEntryResponses) {
        return timeEntryResponses.stream()
            .map(res -> TimeEntryDto.builder()
                .date(res.getTimeEntryInterval().getStart().toLocalDate())
                .duration(res.getTimeEntryInterval().getDuration())
                .description(res.getDescription())
                .build())
            .collect(Collectors.toList());

    }

    private String format(LocalDateTime dateTime) {
        ZonedDateTime utc = ZonedDateTime.of(dateTime, ZoneOffset.UTC);
        return utc.format(DateTimeFormatter.ISO_DATE_TIME);
    }
}
