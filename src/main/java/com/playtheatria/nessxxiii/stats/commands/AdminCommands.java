package com.playtheatria.nessxxiii.stats.commands;

import com.playtheatria.nessxxiii.stats.managers.StatManager;
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

    private final StatManager statManager;

    public AdminCommands(StatManager statManager) {
        this.statManager = statManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!sender.hasPermission("stats.admin")) {
            sender.sendMessage("You do not have permission to use this command.");
            return true;
        }
        if (args.length != 0) {
            sender.sendMessage("Invalid number of arguments.");
            return true;
        }
        sender.sendMessage(ChatColor.LIGHT_PURPLE + "<----------------- debug info start ----------------->");
        sender.sendMessage("current tasks: ");
        for (BukkitTask task : Bukkit.getScheduler().getPendingTasks()) {
            if (task.getOwner().getName().equalsIgnoreCase("stats")) {
                sender.sendMessage(task.getOwner().getName().toLowerCase() + " - task id: " + task.getTaskId());
            }
        }
        sender.sendMessage("yesterday's unique logins: " + statManager.getYesterdayLogins());
        sender.sendMessage("players logged in today: ");
        for (UUID uuid : statManager.getPlayersList()) {
            sender.sendMessage("- " + Bukkit.getOfflinePlayer(uuid).getName());
        }
        sender.sendMessage("number of unique logins: " + statManager.getLogins());
        sender.sendMessage("time left in day: "
                + Utils.calculateDelayUntilEndOfDay() / 3600 + " hours, "
                + (Utils.calculateDelayUntilEndOfDay() % 3600) / 60 + " minutes, "
                + (Utils.calculateDelayUntilEndOfDay() % 60) + " seconds");
        sender.sendMessage(ChatColor.LIGHT_PURPLE + "<------------------ debug info end ------------------>");
        return true;
    }
}
