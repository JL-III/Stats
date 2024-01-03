package com.playtheatria.nessxxiii.stats.listeners;

import com.playtheatria.nessxxiii.stats.Stats;
import com.playtheatria.nessxxiii.stats.events.DayChangeEvent;
import com.playtheatria.nessxxiii.stats.managers.StatManager;
import com.playtheatria.nessxxiii.stats.time.DailyTimer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class DayChange implements Listener {

    private final Stats plugin;

    private final StatManager statManager;

    public DayChange(Stats plugin, StatManager statManager) {
        this.plugin = plugin;
        this.statManager = statManager;
    }

    @EventHandler
    public void onDayChange(DayChangeEvent event) {
        // transition today's logins to yesterday's logins
        statManager.setYesterdayLogins(statManager.getLogins());

        // reset timer, logins, and playerslist
        statManager.setTimer(new DailyTimer(plugin));
        statManager.resetLogins();
        statManager.resetPlayersList();
    }
}
