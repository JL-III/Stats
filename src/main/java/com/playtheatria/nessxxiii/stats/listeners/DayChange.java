package com.playtheatria.nessxxiii.stats.listeners;

import com.playtheatria.nessxxiii.stats.Stats;
import com.playtheatria.nessxxiii.stats.events.DayChangeEvent;
import com.playtheatria.nessxxiii.stats.managers.StatsManager;
import com.playtheatria.nessxxiii.stats.time.SecondTimer;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitTask;

public class DayChange implements Listener {

    private final Stats plugin;

    private final StatsManager statsManager;

    public DayChange(Stats plugin, StatsManager statsManager) {
        this.plugin = plugin;
        this.statsManager = statsManager;
    }

    @EventHandler
    public void onDayChange(DayChangeEvent event) {
        Bukkit.getConsoleSender().sendMessage(
                Bukkit.getScheduler().getPendingTasks().stream()
                        .filter(task ->
                                task.getOwner().getName().equalsIgnoreCase("stats")).count() + " tasks owned by stats found"
        );
        for (BukkitTask task : Bukkit.getScheduler().getPendingTasks()) {
            if (task.getOwner().getName().equalsIgnoreCase("stats")) {
                task.cancel();
                Bukkit.getConsoleSender().sendMessage("cancelling task found - id " + task.getTaskId() + " owned by " + task.getOwner().getName());
            }
        }
        // transition today's logins to yesterday's logins
        statsManager.setYesterdayLogins(statsManager.getLogins());
        // reset timer, logins, and playerslist
        statsManager.setTimer(new SecondTimer(plugin));
        statsManager.resetLogins();
        statsManager.resetPlayersList();
    }
}
