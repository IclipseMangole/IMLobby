package de.MangoleHD.IMLobby.Listener;

import de.MangoleHD.IMLobby.Data;
import de.MangoleHD.IMLobby.IMLobby;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;


public class LangListener implements Listener {
    private IMLobby imLobby;

    public LangListener(IMLobby imLobby) {
        this.imLobby = imLobby;
    }

    @EventHandler
    public void onChange(PlayerCommandPreprocessEvent e) {
        if (e.getMessage().contains("/lang ")) {
            if (!imLobby.getData().getFighting().contains(e.getPlayer())) {
                Bukkit.getScheduler().runTaskLater(imLobby, () -> {
                    e.getPlayer().chat("/startInventory");
                    imLobby.getData().getBossBar().addPlayer(e.getPlayer());
                }, 5);
            } else {
                imLobby.getData().getDispatcher().send(e.getPlayer(), "miniArena.langChange");
            }
        }
    }
}
