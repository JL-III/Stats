package com.playtheatria.nessxxiii.stats;

import com.playtheatria.nessxxiii.stats.time.DailyManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Stats extends JavaPlugin {

    private DailyManager dailyManager;

    @Override
    public void onEnable() {
        // todo: initialize timers, listeners, commands, etc.
        this.dailyManager = new DailyManager(this);
    }

    @Override
    public void onDisable() {
        // todo: persist data & clean up
    }
    
}
