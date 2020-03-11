package IMLobby.Schilder;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

// Schilder, die einen innerhalb der Lobby teleportieren

public class Schilder_LobbyTp implements Listener {

    //SpawnAussicht
    @EventHandler
    public void SpawnAussicht(PlayerInteractEvent e){
        Player p = e.getPlayer();
        if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            Block b = e.getClickedBlock();
            if(b.getType().equals(Material.OAK_SIGN)){
                Location loc = new Location(p.getWorld(),11,126,11);
                if(b.getLocation().equals(loc)){
                    Location loc2 = new Location(p.getWorld(),11.5,101,9.5,-180,0);
                    p.teleport(loc2);
                    p.playSound(loc2, Sound.ENTITY_ENDERMAN_TELEPORT,1,1);
                }
            }
        }
    }
}
