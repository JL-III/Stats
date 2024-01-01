package com.playtheatria.nessxxiii.stats.time;

import com.playtheatria.nessxxiii.stats.Stats;
import com.playtheatria.nessxxiii.stats.events.DayChangeEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DailyTimer {

    private final Stats plugin;

    private final long timeLeft;

    // logic for daily timer
    // when timer runs out, fire DayChangeEvent

    public DailyTimer(Stats plugin) {
        this.plugin = plugin;
        this.timeLeft = calculateDelayUntilEndOfDay();
        run();
    }

    public void run() {
        new BukkitRunnable() {
            @Override
            public void run() {
                plugin.getServer().getPluginManager().callEvent(new DayChangeEvent());
            }
        }.runTaskLater(plugin, timeLeft);
    }

    private long calculateDelayUntilEndOfDay() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime endOfDay = LocalDateTime.of(now.toLocalDate(), LocalTime.MAX);
        return ChronoUnit.SECONDS.between(now, endOfDay);
    }

    public long getTimeLeft() {
        return timeLeft;
    }

}
