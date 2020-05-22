package de.MangoleHD.IMLobby.Extras.Broadcasts;

import org.bukkit.boss.BarColor;

public class BossBarBroadcast {
    private BarColor color;
    private String title;

    public BossBarBroadcast(BarColor color, String title) {
        this.color = color;
        this.title = title;
    }

    public BarColor getColor() {
        return color;
    }

    public void setColor(BarColor color) {
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
