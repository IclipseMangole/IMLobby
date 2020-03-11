package IMLobby.Druckplatten;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

// Diese Druckplatten teleportieren Spieler

public class Druckplatten_Tp implements Listener {

    //Düsterwald
    @EventHandler
    public void SpawnAussicht(PlayerInteractEvent e){
        Player p = e.getPlayer();
        if(e.getAction().equals(Action.PHYSICAL)){
            if(e.getClickedBlock().getType().equals(Material.SPRUCE_PRESSURE_PLATE)) {
                Location loc = new Location(e.getClickedBlock().getWorld(),13,108,-16);
                if (e.getClickedBlock().getLocation().equals(loc)) {
                    Location loc2 = new Location(p.getWorld(),11.5,126,9.5,0,0);
                    p.teleport(loc2);
                    p.playSound(loc2, Sound.ENTITY_ENDERMAN_TELEPORT,1,1);
                }
            }
        }
    }
}
