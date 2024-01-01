package com.playtheatria.nessxxiii.stats;

import com.playtheatria.nessxxiii.stats.commands.AdminCommands;
import com.playtheatria.nessxxiii.stats.listeners.DayChange;
import com.playtheatria.nessxxiii.stats.listeners.PlayerLogIn;
import com.playtheatria.nessxxiii.stats.managers.StatManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Stats extends JavaPlugin {

    @Override
    public void onEnable() {
        // todo: initialize timers, listeners, commands, etc.
        StatManager statManager = new StatManager(this);
        Objects.requireNonNull(getCommand("astats")).setExecutor(new AdminCommands(statManager));
        Bukkit.getPluginManager().registerEvents(new PlayerLogIn(statManager), this);
        Bukkit.getPluginManager().registerEvents(new DayChange(this, statManager), this);
    }

    @Override
    public void onDisable() {
        // todo: persist data & clean up
    }
    
}
