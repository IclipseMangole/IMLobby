package de.MangoleHD.IMLobby.Listener;

import de.MangoleHD.IMLobby.Data;
import de.MangoleHD.IMLobby.Functions.Scheduler.Scheduler;
import de.MangoleHD.IMLobby.IMLobby;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;


public class QuitListener implements Listener {
    
    private final IMLobby imLobby;

    public QuitListener(IMLobby imLobby) {
        this.imLobby = imLobby;
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        e.setQuitMessage(null);
        Player player = e.getPlayer();
        for (Player entry1 : Bukkit.getOnlinePlayers()) {
            imLobby.getData().getDispatcher().send(entry1, "quit.message", e.getPlayer().getDisplayName());
        }


        if (imLobby.getData().getWaiting().contains(player)) {
            imLobby.getData().getWaiting().remove(player);
        }

        if (imLobby.getData().getFighting().contains(player)) {
            int leaver = imLobby.getData().getFighting().indexOf(player);
            imLobby.getData().getFighting().forEach(player2 -> {
                imLobby.getData().getFighting().set(leaver, player2);
            });
            Bukkit.getOnlinePlayers().forEach(entry -> {
                imLobby.getData().getDispatcher().send(entry, "miniArena.quit", player.getDisplayName(), imLobby.getData().getFighting().get(leaver).getDisplayName());
            });
            imLobby.getData().getMiniArena().finishArena();
        }

        System.out.println(Bukkit.getOnlinePlayers().size());
        if (Bukkit.getOnlinePlayers().size() == 1) {
            System.out.println("Scheduler wird gestoppt!");
            Scheduler.stopScheduler();
            Scheduler.stopTickScheduler();
        }

    }
}
