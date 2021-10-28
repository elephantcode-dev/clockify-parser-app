package dev.elephantcode.clockifychabreparserapp.mapper;

import dev.elephantcode.clockifychabreparserapp.model.TimeEntryDto;

public interface TimeEntryMapper {

    String parse(TimeEntryDto timeEntry);
}
