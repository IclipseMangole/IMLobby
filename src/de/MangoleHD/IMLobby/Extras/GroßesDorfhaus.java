package de.MangoleHD.IMLobby.Extras;

import de.Iclipse.IMAPI.Util.UUIDFetcher;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.UUID;

public class GroßesDorfhaus implements Listener {

    @EventHandler
    public void teleportBig (PlayerMoveEvent event) {

        Player p = event.getPlayer();
        UUID uuid = UUIDFetcher.getUUID(p.getName());
        Location loc = p.getLocation();
        Location from = event.getFrom();
        Location to = event.getTo();


        if(from.getX() >= -51.700  && from.getX() <= -51.300){
            if(from.getZ() >= -63.700 && from.getZ() <= -63.300){
                if(from.getY() >= 54.000 && from.getY() <= 56.000) {
                    Location newLoc = to;

                    newLoc.setY(from.getY() - 53);

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
    public void teleportSmall (PlayerMoveEvent event) {

        Player p = event.getPlayer();
        UUID uuid = UUIDFetcher.getUUID(p.getName());
        Location loc = p.getLocation();
        Location from = event.getFrom();
        Location to = event.getTo();

        if(from.getX() >= -50.700  && from.getX() <= -50.300){
            if(loc.getZ() >= -62.700 && from.getZ() <= -62.300){
                if(from.getY() >= 1 && from.getY() <= 3) {
                    Location newLoc = to;

                    newLoc.setY(from.getY() + 53);

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
}
