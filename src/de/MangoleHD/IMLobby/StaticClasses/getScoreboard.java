package de.MangoleHD.IMLobby.StaticClasses;

import de.Iclipse.IMAPI.Data;
import de.Iclipse.IMAPI.Util.ScoreboardSign;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;

import static de.Iclipse.IMAPI.Functions.MySQL.MySQL_User.getLanguage;

public class getScoreboard {
    public static int ticks = 0;
    public static HashMap<Player, ScoreboardSign> boards = new HashMap<>();
    public static int animation = 0;

    public static void createScoreboard(Player p){
        String a = getAnimation(p);
        ScoreboardSign ss = new ScoreboardSign(p,"§5§lIM§r§fLobby");
        ss.create();
        ss.setLine(0,"§6" + p.getName());
        ss.setLine(1,"" + ChatColor.BLACK);
        ss.setLine(2,"§2Buon Giorno");
        ss.setLine(3,"" + a);
        ss.setLine(4,"" + ChatColor.RED);
        ss.setLine(5,"" + ChatColor.BLUE);
        ss.setLine(6,Data.dsp.get("scoreboard.line.6",getLanguage(UUIDFetcher.getUUID(p.getName()))));
        ss.setLine(7,Data.dsp.get("scoreboard.line.7",getLanguage(UUIDFetcher.getUUID(p.getName()))));
        ss.setLine(8,Data.dsp.get("scoreboard.line.8",getLanguage(UUIDFetcher.getUUID(p.getName()))));
        boards.put(p,ss);
    }

    public static String getAnimation(Player p){
        switch (animation) {
            case 0:
                return Data.dsp.get("scoreboard.animation.1", getLanguage(UUIDFetcher.getUUID(p.getName())));
            case 1:
                return Data.dsp.get("scoreboard.animation.2", getLanguage(UUIDFetcher.getUUID(p.getName())));
            case 2:
                return Data.dsp.get("scoreboard.animation.3", getLanguage(UUIDFetcher.getUUID(p.getName())));
        }
        return null;
    }
}
