package IMLobby.Listener;

import IMLobby.MySQL.MySQL_LobbySettings;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void JoinListener(PlayerJoinEvent event){
        Player p = event.getPlayer();
        p.chat("/startInventory");
        MySQL_LobbySettings.createUser(UUIDFetcher.getUUID(p.getName()));
    }
}
