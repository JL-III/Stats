package com.playtheatria.nessxxiii.stats;

import com.playtheatria.nessxxiii.stats.commands.AdminCommands;
import com.playtheatria.nessxxiii.stats.listeners.DayChange;
import com.playtheatria.nessxxiii.stats.listeners.PlayerLogIn;
import com.playtheatria.nessxxiii.stats.managers.ConfigManager;
import com.playtheatria.nessxxiii.stats.managers.StatsManager;
import com.playtheatria.nessxxiii.stats.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Stats extends JavaPlugin {

    @Override
    public void onEnable() {
        ConfigManager configManager = new ConfigManager(this);
//        if (!Utils.databaseConfigIsValid(configManager)) {
//            Bukkit.getPluginManager().disablePlugin(this);
//            return;
//        }
        // todo: initialize timers, listeners, commands, etc.
        StatsManager statsManager = new StatsManager(this);
        Objects.requireNonNull(getCommand("stats")).setExecutor(new AdminCommands(statsManager));
        Bukkit.getPluginManager().registerEvents(new PlayerLogIn(statsManager), this);
        Bukkit.getPluginManager().registerEvents(new DayChange(this, statsManager), this);
    }
}
