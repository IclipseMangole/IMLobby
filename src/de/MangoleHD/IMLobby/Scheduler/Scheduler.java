package de.MangoleHD.IMLobby.Scheduler;

import de.MangoleHD.IMLobby.Data;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Scheduler {
    public static int scheduler;
    private static PotionEffect ghost = new PotionEffect(PotionEffectType.INVISIBILITY,20,1,true,false);

    public static void GhostScheduler() {
        scheduler = Bukkit.getScheduler().scheduleSyncRepeatingTask(Data.instance, new Runnable() {
            @Override
            public void run() {
                Data.ghost.forEach(player -> {
                    player.addPotionEffect(ghost);
                });
            }
        },1,1);
    }

    public static void EnderToClay(Player p){
        Bukkit.getScheduler().runTaskLater(Data.instance, new Runnable() {
            @Override
            public void run() {
                ItemStack clay = new ItemStack(Material.CLAY_BALL);
                ItemMeta claymeta = clay.getItemMeta();
                claymeta.setDisplayName("§6WAIT");
                clay.setItemMeta(claymeta);
                p.getInventory().setItem(1,clay);
                ClayToEnder(p);
            }
        },2);
    }

    public static void ClayToEnder(Player p){
        Bukkit.getScheduler().runTaskLater(Data.instance, new Runnable() {
            @Override
            public void run() {
            ItemStack ender = new ItemStack(Material.ENDER_PEARL);
            ItemMeta endermeta = ender.getItemMeta();
            endermeta.setDisplayName("Beam");
            ender.setItemMeta(endermeta);
            p.getInventory().setItem(1,ender);
            }
        },5*20);
    }

    public static void stopScheduler(){
        Bukkit.getScheduler().cancelTask(scheduler);
    }
}
