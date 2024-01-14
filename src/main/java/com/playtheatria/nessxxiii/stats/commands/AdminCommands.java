package com.playtheatria.nessxxiii.stats.commands;

import com.playtheatria.nessxxiii.stats.events.DayChangeEvent;
import com.playtheatria.nessxxiii.stats.managers.StatsManager;
import com.playtheatria.nessxxiii.stats.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class AdminCommands implements CommandExecutor {

    private final StatsManager statsManager;

    public AdminCommands(StatsManager statsManager) {
        this.statsManager = statsManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!sender.hasPermission("stats.admin")) {
            sender.sendMessage("You do not have permission to use this command.");
            return true;
        }
        if (args.length == 0) {
            sender.sendMessage(ChatColor.LIGHT_PURPLE + "<----------------- debug info start ----------------->");
            sender.sendMessage("current day: " + statsManager.getLocalDate());
            sender.sendMessage("current tasks: ");
            for (BukkitTask task : Bukkit.getScheduler().getPendingTasks()) {
                if (task.getOwner().getName().equalsIgnoreCase("stats")) {
                    sender.sendMessage("  - " + task.getOwner().getName().toLowerCase() + " - task id: " + task.getTaskId());
                }
            }
            sender.sendMessage("yesterday's unique logins: " + statsManager.getYesterdayLogins());
            sender.sendMessage("players logged in today: ");
            for (UUID uuid : statsManager.getPlayersList()) {
                sender.sendMessage("  - " + Bukkit.getOfflinePlayer(uuid).getName());
            }
            sender.sendMessage("number of unique logins: " + statsManager.getLogins());
            sender.sendMessage(ChatColor.LIGHT_PURPLE + "<------------------ debug info end ------------------>");
            return true;
        }
        if (args.length == 1 && args[0].equalsIgnoreCase("event")) {
            sender.sendMessage("firing new day change event");
            Bukkit.getPluginManager().callEvent(new DayChangeEvent());
            return true;
        }
        if (args.length == 1 && args[0].equalsIgnoreCase("add")) {
            sender.sendMessage("incrementing login count");
            statsManager.incrementLogins();
            return true;
        }

        return true;
    }
}
