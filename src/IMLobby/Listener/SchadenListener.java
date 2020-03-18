package IMLobby.Listener;

import net.minecraft.server.v1_15_R1.SoundEffect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import javax.swing.text.html.parser.Entity;

public class SchadenListener implements Listener {

    @EventHandler
    public void Damage(EntityDamageEvent e){
        if(e.getEntity() instanceof Player) {
            Player p = ((Player) e.getEntity()).getPlayer();
            e.setCancelled(true);
            if(e.getCause().equals(EntityDamageEvent.DamageCause.VOID)){
                Location Spawn = new Location(p.getWorld(),0.5,4,0.5,180,0);
                p.teleport(Spawn);
                p.playSound(Spawn, Sound.ENTITY_ENDERMAN_TELEPORT,1,1);
            }
        }
    }

    @EventHandler
    public void Hunger(FoodLevelChangeEvent e){
        if(e.getEntity() instanceof Player){
            Player p = ((Player) e.getEntity()).getPlayer();
            e.setCancelled(true);
            p.setFoodLevel(20);
        }
    }
}
