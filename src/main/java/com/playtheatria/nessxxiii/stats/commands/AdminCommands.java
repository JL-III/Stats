package com.playtheatria.nessxxiii.stats.commands;

import com.playtheatria.nessxxiii.stats.managers.StatManager;
import com.playtheatria.nessxxiii.stats.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

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
        sender.sendMessage("Number of logins: " + statManager.getLogins());
        sender.sendMessage("Time left in day: " + Utils.calculateDelayUntilEndOfDay() + " seconds");
        return true;
    }
}
