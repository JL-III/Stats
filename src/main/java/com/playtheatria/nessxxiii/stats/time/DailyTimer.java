package com.playtheatria.nessxxiii.stats.time;

import com.playtheatria.nessxxiii.stats.Stats;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Date;

public class DailyTimer {

    private final Stats plugin;

    private Date day;

    // will there be a day manager? something that constructs a new day object every day?
    // should we store the statistics in this timer? is that a violation of concerns?
    // some other mechanism will still need to account for missing days, unless we just leave that data blank?

    public DailyTimer(Stats plugin) {
        this.plugin = plugin;
    }

    // todo: this appears fine at first glance but becomes problematic when you consider things like server down time etc.
    // i think first we need to determine the day for the timer, the timer needs to store this day? and then we can figure out how much time is left in the day before the timer runs again

//    public void run() {
//        new BukkitRunnable() {
//            @Override
//            public void run() {
//
//            }
//        }.runTaskTimerAsynchronously(plugin, 0, 20 * 60 * 60 * 24);
//    }
}
