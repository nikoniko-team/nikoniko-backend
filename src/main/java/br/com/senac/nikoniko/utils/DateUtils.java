package br.com.senac.nikoniko.utils;

import lombok.experimental.UtilityClass;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class DateUtils {


    public OffsetDateTime getStartOfWeek() {
        return OffsetDateTime.of(LocalDateTime.now().with(DayOfWeek.MONDAY).minusDays(1), ZoneOffset.UTC);
    }

    public OffsetDateTime getEndOfWeek() {
        return OffsetDateTime.of(LocalDateTime.now().with(DayOfWeek.SATURDAY), ZoneOffset.UTC);
    }

    public String getStartOfWeekAsString() {
        return getStartOfWeek().format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public String getEndOfWeekAsString() {
        return getEndOfWeek().format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
