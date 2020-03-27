package de.MangoleHD.IMLobby.StaticClasses;

import de.Iclipse.IMAPI.Util.ScoreboardSign;
import de.MangoleHD.IMLobby.Data;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import java.util.HashMap;

public class getScoreboard {
    public static int animation = 0;
    public static HashMap<Player, ScoreboardSign> boards = new HashMap<>();

    public static void createScoreboard(Player p) {
        int max = 15;
        /*
        Scoreboard board = p.getScoreboard();
        Objective obj = board.getObjective("Lobby") != null ? board.getObjective("Lobby") : board.registerNewObjective("Lobby", "aaa", "§5§lIM§r§fLobby");
        if(obj.getDisplaySlot() != DisplaySlot.SIDEBAR){
            obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        }
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.getScore("§6" + p.getName()).setScore(8);
        obj.getScore("" + ChatColor.BLACK).setScore(7);
        obj.getScore("§2Buon Giorno").setScore(6);
        obj.getScore("" + getAnimation(p, 0) + ChatColor.DARK_BLUE).setScore(5);
        obj.getScore("" + getAnimation(p, 1) + ChatColor.RED).setScore(4);
        obj.getScore("" + getAnimation(p, 2) + ChatColor.BLUE).setScore(3);
        obj.getScore(Data.dsp.get("scoreboard.line.6", p)).setScore(2);
        obj.getScore(Data.dsp.get("scoreboard.line.7", p)).setScore(1);
        obj.getScore(Data.dsp.get("scoreboard.line.8", p)).setScore(0);
        p.setScoreboard(board);
        */
        ScoreboardSign ss = new ScoreboardSign(p, "§5§lIM§r§fLobby");
        ss.create();
        ss.setLine(0, "§6" + p.getName());
        ss.setLine(1, "" + ChatColor.BLACK);
        ss.setLine(2, "§2Buon Giorno");
        ss.setLine(3, "" + getAnimation(p, 0) + ChatColor.DARK_BLUE);
        ss.setLine(4, "" + getAnimation(p, 1) + ChatColor.RED);
        ss.setLine(5, "" + getAnimation(p, 2) + ChatColor.BLUE);
        ss.setLine(6, Data.dsp.get("scoreboard.line.6", p));
        ss.setLine(7, Data.dsp.get("scoreboard.line.7", p));
        ss.setLine(8, Data.dsp.get("scoreboard.line.8", p));
        boards.put(p, ss);

    }

    public static void updateScoreboard(Player p){
        /*
        Scoreboard board = p.getScoreboard();
        Objective obj = board.getObjective("Lobby") != null ? board.getObjective("Lobby") : board.registerNewObjective("Lobby", "aaa", "§5§lIM§r§fLobby");
        obj.getScore("§6" + p.getName()).setScore(8);
        obj.getScore("" + ChatColor.BLACK).setScore(7);
        obj.getScore("§2Buon Giorno").setScore(6);
        obj.getScore("" + getAnimation(p, 0) + ChatColor.DARK_BLUE).setScore(5);
        obj.getScore("" + getAnimation(p, 1) + ChatColor.RED).setScore(4);
        obj.getScore("" + getAnimation(p, 2) + ChatColor.BLUE).setScore(3);
        obj.getScore(Data.dsp.get("scoreboard.line.6", p)).setScore(2);
        obj.getScore(Data.dsp.get("scoreboard.line.7", p)).setScore(1);
        obj.getScore(Data.dsp.get("scoreboard.line.8", p)).setScore(0);
        p.setScoreboard(board);
        */
        ScoreboardSign ss = boards.get(p);
        ss.create();
        ss.setLine(0, "§6" + p.getName());
        ss.setLine(1, "" + ChatColor.BLACK);
        ss.setLine(2, "§2Buon Giorno");
        ss.setLine(3, "" + getAnimation(p, 0) + ChatColor.DARK_BLUE);
        ss.setLine(4, "" + getAnimation(p, 1) + ChatColor.RED);
        ss.setLine(5, "" + getAnimation(p, 2) + ChatColor.BLUE);
        ss.setLine(6, Data.dsp.get("scoreboard.line.6", p));
        ss.setLine(7, Data.dsp.get("scoreboard.line.7", p));
        ss.setLine(8, Data.dsp.get("scoreboard.line.8", p));
    }

    public static String getAnimation(Player p, int line) {
        if(line == animation) {
            switch (animation) {
                case 0:
                    return Data.dsp.get("scoreboard.animation.1", p);
                case 1:
                    return Data.dsp.get("scoreboard.animation.2", p);
                case 2:
                    return Data.dsp.get("scoreboard.animation.3", p);
            }
        }
        return "";
    }
}
