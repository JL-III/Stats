package com.playtheatria.nessxxiii.stats.time;

import com.playtheatria.nessxxiii.stats.Stats;
import com.playtheatria.nessxxiii.stats.events.DayChangeEvent;
import com.playtheatria.nessxxiii.stats.utils.Utils;
import org.bukkit.scheduler.BukkitRunnable;

public class DailyTimer {

    private final Stats plugin;

    private final long timeLeft;

    // logic for timer
    // when timer runs out, fire DayChangeEvent

    public DailyTimer(Stats plugin) {
        this.plugin = plugin;
        this.timeLeft = Utils.calculateDelayUntilEndOfDay();
        run();
    }

    public void run() {
        new BukkitRunnable() {
            @Override
            public void run() {
                plugin.getServer().getPluginManager().callEvent(new DayChangeEvent());
            }
        }.runTaskLater(plugin, timeLeft * 20);
    }

    public long getTimeLeft() {
        return timeLeft;
    }
}
