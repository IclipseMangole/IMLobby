package de.MangoleHD.IMLobby.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class LangListener implements Listener {
    @EventHandler
    public void onChange(AsyncPlayerChatEvent e) {
        if (e.getMessage().contains("/lang ")) {
            e.getPlayer().chat("/startInventory");
        }
    }
}
