package IMLobby.LobbyExtras;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

// Partikel wenn man rumläuft und so

public class Partikel implements Listener {

    //Feuer
    @EventHandler
    public void Fire(PlayerMoveEvent e) {
    Player p = e.getPlayer();
    p.getWorld().spawnParticle(Particle.FLAME,p.getLocation().getX(),p.getLocation().getY(),p.getLocation().getZ(),1);
    }
}
