package com.playtheatria.nessxxiii.stats.utils;

import com.playtheatria.nessxxiii.stats.managers.ConfigManager;
import org.bukkit.Bukkit;

public class Utils {

    public static boolean databaseConfigIsValid(ConfigManager configManager) {
        if (isNullOrEmpty(configManager.getUrl()) || isNullOrEmpty(configManager.getUsername()) || isNullOrEmpty(configManager.getPassword())) {
            validateDatabaseConfigMessage();
            return false;
        }
        return true;
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static void validateDatabaseConfigMessage() {
        Bukkit.getConsoleSender().sendMessage("Database connection information not found in config.yml. Disabling plugin.");
        Bukkit.getConsoleSender().sendMessage("Please add the following to config.yml:");
        Bukkit.getConsoleSender().sendMessage("database:");
        Bukkit.getConsoleSender().sendMessage("  url: <url>");
        Bukkit.getConsoleSender().sendMessage("  username: <username>");
        Bukkit.getConsoleSender().sendMessage("  password: <password>");
    }
}
