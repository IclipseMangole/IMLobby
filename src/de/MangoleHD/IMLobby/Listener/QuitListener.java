package de.MangoleHD.IMLobby.Listener;

import de.MangoleHD.IMLobby.Data;
import de.MangoleHD.IMLobby.Scheduler.Scheduler;
import de.MangoleHD.IMLobby.StaticClasses.getScoreboard;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import static de.MangoleHD.IMLobby.Data.*;
import static de.MangoleHD.IMLobby.Extras.Minigames.MiniArena.finishArena;


public class QuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        e.setQuitMessage(null);
        Player player = e.getPlayer();
        Bukkit.getOnlinePlayers().forEach(entry -> {
            dsp.send(entry, "quit.message", e.getPlayer().getDisplayName());
        });
        if (getScoreboard.boards.containsKey(e.getPlayer())) {
            System.out.println("Scoreboard Destroyed");
            getScoreboard.boards.get(e.getPlayer()).destroy();
        }

        if(Data.waiting.contains(player)){
            waiting.remove(player);
        }

        if(Data.fighting.contains(player)){
            int leaver = fighting.indexOf(player);
            fighting.forEach(player2 -> {
                fighting.set(leaver, player2);
            });
            Bukkit.getOnlinePlayers().forEach(entry -> {
                dsp.send(entry, "miniArena.quit", player.getDisplayName(), fighting.get(leaver).getDisplayName());
            });
            finishArena();
        }

        if (Bukkit.getOnlinePlayers().size() == 0) {
            Scheduler.stopScheduler();
            Scheduler.stopTickScheduler();
        }

    }
}
