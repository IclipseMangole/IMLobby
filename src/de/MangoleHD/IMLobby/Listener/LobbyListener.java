package de.MangoleHD.IMLobby.Listener;

import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.MangoleHD.IMLobby.Data;
import de.MangoleHD.IMLobby.IMLobby;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;

import java.util.UUID;

public class LobbyListener implements Listener {

    private IMLobby imLobby;

    public LobbyListener(IMLobby imLobby) {
        this.imLobby = imLobby;
    }

    @EventHandler
    public void Damage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = ((Player) e.getEntity()).getPlayer();
            if (!imLobby.getData().getFighting().contains(p)) {
                if (e.getCause().equals(EntityDamageEvent.DamageCause.VOID)) {
                    p.teleport(imLobby.getData().getSpawn());
                    p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
                    e.setDamage(0);
                    p.setHealth(20);
                } else {
                    e.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void Hunger(FoodLevelChangeEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = ((Player) e.getEntity()).getPlayer();
            if (!imLobby.getData().getFighting().contains(p)) {
                e.setCancelled(true);
                p.setFoodLevel(20);
            }
        }
    }

    @EventHandler
    public void BlockBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if (!p.getGameMode().equals(GameMode.CREATIVE)) {
            if(!imLobby.getData().getFighting().contains(p)) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void BlockPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        UUID uuid = UUIDFetcher.getUUID(p.getName());
        if (!p.getGameMode().equals(GameMode.CREATIVE)) {
            if(!imLobby.getData().getFighting().contains(p)) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onSpawn(CreatureSpawnEvent e) {
        CreatureSpawnEvent.SpawnReason spawnreason = e.getSpawnReason();
        if (spawnreason.equals(CreatureSpawnEvent.SpawnReason.DEFAULT) || spawnreason.equals(CreatureSpawnEvent.SpawnReason.ENDER_PEARL) || spawnreason.equals(CreatureSpawnEvent.SpawnReason.NATURAL)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onArmorstand(PlayerArmorStandManipulateEvent e) {
        e.setCancelled(true);
    }

}
