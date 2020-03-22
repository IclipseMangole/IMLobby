package de.MangoleHD.IMLobby.Listener;

import de.Iclipse.IMAPI.Data;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.MangoleHD.IMLobby.Scheduler.Scheduler;
import org.bukkit.Material;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import org.bukkit.util.Vector;

import static de.Iclipse.IMAPI.Functions.MySQL.MySQL_User.getLanguage;

public class ExtrasListener implements Listener {

   @EventHandler
    public void onRocket(PlayerInteractEvent e){
       Player p = e.getPlayer();
       Action click = e.getAction();
       ItemStack rocket = e.getItem();

       if(click.equals(Action.RIGHT_CLICK_AIR)||click.equals(Action.RIGHT_CLICK_BLOCK)){
           if(rocket.getItemMeta().getDisplayName().equals(Data.dsp.get("extras.rocket", getLanguage(UUIDFetcher.getUUID(p.getName()))))){
               e.setCancelled(true);
               Vector v = new Vector();
               v.setX(0).setY(50).setZ(0);
               p.setVelocity(v);
               p.getInventory().setItem(4,new ItemStack(Material.AIR));
           }
       }
   }
}
