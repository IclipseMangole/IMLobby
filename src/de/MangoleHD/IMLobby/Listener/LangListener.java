package de.MangoleHD.IMLobby.Listener;

import de.MangoleHD.IMLobby.Data;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import static de.MangoleHD.IMLobby.Data.dsp;

public class LangListener implements Listener {
    @EventHandler
    public void onChange(PlayerCommandPreprocessEvent e) {
        if (e.getMessage().contains("/lang ")) {
            if (!Data.fighting.contains(e.getPlayer())) {
                Bukkit.getScheduler().runTaskLater(Data.instance, () -> {
                    e.getPlayer().chat("/startInventory");
                    Data.bossBar.addPlayer(e.getPlayer());
                }, 5);
            } else {
                dsp.send(e.getPlayer(), "miniArena.langChange");
            }
        }
    }
}
