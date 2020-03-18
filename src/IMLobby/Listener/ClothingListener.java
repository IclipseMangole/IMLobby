package IMLobby.Listener;

import IMLobby.Data;
import de.Iclipse.IMAPI.Functions.MySQL.MySQL_UserSettings;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.UUID;

public class ClothingListener implements Listener {

    @EventHandler
    public void Thief(PlayerMoveEvent e){
        Player p = e.getPlayer();
        UUID uuid = UUIDFetcher.getUUID(p.getName());
        if(MySQL_UserSettings.getString(uuid,"clothing").equals("thief")){
            PotionEffect speed = new PotionEffect(PotionEffectType.SPEED,20,3);
            p.addPotionEffect(speed);
        }
    }

    @EventHandler
    public void Jumper(PlayerToggleFlightEvent e){
        Player p = e.getPlayer();
        UUID uuid = UUIDFetcher.getUUID(p.getName());
        p.sendMessage("Spring");
        if(MySQL_UserSettings.getString(uuid,"clothing").equals("jumper")){
            p.sendMessage("Spring mit jumper");
            if(!p.getAllowFlight()){
                p.sendMessage("Spring mit jumper erlaubnis");
                p.setAllowFlight(true);
            }
        }
    }

    @EventHandler
    public void Ghost(PlayerToggleSneakEvent e){
        Player p = e.getPlayer();
        UUID uuid = UUIDFetcher.getUUID(p.getName());
        if(MySQL_UserSettings.getString(uuid,"clothing").equals("ghost")){
            if(!p.isSneaking()) {
                p.hidePlayer(Data.instance, p);
            }else{
                p.showPlayer(Data.instance, p);
            }
        }
    }
}
