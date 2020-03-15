package IMLobby.Listener;

import IMLobby.MySQL.MySQL;
import IMLobby.MySQL.MySQL_LobbySettings;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

// Partikel wenn man rumläuft und so

public class ParticleListener implements Listener {

    //Feuer
    @EventHandler
    public void Fire(PlayerMoveEvent e) {
        Player p = e.getPlayer();

        if (MySQL_LobbySettings.getParticles(UUIDFetcher.getUUID(p.getName())).equals("Flames")) {
            p.getWorld().spawnParticle(Particle.FLAME, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 5);
        }

        if(MySQL_LobbySettings.getParticles(UUIDFetcher.getUUID(p.getName())).equals("Water")){
            p.getWorld().spawnParticle(Particle.WATER_SPLASH, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 5);
        }

        if(MySQL_LobbySettings.getParticles(UUIDFetcher.getUUID(p.getName())).equals("Lava")){
            p.getWorld().spawnParticle(Particle.LAVA, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 5);
        }

        if(MySQL_LobbySettings.getParticles(UUIDFetcher.getUUID(p.getName())).equals("Love")){
            p.getWorld().spawnParticle(Particle.HEART, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 5);
        }
    }
}

