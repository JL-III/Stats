package com.playtheatria.nessxxiii.stats.managers;

import com.playtheatria.nessxxiii.stats.Stats;
import com.playtheatria.nessxxiii.stats.time.DailyTimer;

import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class StatManager {

    private DailyTimer dailyTimer;

    private final CopyOnWriteArrayList<UUID> playersList = new CopyOnWriteArrayList<>();

    private int logins;

    private int yesterdayLogins;

    public StatManager(Stats plugin) {
        this.dailyTimer = new DailyTimer(plugin);
        this.logins = 0;
        this.yesterdayLogins = 0;
    }

    public void setTimer(DailyTimer dailyTimer) {
        this.dailyTimer = dailyTimer;
    }

    public long getTimeLeft() {
        return dailyTimer.getTimeLeft();
    }

    public int getLogins() {
        return logins;
    }

    public void incrementLogins() {
        ++logins;
    }

    public void resetLogins() {
        logins = 0;
    }

    public void addPlayer(UUID uuid) {
        playersList.add(uuid);
    }

    public void resetPlayersList() {
        playersList.clear();
    }

    public CopyOnWriteArrayList<UUID> getPlayersList() {
        return playersList;
    }

    public int getYesterdayLogins() {
        return yesterdayLogins;
    }

    public void setYesterdayLogins(int yesterdayLogins) {
        this.yesterdayLogins = yesterdayLogins;
    }
}
