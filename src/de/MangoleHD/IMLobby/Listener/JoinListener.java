package de.MangoleHD.IMLobby.Listener;

import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.MangoleHD.IMLobby.Functions.Scheduler.Scheduler;
import de.MangoleHD.IMLobby.IMLobby;
import de.MangoleHD.IMLobby.Utilities.getVisibility;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;


public class JoinListener implements Listener {
    private final IMLobby imLobby;

    public JoinListener(IMLobby imLobby) {
        this.imLobby = imLobby;
    }

    @EventHandler
    public void JoinListener(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        UUID uuid = UUIDFetcher.getUUID(p.getName());
        imLobby.getData().getIMAPI().getData().getUserTable().createUser(uuid);
        if (Bukkit.getOnlinePlayers().size() == 1) {
            Scheduler.startScheduler();
            Scheduler.startTickScheduler();
        }

        e.getPlayer().chat("/startInventory");

        imLobby.getData().getIMAPI().getData().getUserSettingsTable().createUserSetting(uuid, "particles", "off");

        imLobby.getData().getIMAPI().getData().getUserSettingsTable().createUserSetting(uuid, "clothing", "off");

        imLobby.getData().getIMAPI().getData().getUserSettingsTable().createUserSetting(uuid, "visibility", "all");

        if (imLobby.getData().getIMAPI().getData().getUserSettingsTable().getString(uuid, "clothing").equals("jumper")) {
            p.setAllowFlight(true);
        } else {
            p.setAllowFlight(false);
        }

        if (imLobby.getData().getIMAPI().getData().getUserSettingsTable().getString(uuid, "visibility").equals("all")) {
            getVisibility.getGreen(p);
        } else if (imLobby.getData().getIMAPI().getData().getUserSettingsTable().getString(uuid, "visibility").equals("friends and teammates")) {
            getVisibility.getPurple(p);
        } else {
            getVisibility.getGray(p);
        }

        e.setJoinMessage(null);

        Bukkit.getOnlinePlayers().forEach(entry -> {
            if (!entry.equals(p)) {
                imLobby.getData().getDispatcher().send(entry, "join.message", p.getDisplayName());
            }
        });


        p.teleport(new Location(p.getWorld(), 0.5, 55, 0.5, 0, 0));
        p.getActivePotionEffects().clear();
        p.teleport(imLobby.getData().getSpawn());
        imLobby.getData().getBossBar().addPlayer(p);

        if (Bukkit.getOnlinePlayers().size() == 1) {
            imLobby.getData().setKilllag(false);
        }
    }
}
