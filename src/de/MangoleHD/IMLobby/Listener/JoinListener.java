package de.MangoleHD.IMLobby.Listener;

import de.Iclipse.IMAPI.Functions.MySQL.MySQL_UserSettings;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.MangoleHD.IMLobby.StaticClasses.getClothing;
import de.MangoleHD.IMLobby.StaticClasses.getScoreboard;
import de.MangoleHD.IMLobby.StaticClasses.getVisibility;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

import static de.MangoleHD.IMLobby.Data.dsp;
import static de.MangoleHD.IMLobby.Data.tablist;


public class JoinListener implements Listener {

    @EventHandler
    public void JoinListener(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        UUID uuid = UUIDFetcher.getUUID(p.getName());

        p.chat("/startInventory");

        MySQL_UserSettings.createUserSetting(uuid, "particles", "off");

        MySQL_UserSettings.createUserSetting(uuid, "clothing", "off");

        MySQL_UserSettings.createUserSetting(uuid, "visibility", "all");

        if (MySQL_UserSettings.getString(uuid, "clothing").equals("jumper")) {
            p.setAllowFlight(true);
        } else {
            p.setAllowFlight(false);
        }

        if (MySQL_UserSettings.getString(uuid, "visibility").equals("all")) {
            getVisibility.getGreen(p);
        } else if (MySQL_UserSettings.getString(uuid, "visibility").equals("friends and teammates")) {
            getVisibility.getPurple(p);
        } else {
            getVisibility.getGray(p);
        }

        tablist.setPlayer(e.getPlayer());

        tablist.setTablist(p);

        e.setJoinMessage(null);

        Bukkit.getOnlinePlayers().forEach(entry -> {
            if (!entry.equals(p)) {
                dsp.send(entry, "join.message", p.getDisplayName());
            }
        });

        getClothing.onCloth(p);

        getScoreboard.createScoreboard(p);
    }
}
