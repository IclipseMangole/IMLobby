package de.MangoleHD.IMLobby.Extras;

import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.Iclipse.IMAPI.Database.UserSettings;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.UUID;

public class Treppe implements Listener {

    @EventHandler
    public void teleportDown (PlayerMoveEvent event) {

        Player p = event.getPlayer();
        UUID uuid = UUIDFetcher.getUUID(p.getName());
        Location loc = p.getLocation();


        if(loc.getX() >= 56.300  && loc.getX() <= 58.700){
            if(loc.getZ() >= -191.700 && loc.getZ() <= -190.300){
            if(loc.getY() >= 46 && loc.getY() <= 50) {
                Location newLoc = loc;

                newLoc.setY(loc.getY() - 24);

                p.teleport(newLoc);
                if (p.isSneaking()) {
                    p.setSneaking(true);
                }
                if (p.isSprinting()) {
                    p.setSprinting(true);
                }
                p.setVelocity(p.getVelocity());
            }
            }
        }
    }

    @EventHandler
    public void teleportUp (PlayerMoveEvent event) {

        Player p = event.getPlayer();
        UUID uuid = UUIDFetcher.getUUID(p.getName());
        Location loc = p.getLocation();


        if(loc.getX() >= 53.300  && loc.getX() <= 54.700){
            if(loc.getZ() >= -186.700 && loc.getZ() <= -185.300){
                if(loc.getY() >= 26 && loc.getY() <= 29) {
                    Location newLoc = loc;

                    newLoc.setY(loc.getY() + 12);

                    p.teleport(newLoc);
                    if (p.isSneaking()) {
                        p.setSneaking(true);
                    }
                    if (p.isSprinting()) {
                        p.setSprinting(true);
                    }
                    p.setVelocity(p.getVelocity());
                }
            }
        }
    }

    @EventHandler
    public void teleportSpecial (PlayerMoveEvent event) {

        Player p = event.getPlayer();
        UUID uuid = UUIDFetcher.getUUID(p.getName());
        Location loc = p.getLocation();


        if(loc.getX() >= 57.300  && loc.getX() <= 58.700){
            if(loc.getZ() >= -186.700 && loc.getZ() <= -185.300){
                if(loc.getY() >= 20 && loc.getY() <= 23) {
                    Location newLoc = loc;

                    newLoc.setY(loc.getY() +12);

                    p.teleport(newLoc);
                    if (p.isSneaking()) {
                        p.setSneaking(true);
                    }
                    if (p.isSprinting()) {
                        p.setSprinting(true);
                    }
                    p.setVelocity(p.getVelocity());
                }
            }
        }
    }

    @EventHandler
    public void noEnderpearl (ProjectileLaunchEvent event) {
        Projectile ender = event.getEntity();
        Player shooter = (Player) ender.getShooter();
        if(ender instanceof EnderPearl) {
            Location loc = shooter.getLocation();
            if(loc.getX() >= 53.000 && loc.getX() <= 59.000){
                if(loc.getZ() >= -193.000 && loc.getZ() <= -181.000){
                    if(loc.getY() >= 3.000 && loc.getY() <= 53.000){
                        event.setCancelled(true);
                    }
                }
            }
        }
    }

    @EventHandler
    public void quit (PlayerQuitEvent event) {
        Player p = event.getPlayer();
        Location loc = p.getLocation();
        if(loc.getX() >= 53.000 && loc.getX() <= 59.000){
            if(loc.getZ() >= -193.000 && loc.getZ() <= -181.000){
                if(loc.getY() >= 3.000 && loc.getY() <= 53.000){
                    p.kickPlayer("§4Da ist wohl jemand zu dumm, Treppen zu laufen.");
                }
            }
        }
    }
}
