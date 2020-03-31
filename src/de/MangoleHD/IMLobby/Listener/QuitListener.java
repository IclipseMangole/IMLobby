package de.MangoleHD.IMLobby.Listener;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import static de.MangoleHD.IMLobby.Data.dsp;


public class QuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        e.setQuitMessage(null);
        Bukkit.getOnlinePlayers().forEach(entry ->{
                dsp.send(entry, "quit.message", e.getPlayer().getDisplayName());
        });
    }
}
