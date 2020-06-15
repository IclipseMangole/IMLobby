package de.MangoleHD.IMLobby.StaticClasses;

import de.Iclipse.IMAPI.Database.Friend;
import de.Iclipse.IMAPI.Database.User;
import de.Iclipse.IMAPI.Util.ScoreboardSign;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashMap;

import static de.MangoleHD.IMLobby.Data.dsp;

public class getScoreboard {
    public static HashMap<Player, ScoreboardSign> boards = new HashMap<>();

    public static void updateScoreboard() {

        ScoreboardSign ss;
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (boards.containsKey(p)) {
                ss = boards.get(p);
            } else {
                ss = new ScoreboardSign(p, "§6" + p.getName());
                ss.create();
                for (int i = 0; i < 15; i++) {
                    ss.setLine(i, "");
                    ss.removeLine(i);
                }
            }
            ss.create();
            for (int i = 0; i < 15; i++) {
                ss.removeLine(i);
            }
            ss.setLine(0, "" + ChatColor.BLACK);
            ss.setLine(1, dsp.get("scoreboard.schnitzel", p));
            ss.setLine(2, "§f" + User.getSchnitzel(UUIDFetcher.getUUID(p.getName())));
            ss.setLine(3, "" + ChatColor.AQUA);
            ss.setLine(4, dsp.get("scoreboard.gametime", p));
            ss.setLine(5, "§f" + (int) ((User.getOnlinetime(UUIDFetcher.getUUID(p.getName())) + (System.currentTimeMillis() - de.Iclipse.IMAPI.Data.onlinetime.get(p))) / (1000 * 60 * 60)) + " " + dsp.get("unit.hours", p));
            ss.setLine(6, "" + ChatColor.DARK_BLUE);
            ss.setLine(7, dsp.get("scoreboard.friends", p));
            ss.setLine(8, "§f" + Friend.getOnlineFriends(UUIDFetcher.getUUID(p.getName())).size() + "/" + Friend.getFriends(UUIDFetcher.getUUID(p.getName())).size());
            ss.setLine(9, "" + ChatColor.DARK_AQUA);
            ss.setLine(10, "§7 ——————————" + ChatColor.LIGHT_PURPLE);
            ss.setLine(11, "§7| §5§lIclipse§r§fMangole§7 |");
            ss.setLine(12, "§7 ——————————" + ChatColor.DARK_GREEN);
        }
    }

}
