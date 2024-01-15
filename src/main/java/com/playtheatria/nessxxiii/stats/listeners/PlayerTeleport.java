package com.playtheatria.nessxxiii.stats.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

import java.util.Objects;

public class PlayerTeleport implements Listener {

    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent event) {
        if (event.isCancelled()) return;
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.hasPermission("stats.admin")) {
                player.sendMessage(ChatColor.GREEN + event.getPlayer().getName()
                        + " teleported " + Objects.requireNonNull(event.getFrom().getWorld()).getName() + " x:" + event.getFrom().getBlockX() + " y:" + event.getFrom().getBlockY() + " z:" + event.getFrom().getBlockZ()
                        + " to " + Objects.requireNonNull(Objects.requireNonNull(event.getTo()).getWorld()).getName() + " x:" + event.getTo().getBlockX() + " y:" + event.getTo().getBlockY() + " z:" + event.getTo().getBlockZ());
            }
        }
    }
}
