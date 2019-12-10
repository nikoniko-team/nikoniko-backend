package br.com.senac.nikoniko.utils;

import lombok.experimental.UtilityClass;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class DateUtils {


    public OffsetDateTime getStartOfWeek() {
        return OffsetDateTime.of(LocalDateTime.now().with(DayOfWeek.MONDAY).minusDays(1), ZoneOffset.UTC);
    }

    public OffsetDateTime getEndOfWeek() {
        return OffsetDateTime.of(LocalDateTime.now().with(DayOfWeek.SATURDAY), ZoneOffset.UTC);
    }

    public OffsetDateTime getStartOfMonth() {
        return localDateToOffset(LocalDate.now()).with(TemporalAdjusters.firstDayOfMonth());
    }

    public OffsetDateTime getEndOfMonth() {
        return localDateToOffset(LocalDate.now()).with(TemporalAdjusters.lastDayOfMonth());
    }

    public String getStartOfWeekAsString() {
        return getStartOfWeek().format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public String getEndOfWeekAsString() {
        return getEndOfWeek().format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public static OffsetDateTime localDateToOffset(LocalDate date) {
        return OffsetDateTime.of(date, LocalTime.now(), ZoneOffset.UTC);
    }

    public static List<Integer> getLastQuarterMonths() {
        var list = new ArrayList<Integer>();

        for (long i = 0; i < 3; i++) {
            list.add(Integer.valueOf(LocalDate.now().minusMonths(i).format(DateTimeFormatter.ofPattern("MM"))));
        }

        return list;
    }



}
