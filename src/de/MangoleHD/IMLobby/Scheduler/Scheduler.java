package de.MangoleHD.IMLobby.Scheduler;

import de.Iclipse.IMAPI.Util.ScoreboardSign;
import de.MangoleHD.IMLobby.Data;
import de.MangoleHD.IMLobby.StaticClasses.getScoreboard;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitTask;

public class Scheduler {
    public static int scheduler;
    public static BukkitTask scheduler2;
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
        },1);
    }

    public static void ClayToEnder(Player p){
        Bukkit.getScheduler().runTaskLater(Data.instance, new Runnable() {
            @Override
            public void run() {
            ItemStack ender = new ItemStack(Material.ENDER_PEARL);
            ItemMeta endermeta = ender.getItemMeta();
            endermeta.setDisplayName("§rBeam");
            ender.setItemMeta(endermeta);
            p.getInventory().setItem(1,ender);
            }
        },5*20);
    }

    public static void scheduleScoreboard(){
        scheduler2 = Bukkit.getScheduler().runTaskTimer(Data.instance, new Runnable() {
            @Override
            public void run() {
                getScoreboard.ticks++;
                if(getScoreboard.ticks == 21){
                    getScoreboard.ticks = 0;
                }
                if(getScoreboard.ticks == 0){
                    getScoreboard.animation++;
                    if(getScoreboard.animation == 3){
                        getScoreboard.animation = 0;
                    }
                    if(getScoreboard.animation == 0){
                        String a = getScoreboard.getAnimation();
                        for(Player all: getScoreboard.boards.keySet()){
                            ScoreboardSign ss = getScoreboard.boards.get(all);
                            ss.setLine(0,"§6" + all.getName());
                            ss.setLine(1,"   " + ChatColor.BLUE);
                            ss.setLine(2,"§2Buon Giorno");
                            ss.setLine(3,"" + a);
                            ss.setLine(4,"§l ");
                            ss.setLine(5,"§l  ");
                            ss.setLine(6,"§fSie spielen hier auf");
                            ss.setLine(7,"§c§lMEINEM");
                            ss.setLine(8,"§r§fServer!!!");
                        }
                    }
                    if(getScoreboard.animation == 1){
                        String a = getScoreboard.getAnimation();
                        for(Player all: getScoreboard.boards.keySet()){
                            ScoreboardSign ss = getScoreboard.boards.get(all);
                            ss.setLine(0,"§6" + all.getName());
                            ss.setLine(1,"   " + ChatColor.BLUE);
                            ss.setLine(2,"§2Buon Giorno");
                            ss.setLine(3," ");
                            ss.setLine(4,"" + a);
                            ss.setLine(5,"§l  ");
                            ss.setLine(6,"§fSie spielen hier auf");
                            ss.setLine(7,"§c§lMEINEM");
                            ss.setLine(8,"§r§fServer!!!");
                        }
                    }
                    if(getScoreboard.animation == 2){
                        String a = getScoreboard.getAnimation();
                        for(Player all: getScoreboard.boards.keySet()){
                            ScoreboardSign ss = getScoreboard.boards.get(all);
                            ss.setLine(0,"§6" + all.getName());
                            ss.setLine(1,"   " + ChatColor.BLUE);
                            ss.setLine(2,"§2Buon Giorno");
                            ss.setLine(3," " + ChatColor.BLACK);
                            ss.setLine(4,"§l  " + ChatColor.RED);
                            ss.setLine(5,"" + a);
                            ss.setLine(6,"§fSie spielen hier auf");
                            ss.setLine(7,"§c§lMEINEM");
                            ss.setLine(8,"§r§fServer!!!");
                        }
                    }
                }
            }
        },0,1);
    }

    public static void stopScheduler(){
        Bukkit.getScheduler().cancelTask(scheduler);
    }

    public static void stopScheduler2(){
        scheduler2.cancel();
    }
}
