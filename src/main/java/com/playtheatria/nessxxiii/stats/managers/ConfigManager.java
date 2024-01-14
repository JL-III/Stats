package com.playtheatria.nessxxiii.stats.managers;

import com.playtheatria.nessxxiii.stats.Stats;

public class ConfigManager {

        private final String url;

        private final String username;

        private final String password;

        public ConfigManager(Stats plugin) {
            this.url = plugin.getConfig().getString("database.url");
            this.username = plugin.getConfig().getString("database.username");
            this.password = plugin.getConfig().getString("database.password");
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
