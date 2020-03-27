package de.MangoleHD.IMLobby;

import de.Iclipse.IMAPI.Util.NameTags;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static de.Iclipse.IMAPI.IMAPI.getNameTags;


/* ~Yannick on 09.06.2019 at 11:47 o´ clock
 */
public class Tablist {
    static String header;
    static String footer;
    static String port;
    static String ranks;



    private HashMap<Player, String> rankColor = new HashMap<>();
    public List<NameTags.NameTagMeta> teammeta = new ArrayList<>();


    public Tablist() {
        header = "§8«§5§lIM§r§fLobby§r§8 »";
        footer = "§7Server: §e" + Data.instance.getDataFolder().getAbsoluteFile().getParentFile().getParentFile().getName();
        port = "\n§7Port: §e" + Bukkit.getPort();
        ranks = "§4Admin §cMod \n §3User";
        addTeam(new NameTags.NameTagMeta("01a", "§7[§4Admin§7]§4 ", ""));
        addTeam(new NameTags.NameTagMeta("02b", "§7[§cMod§7]§c ", ""));
        addTeam(new NameTags.NameTagMeta("03c", "§3 ", ""));
        de.Iclipse.IMAPI.Data.nametags = new NameTags(teammeta);

    }

    public void addTeam(NameTags.NameTagMeta nametagmeta){
        if(!teammeta.contains(nametagmeta)){
            teammeta.add(nametagmeta);
        }
    }


    public void setTablist(Player p) {

        if (p.hasPermission("im.tab.serversettings")) {
            p.setPlayerListHeader(header + port);
            p.setPlayerListFooter(ranks + "\n" + footer);
        } else {
            p.setPlayerListHeader(header);
            p.setPlayerListFooter(ranks);
        }
    }


    public void setPlayer(Player p) {
        String team;
        if (p.hasPermission("im.color.admin")) {
            team = "01a";
        } else if (p.hasPermission("im.color.mod")) {
            team = "02b";
        } else  {
            team = "03c";
        }
        getNameTags().addPlayer(team, p.getName());

        getNameTags().updateNameTags();
    }



}
