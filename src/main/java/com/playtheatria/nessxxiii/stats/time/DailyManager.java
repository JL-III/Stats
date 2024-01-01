package com.playtheatria.nessxxiii.stats.time;

import com.playtheatria.nessxxiii.stats.Stats;

public class DailyManager {

    private DailyTimer timer;

    public DailyManager(Stats plugin) {
        this.timer = new DailyTimer(plugin);
    }

    public void setTimer(DailyTimer timer) {
        this.timer = timer;
    }

    public long getTimeLeft() {
        return timer.getTimeLeft();
    }
}
