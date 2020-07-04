package de.MangoleHD.IMLobby.StaticClasses;

import de.Iclipse.IMAPI.Database.Friend;
import de.Iclipse.IMAPI.Database.User;
import de.Iclipse.IMAPI.Util.ScoreboardSign;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.HashMap;

import static de.MangoleHD.IMLobby.Data.dsp;

public class getScoreboard {
    public static HashMap<Player, ScoreboardSign> boards = new HashMap<>();


    public static void updateScoreboard() {
        Bukkit.getOnlinePlayers().forEach(player -> {
            Scoreboard scoreboard = player.getScoreboard();
            Objective objective;
            Team schnitzel, onlinetime, friends;
            if (scoreboard.getObjective(player.getName()) == null) {
                objective = scoreboard.registerNewObjective(player.getName(), "stats", "§6" + player.getName());
                objective.setDisplayName("§6" + player.getName());
                objective.setDisplaySlot(DisplaySlot.SIDEBAR);

                schnitzel = scoreboard.registerNewTeam("schnitzel");
                schnitzel.addEntry(ChatColor.AQUA.toString());
                onlinetime = scoreboard.registerNewTeam("onlinetime");
                onlinetime.addEntry(ChatColor.BLACK.toString());
                friends = scoreboard.registerNewTeam("friends");
                friends.addEntry(ChatColor.BLUE.toString());

                objective.getScore(ChatColor.DARK_AQUA.toString()).setScore(12);
                objective.getScore(dsp.get("scoreboard.schnitzel", player)).setScore(11);
                objective.getScore(ChatColor.AQUA.toString()).setScore(10);

                objective.getScore(ChatColor.DARK_BLUE.toString()).setScore(9);
                objective.getScore(dsp.get("scoreboard.gametime", player)).setScore(8);
                objective.getScore(ChatColor.BLACK.toString()).setScore(7);

                objective.getScore(ChatColor.DARK_GRAY.toString()).setScore(6);
                objective.getScore(dsp.get("scoreboard.friends", player)).setScore(5);
                objective.getScore(ChatColor.BLUE.toString()).setScore(4);

                objective.getScore(ChatColor.DARK_GREEN.toString()).setScore(3);
                if (player.getName().equals("Iclipse")) {
                    objective.getScore("§7╔════════╗").setScore(2);
                    objective.getScore("§7║§5§lIclipse§r§fMangole§7 ║").setScore(1);
                    objective.getScore("§7╚════════╝").setScore(0);
                } else {
                    objective.getScore("§7╔═════════╗").setScore(2);
                    objective.getScore("§7║ §5Iclipse§r§fMangole§7  ║").setScore(1);
                    objective.getScore("§7╚═════════╝").setScore(0);
                }
            } else {
                schnitzel = scoreboard.getTeam("schnitzel");
                onlinetime = scoreboard.getTeam("onlinetime");
                friends = scoreboard.getTeam("friends");
            }

            schnitzel.setPrefix("§f" + User.getSchnitzel(UUIDFetcher.getUUID(player)));
            onlinetime.setPrefix("§f" + (int) ((User.getOnlinetime(UUIDFetcher.getUUID(player)) + (System.currentTimeMillis() - de.Iclipse.IMAPI.Data.onlinetime.get(player))) / (1000 * 60 * 60)) + " " + dsp.get("unit.hours", player));
            friends.setPrefix("§f" + Friend.getOnlineFriends(UUIDFetcher.getUUID(player)).size() + "/" + Friend.getFriends(UUIDFetcher.getUUID(player)).size());

        });




        /*
        ScoreboardSign ss;
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (boards.containsKey(p)) {
                ss = boards.get(p);
            } else {
                ss = new ScoreboardSign(p, "§6" + p.getName());
                for (int i = 0; i < 15; i++) {
                    ss.setLine(i, "");
                    ss.removeLine(i);
                }
            }
            ss.create();
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
         */
    }

}
