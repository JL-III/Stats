package com.playtheatria.nessxxiii.stats.commands;

import com.playtheatria.nessxxiii.stats.managers.StatManager;
import com.playtheatria.nessxxiii.stats.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitTask;

public class AdminCommands implements CommandExecutor {

    private StatManager statManager;

    public AdminCommands(StatManager statManager) {
        this.statManager = statManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("stats.admin")) {
            sender.sendMessage("You do not have permission to use this command.");
            return true;
        }
        if (args.length != 0) {
            sender.sendMessage("Invalid number of arguments.");
            return true;
        }
        sender.sendMessage(ChatColor.LIGHT_PURPLE + "<----------------- debug info start ----------------->");
        for (BukkitTask task : Bukkit.getScheduler().getPendingTasks()) {
            if (task.getOwner().getName().equalsIgnoreCase("stats")) {
                sender.sendMessage("current tasks: " + task.getOwner().getName() + " - task id: " + task.getTaskId());
            }
        }
        sender.sendMessage("number of unique logins: " + statManager.getLogins());
        sender.sendMessage("time left in day: " + Utils.calculateDelayUntilEndOfDay() + " seconds");
        sender.sendMessage(ChatColor.LIGHT_PURPLE + "<------------------ debug info end ------------------>");
        return true;
    }
}
