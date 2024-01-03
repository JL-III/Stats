package com.playtheatria.nessxxiii.stats.utils;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Utils {

    public static long calculateDelayUntilEndOfDay() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime endOfDay = LocalDateTime.of(now.toLocalDate(), LocalTime.MAX);
        return ChronoUnit.SECONDS.between(now, endOfDay);
    }
}
