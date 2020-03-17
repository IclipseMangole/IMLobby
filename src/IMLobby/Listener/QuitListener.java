package IMLobby.Listener;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;

import static IMLobby.Data.dsp;

public class QuitListener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        Bukkit.getOnlinePlayers().forEach(entry ->{
                dsp.send(entry, "quit.message", e.getPlayer().getDisplayName());
        });
    }
}
