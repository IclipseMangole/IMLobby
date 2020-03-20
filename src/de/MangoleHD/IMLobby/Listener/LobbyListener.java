package de.MangoleHD.IMLobby.Listener;

import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.MangoleHD.IMLobby.Scheduler.Scheduler;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import java.util.UUID;

public class LobbyListener implements Listener {

    @EventHandler
    public void Damage(EntityDamageEvent e){
        System.out.println("DamageEvent");
        if(e.getEntity() instanceof Player) {
            Player p = ((Player) e.getEntity()).getPlayer();
            p.sendMessage("Du bekommst Schaden");
            e.setCancelled(true);
            if(e.getCause().equals(EntityDamageEvent.DamageCause.VOID)){
                p.sendMessage("Du wirst in die Base teleportiert");
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

    @EventHandler
    public void BlockBreak(BlockBreakEvent e){
        Player p = e.getPlayer();
        UUID uuid = UUIDFetcher.getUUID(p.getName());
        if(!p.getGameMode().equals(GameMode.CREATIVE)){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void BlockPlace(BlockPlaceEvent e){
        Player p = e.getPlayer();
        UUID uuid = UUIDFetcher.getUUID(p.getName());
        if(!p.getGameMode().equals(GameMode.CREATIVE)){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onSpawn(EntitySpawnEvent e){
        if(!(e.getEntity() instanceof Chicken)){
            e.setCancelled(true);
        }else{
            Animals chicken = (Animals) e.getEntity();
            Scheduler.Killer(chicken);
        }
    }
}
