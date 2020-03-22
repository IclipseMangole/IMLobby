package de.MangoleHD.IMLobby.StaticClasses;

import de.Iclipse.IMAPI.Util.ScoreboardSign;
import de.MangoleHD.IMLobby.Data;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;

public class getScoreboard {
    public static int ticks = 0;
    public static HashMap<Player, ScoreboardSign> boards = new HashMap<>();
    public static int animation = 0;
    public static String a0 ="§fIch";
    public static String a1 ="§lBins";
    public static String a2 ="§4§l!TIM!";

    public static void createScoreboard(Player p){
        String a = getAnimation();
        ScoreboardSign ss = new ScoreboardSign(p,"§5§lIM§r§fLobby");
        ss.create();
        ss.setLine(0,"§6" + p.getName());
        ss.setLine(1,"   " + ChatColor.BLACK);
        ss.setLine(2,"§2Buon Giorno");
        ss.setLine(3,"" + a);
        ss.setLine(4,"§l  ");
        ss.setLine(5,"§l   ");
        ss.setLine(6,"§fSie spielen hier auf");
        ss.setLine(7,"§c§lMEINEM");
        ss.setLine(8,"§r§fServer!!!");
        boards.put(p,ss);
    }

    public static String getAnimation(){
        switch (animation) {
            case 0:
                return a0;
            case 1:
                return a1;
            case 2:
                return a2;
        }
        return null;
    }
}
