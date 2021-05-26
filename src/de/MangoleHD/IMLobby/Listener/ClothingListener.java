package de.MangoleHD.IMLobby.Listener;

import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.MangoleHD.IMLobby.Functions.Scheduler.Scheduler;
import de.MangoleHD.IMLobby.IMLobby;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
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

import java.util.UUID;

public class ClothingListener implements Listener {
    
    private final IMLobby imLobby;

    public ClothingListener(IMLobby imLobby) {
        this.imLobby = imLobby;
    }

    //TODO
    @EventHandler
    public void onThief(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        UUID uuid = UUIDFetcher.getUUID(p.getName());
        if (!imLobby.getData().getFighting().contains(p)) {
            if (imLobby.getData().getIMAPI().getData().getUserSettingsTable().getString(uuid, "clothing").equals("thief")) {
                PotionEffect speed = new PotionEffect(PotionEffectType.SPEED, 20, 4);
                p.addPotionEffect(speed);
            }
        }
    }

    @EventHandler
    public void onJumper(PlayerToggleFlightEvent e) {
        Player p = e.getPlayer();
        UUID uuid = UUIDFetcher.getUUID(p.getName());
        if (!imLobby.getData().getFighting().contains(p)) {
            if (!p.getGameMode().equals(GameMode.CREATIVE)) {
                e.setCancelled(true);
                if (imLobby.getData().getIMAPI().getData().getUserSettingsTable().getString(uuid, "clothing").equals("jumper")) {
                    Vector v = p.getLocation().getDirection().multiply(1).setY(1);
                    p.setVelocity(v);
                    p.setAllowFlight(false);
                }
            }
        }
    }

    @EventHandler
    public void onSneakJumper(PlayerToggleSneakEvent e) {
        Player p = e.getPlayer();
        UUID uuid = UUIDFetcher.getUUID(p.getName());
        if (!p.getGameMode().equals(GameMode.CREATIVE)) {
            if (!imLobby.getData().getFighting().contains(p)) {
                if (imLobby.getData().getIMAPI().getData().getUserSettingsTable().getString(uuid, "clothing").equals("jumper")) {
                    if (!p.isSneaking()) {
                        if (p.isOnGround()) {
                            imLobby.getData().getSneakjumper().put(p, 0);
                        }
                    } else {
                        if (imLobby.getData().getSneakjumper().containsKey(p)) {
                            Vector v = p.getLocation().getDirection().setX(0).setZ(0).setY(imLobby.getData().getSneakjumper().get(p) / 10);
                            p.setVelocity(v);
                            p.setAllowFlight(false);
                            imLobby.getData().getGhost().remove(p);
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onJumperGround(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        UUID uuid = UUIDFetcher.getUUID(p.getName());
        if (!imLobby.getData().getFighting().contains(p))
            if (p.isOnGround()) {
                if (imLobby.getData().getIMAPI().getData().getUserSettingsTable().getString(uuid, "clothing").equals("jumper")) {
                    p.setAllowFlight(true);
                }
            }
    }

    @EventHandler
    public void onSneakGhost(PlayerToggleSneakEvent e) {
        Player p = e.getPlayer();
        UUID uuid = UUIDFetcher.getUUID(p.getName());
        if (!imLobby.getData().getFighting().contains(p)) {
            if (imLobby.getData().getIMAPI().getData().getUserSettingsTable().getString(uuid, "clothing").equals("ghost")) {
                if (!p.isSneaking()) {
                    imLobby.getData().getGhost().add(p);
                } else {
                    imLobby.getData().getGhost().remove(p);
                }
            }
        }
    }

    @EventHandler
    public void onKing(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        UUID uuid = UUIDFetcher.getUUID(player.getName());
        if (!imLobby.getData().getFighting().contains(player)) {
            if (imLobby.getData().getIMAPI().getData().getUserSettingsTable().getString(uuid, "clothing").equals("king")) {
                if (!event.getTo().getBlock().getType().equals(Material.AIR) && player.isOnGround() && !event.getFrom().getBlock().getType().equals(Material.AIR)) {
                    Location change = player.getLocation();
                    change.setY(change.getY() - 1);
                    Block changed = change.getBlock();
                    Material old = changed.getType();
                    Scheduler.KingGold(changed, old);
                    changed.setType(Material.GOLD_BLOCK);
                }
            }
        }
    }

    @EventHandler
    public void onKingSneak(PlayerToggleSneakEvent event) {
        Player player = event.getPlayer();
        UUID uuid = UUIDFetcher.getUUID(player.getName());
        if (!imLobby.getData().getFighting().contains(player)) {
            if (imLobby.getData().getIMAPI().getData().getUserSettingsTable().getString(uuid, "clothing").equals("king")) {
                if (!player.isSneaking()) {
                    Location loc = player.getLocation();
                }
            }
        }
    }
}
