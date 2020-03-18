package IMLobby.Listener;

import de.Iclipse.IMAPI.Functions.MySQL.MySQL_UserSettings;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Objects;
import java.util.UUID;

// Partikel wenn man rumläuft und so

public class ParticleListener implements Listener {

    @EventHandler
    public void Particles(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        UUID uuid = UUIDFetcher.getUUID(p.getName());

        if (!MySQL_UserSettings.getString(uuid, "particles").equals("off")) {
            if (MySQL_UserSettings.getString(uuid, "particles").equals("flames")) {
                p.getWorld().spawnParticle(Particle.FLAME, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 5);
            }

            if (MySQL_UserSettings.getString(uuid, "particles").equals("water")) {
                p.getWorld().spawnParticle(Particle.WATER_SPLASH, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 5);
            }

            if (MySQL_UserSettings.getString(uuid, "particles").equals("lava")) {
                p.getWorld().spawnParticle(Particle.LAVA, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 5);
            }

            if (MySQL_UserSettings.getString(uuid, "particles").equals("love")) {
                p.getWorld().spawnParticle(Particle.HEART, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 5);
            }

            if (MySQL_UserSettings.getString(uuid, "particles").equals("music")) {
                p.getWorld().spawnParticle(Particle.NOTE, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 5);
            }

            if (MySQL_UserSettings.getString(uuid, "particles").equals("boom")) {
                p.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 5);
            }

            if (MySQL_UserSettings.getString(uuid, "particles").equals("smoke")) {
                p.getWorld().spawnParticle(Particle.SMOKE_LARGE, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 5);
            }

            if (MySQL_UserSettings.getString(uuid, "particles").equals("slime")) {
                p.getWorld().spawnParticle(Particle.SLIME, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 5);
            }
        }
    }
}

