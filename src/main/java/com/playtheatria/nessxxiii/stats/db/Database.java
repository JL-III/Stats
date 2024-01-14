package com.playtheatria.nessxxiii.stats.db;

import com.playtheatria.nessxxiii.stats.managers.ConfigManager;

public class Database {

    private final String url;

    private final String username;

    private final String password;

    public Database(ConfigManager configManager) {
        this.url = configManager.getUrl();
        this.username = configManager.getUsername();
        this.password = configManager.getPassword();
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
