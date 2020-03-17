package IMLobby.Listener;

import de.Iclipse.IMAPI.Functions.MySQL.MySQL_UserSettings;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static de.Iclipse.IMAPI.Data.dsp;
import static de.Iclipse.IMAPI.Data.tablist;

public class JoinListener implements Listener {

    @EventHandler
    public void JoinListener(PlayerJoinEvent e){
        Player p = e.getPlayer();
        p.chat("/startInventory");
        MySQL_UserSettings.createUserSetting(UUIDFetcher.getUUID(p.getName()),"particles","off");
        MySQL_UserSettings.createUserSetting(UUIDFetcher.getUUID(p.getName()),"clothing","off");
        tablist.setPlayer(e.getPlayer());
        tablist.setTablist(p);
        e.setJoinMessage(null);
        Bukkit.getOnlinePlayers().forEach(entry ->{
            if(!entry.equals(p)){
                dsp.send(entry, "join.message", p.getDisplayName());
            }
        });
    }
}
