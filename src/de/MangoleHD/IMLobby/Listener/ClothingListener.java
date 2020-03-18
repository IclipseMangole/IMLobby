package de.MangoleHD.IMLobby.Listener;

import de.Iclipse.IMAPI.Functions.MySQL.MySQL_UserSettings;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
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
        if(MySQL_UserSettings.getString(uuid,"clothing").equals("jumper")){
            if(!p.getAllowFlight()){

            }
        }
    }
}
