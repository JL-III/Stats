package com.playtheatria.nessxxiii.stats.listeners;

import com.playtheatria.nessxxiii.stats.managers.StatsManager;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class PlayerLogIn implements Listener {

    private final StatsManager statsManager;

    public PlayerLogIn(StatsManager statsManager) {
        this.statsManager = statsManager;
    }

    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event) {
        if (statsManager.getPlayersList().contains(event.getPlayer().getUniqueId())) {
            Bukkit.getConsoleSender().sendMessage("Player " + event.getPlayer().getName() + " has already logged in once today.");
            return;
        }
        statsManager.addPlayer(event.getPlayer().getUniqueId());
        statsManager.incrementLogins();
    }
}
