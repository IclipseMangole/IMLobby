package de.MangoleHD.IMLobby.StaticClasses;

import de.Iclipse.IMAPI.Database.User;
import de.Iclipse.IMAPI.Util.ScoreboardSign;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashMap;

import static de.MangoleHD.IMLobby.Data.dsp;

public class getScoreboard {
    public static HashMap<Player, ScoreboardSign> boards = new HashMap<>();

    public static void createScoreboard(Player p) {

        ScoreboardSign ss = new ScoreboardSign(p, "§6" + p.getName());
        ss.create();
        ss.setLine(0, "" + ChatColor.BLACK);
        ss.setLine(1, dsp.get("scoreboard.schnitzel", p));
        ss.setLine(2, "§f" + User.getSchnitzel(UUIDFetcher.getUUID(p.getName())));
        ss.setLine(3, "" + ChatColor.AQUA);
        ss.setLine(4, dsp.get("scoreboard.gametime", p));
        ss.setLine(5, "§f" + (int) ((User.getOnlinetime(UUIDFetcher.getUUID(p.getName())) + (System.currentTimeMillis() - de.Iclipse.IMAPI.Data.onlinetime.get(p))) / (1000 * 60 * 60)) + " " + dsp.get("unit.hours", p));
        ss.setLine(6, "" + ChatColor.DARK_BLUE);
        ss.setLine(7, dsp.get("scoreboard.friends", p));
        ss.setLine(8, "§f0/0");
        ss.setLine(9, "" + ChatColor.DARK_AQUA);
        ss.setLine(10, "§7 ——————————" + ChatColor.LIGHT_PURPLE);
        ss.setLine(11, "§7| §5§lIclipse§r§fMangole§7 |");
        ss.setLine(12, "§7 ——————————" + ChatColor.DARK_GREEN);
        boards.put(p, ss);

    }

    public static void updateScoreboard() {
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
        boards.forEach((p, ss) -> {
            ss.create();
            ss.setLine(0, "" + ChatColor.BLACK);
            ss.setLine(1, dsp.get("scoreboard.schnitzel", p));
            ss.setLine(2, "§f" + User.getSchnitzel(UUIDFetcher.getUUID(p.getName())));
            ss.setLine(3, "" + ChatColor.AQUA);
            ss.setLine(4, dsp.get("scoreboard.gametime", p));
            ss.setLine(5, "§f" + (int) ((User.getOnlinetime(UUIDFetcher.getUUID(p.getName())) + (System.currentTimeMillis() - de.Iclipse.IMAPI.Data.onlinetime.get(p))) / (1000 * 60 * 60)) + " " + dsp.get("unit.hours", p));
            ss.setLine(6, "" + ChatColor.DARK_BLUE);
            ss.setLine(7, dsp.get("scoreboard.friends", p));
            ss.setLine(8, "§f0/0");
            ss.setLine(9, "" + ChatColor.DARK_AQUA);
            ss.setLine(10, "§7 ——————————" + ChatColor.LIGHT_PURPLE);
            ss.setLine(11, "§7| §5§lIclipse§r§fMangole§7 |");
            ss.setLine(12, "§7 ——————————" + ChatColor.DARK_GREEN);
        });
    }

}
