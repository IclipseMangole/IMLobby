package de.MangoleHD.IMLobby.Listener;

import de.MangoleHD.IMLobby.Data;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import static de.MangoleHD.IMLobby.Data.dsp;

public class LangListener implements Listener {
    @EventHandler
    public void onChange(AsyncPlayerChatEvent e) {
        if (e.getMessage().contains("/lang ")) {
            if(!Data.fighting.contains(e.getPlayer())) {
                e.getPlayer().chat("/startInventory");
            }else{
                dsp.send(e.getPlayer(),"miniArena.langChange");
                e.setCancelled(true);
            }
        }
    }
}
