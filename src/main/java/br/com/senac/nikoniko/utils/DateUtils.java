package br.com.senac.nikoniko.utils;

import lombok.experimental.UtilityClass;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class DateUtils {


    public LocalDateTime getStartOfWeek() {
        return LocalDateTime.now().with(DayOfWeek.MONDAY).minusDays(1);
    }

    public LocalDateTime getEndOfWeek() {
        return LocalDateTime.now().with(DayOfWeek.SATURDAY);
    }

    public String getStartOfWeekAsString() {
        return getStartOfWeek().format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public String getEndOfWeekAsString() {
        return getEndOfWeek().format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
