package com.playtheatria.nessxxiii.stats.listeners;

import com.playtheatria.nessxxiii.stats.managers.StatManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class PlayerLogIn implements Listener {

    private final StatManager statManager;

    public PlayerLogIn(StatManager statManager) {
        this.statManager = statManager;
    }

    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event) {
        statManager.incrementLogins();
    }

}
