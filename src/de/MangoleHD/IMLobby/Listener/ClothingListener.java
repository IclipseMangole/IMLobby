package de.MangoleHD.IMLobby.Listener;

import de.MangoleHD.IMLobby.Data;
import de.Iclipse.IMAPI.Functions.MySQL.MySQL_UserSettings;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.Collection;
import java.util.UUID;

public class ClothingListener implements Listener {

    @EventHandler
    public void onThief(PlayerMoveEvent e){
        Player p = e.getPlayer();
        UUID uuid = UUIDFetcher.getUUID(p.getName());
        if(MySQL_UserSettings.getString(uuid,"clothing").equals("thief")){
            PotionEffect speed = new PotionEffect(PotionEffectType.SPEED,20,4);
            p.addPotionEffect(speed);
        }
    }

    @EventHandler
        public void onJumper(PlayerToggleFlightEvent e) {
        Player p = e.getPlayer();
        UUID uuid = UUIDFetcher.getUUID(p.getName());
        if(!p.getGameMode().equals(GameMode.CREATIVE)){
            e.setCancelled(true);
                if(MySQL_UserSettings.getString(uuid,"clothing").equals("jumper")){
                    Vector v = p.getLocation().getDirection().multiply(1).setY(1);
                    p.setVelocity(v);
                    p.setAllowFlight(false);
            }
        }
    }

    @EventHandler
    public void onSneakJumper(PlayerToggleSneakEvent e) {
        Player p = e.getPlayer();
        UUID uuid = UUIDFetcher.getUUID(p.getName());
        if (!p.getGameMode().equals(GameMode.CREATIVE)) {
            if (MySQL_UserSettings.getString(uuid, "clothing").equals("jumper")) {
                if (!p.isSneaking()) {
                    if (p.isOnGround()) {
                        Data.sneakjumper.put(p, 0);
                    }
                }else{
                    if(Data.sneakjumper.containsKey(p)){
                        Vector v = p.getLocation().getDirection().setX(0).setZ(0).setY(Data.sneakjumper.get(p)/10);
                        p.setVelocity(v);
                        p.setAllowFlight(false);
                        Data.sneakjumper.remove(p);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onJumperGround(PlayerMoveEvent e){
        Player p = e.getPlayer();
        UUID uuid = UUIDFetcher.getUUID(p.getName());
        if(p.isOnGround()) {
            if (MySQL_UserSettings.getString(uuid, "clothing").equals("jumper")) {
                p.setAllowFlight(true);
            }
        }
    }

    @EventHandler
    public void onSneakGhost(PlayerToggleSneakEvent e){
        Player p = e.getPlayer();
        UUID uuid = UUIDFetcher.getUUID(p.getName());
        if(MySQL_UserSettings.getString(uuid,"clothing").equals("ghost")){
            if(!p.isSneaking()) {
               Data.ghost.add(p);
            }else{
               Data.ghost.remove(p);
            }
        }
    }
}
