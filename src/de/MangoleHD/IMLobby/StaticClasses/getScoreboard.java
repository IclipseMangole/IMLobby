package de.MangoleHD.IMLobby.StaticClasses;

import de.Iclipse.IMAPI.Util.ScoreboardSign;
import de.MangoleHD.IMLobby.Data;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class getScoreboard {
    public static int ticks = 0;
    public static HashMap<Player, ScoreboardSign> boards = new HashMap<>();
    public static int animation = 0;

    public static void createScoreboard(Player p) {
        String a = getAnimation(p);
        ScoreboardSign ss = new ScoreboardSign(p, "§5§lIM§r§fLobby");
        ss.create();
        ss.setLine(0, "§6" + p.getName());
        ss.setLine(1, "" + ChatColor.BLACK);
        ss.setLine(2, "§2Buon Giorno");
        ss.setLine(3, "" + a);
        ss.setLine(4, "" + ChatColor.RED);
        ss.setLine(5, "" + ChatColor.BLUE);
        ss.setLine(6, Data.dsp.get("scoreboard.line.6", p));
        ss.setLine(7, Data.dsp.get("scoreboard.line.7", p));
        ss.setLine(8, Data.dsp.get("scoreboard.line.8", p));
        boards.put(p, ss);
    }

    public static String getAnimation(Player p) {
        switch (animation) {
            case 0:
                return Data.dsp.get("scoreboard.animation.1", p);
            case 1:
                return Data.dsp.get("scoreboard.animation.2", p);
            case 2:
                return Data.dsp.get("scoreboard.animation.3", p);
        }
        return null;
    }
}
