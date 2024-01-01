package com.playtheatria.nessxxiii.stats.listeners;

import com.playtheatria.nessxxiii.stats.Stats;
import com.playtheatria.nessxxiii.stats.events.DayChangeEvent;
import com.playtheatria.nessxxiii.stats.time.DailyManager;
import com.playtheatria.nessxxiii.stats.time.DailyTimer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class DailyListener implements Listener {

    private final Stats plugin;

    private final DailyManager dailyManager;

    private DailyListener(Stats plugin, DailyManager dailyManager) {
        this.plugin = plugin;
        this.dailyManager = dailyManager;
    }

    @EventHandler
    public void onDayChange(DayChangeEvent event) {
        dailyManager.setTimer(new DailyTimer(plugin));
    }
}
