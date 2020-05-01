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
        Location from = event.getFrom();
        Location to = event.getTo();


        if(from.getX() >= 56.300  && from.getX() <= 58.700){
            if(from.getZ() >= -191.700 && from.getZ() <= -190.300){
            if(from.getY() >= 46 && from.getY() <= 50) {
                Location newLoc = to;

                newLoc.setY(from.getY() - 24);

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
        Location from = event.getFrom();
        Location to = event.getTo();


        if(from.getX() >= 53.300  && from.getX() <= 54.700){
            if(from.getZ() >= -186.700 && from.getZ() <= -185.300){
                if(from.getY() >= 26 && from.getY() <= 29) {
                    Location newLoc = to;

                    newLoc.setY(from.getY() + 12);

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
        Location from = event.getFrom();
        Location to = event.getTo();

        if(from.getX() >= 56.300  && from.getX() <= 58.700){
            if(from.getZ() >= -186.700 && from.getZ() <= -185.300){
                if(from.getY() >= 20 && from.getY() <= 23) {
                    Location newLoc = to;

                    newLoc.setY(from.getY() +12);

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
