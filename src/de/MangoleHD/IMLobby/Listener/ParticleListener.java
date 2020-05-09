package de.MangoleHD.IMLobby.Listener;

import de.Iclipse.IMAPI.Database.UserSettings;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.MangoleHD.IMLobby.Data;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.UUID;

// Partikel wenn man rumläuft und so

public class ParticleListener implements Listener {

    @EventHandler
    public void Particles(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        UUID uuid = UUIDFetcher.getUUID(p.getName());
        if (!Data.fighting.contains(p)) {
            if (e.getTo().getX() != e.getFrom().getX() || e.getTo().getY() != e.getFrom().getY() || e.getTo().getY() != e.getFrom().getZ()) {
                if (!Data.killlag) {
                    if (!UserSettings.getString(uuid, "particles").equals("off")) {
                        if (UserSettings.getString(uuid, "particles").equals("flames")) {
                            Bukkit.getOnlinePlayers().forEach(player -> {
                                if (player.canSee(p)) {
                                    player.spawnParticle(Particle.FLAME, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 3);
                                }
                            });
                        }

                        if (UserSettings.getString(uuid, "particles").equals("water")) {
                            Bukkit.getOnlinePlayers().forEach(player -> {
                                if (player.canSee(p)) {
                                    player.spawnParticle(Particle.WATER_SPLASH, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 5);
                                }
                            });
                        }

                        if (UserSettings.getString(uuid, "particles").equals("lava")) {
                            Bukkit.getOnlinePlayers().forEach(player -> {
                                if (player.canSee(p)) {
                                    player.spawnParticle(Particle.LAVA, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 3);
                                }
                            });
                        }

                        if (UserSettings.getString(uuid, "particles").equals("love")) {
                            Bukkit.getOnlinePlayers().forEach(player -> {
                                if (player.canSee(p)) {
                                    player.spawnParticle(Particle.HEART, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 3);
                                }
                            });
                        }

                        if (UserSettings.getString(uuid, "particles").equals("music")) {
                            Bukkit.getOnlinePlayers().forEach(player -> {
                                if (player.canSee(p)) {
                                    player.spawnParticle(Particle.NOTE, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 3);
                                }
                            });
                        }

                        if (UserSettings.getString(uuid, "particles").equals("boom")) {
                            Bukkit.getOnlinePlayers().forEach(player -> {
                                if (player.canSee(p)) {
                                    player.spawnParticle(Particle.EXPLOSION_LARGE, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 1);
                                }
                            });
                        }

                        if (UserSettings.getString(uuid, "particles").equals("smoke")) {
                            Bukkit.getOnlinePlayers().forEach(player -> {
                                if (player.canSee(p)) {
                                    player.spawnParticle(Particle.SMOKE_LARGE, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 3);
                                }
                            });
                        }

                        if (UserSettings.getString(uuid, "particles").equals("slime")) {
                            Bukkit.getOnlinePlayers().forEach(player -> {
                                if (player.canSee(p)) {
                                    player.spawnParticle(Particle.SLIME, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 3);
                                }
                            });
                        }
                    }
                }
            }
        }
    }
}


