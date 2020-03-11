package IMLobby.Druckplatten;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

// Diese Druckplatten in der Lobby geben einem Spieler für kurze Zeit Boosts in der Lobby (bspw. Schnelligkeit)

public class Druckplatten_Bonus implements Listener {

    // Düsterwald
    @EventHandler
    public void Düsterwald(PlayerInteractEvent ev) {
        Player p = ev.getPlayer();
        if(ev.getAction().equals(Action.PHYSICAL)){
            if(ev.getClickedBlock().getType().equals(Material.SPRUCE_PRESSURE_PLATE)) {
                Location loc = new Location(ev.getClickedBlock().getWorld(),20,101,-7);
                if (ev.getClickedBlock().getLocation().equals(loc)) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2400, 2));
                }
            }
        }
    }
}
