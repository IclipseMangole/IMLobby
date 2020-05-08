package de.MangoleHD.IMLobby.Listener;

import de.MangoleHD.IMLobby.Data;
import de.MangoleHD.IMLobby.StaticClasses.getScoreboard;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import static de.MangoleHD.IMLobby.Data.dsp;
import static de.MangoleHD.IMLobby.Extras.Minigames.MiniArena.clearArena;
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

        if(Data.miniArena.containsKey(player)){
            Data.miniArena.remove(player);
            finishArena(player);
            Data.miniArena.forEach((player2, integer) -> {
                finishArena(player2);
            });
        }


    }
}
