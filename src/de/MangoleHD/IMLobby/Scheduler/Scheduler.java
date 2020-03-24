package de.MangoleHD.IMLobby.Scheduler;

import de.Iclipse.IMAPI.Util.ScoreboardSign;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
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

import java.util.Arrays;

import static de.Iclipse.IMAPI.Functions.MySQL.MySQL_User.getLanguage;

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
                claymeta.setDisplayName(de.Iclipse.IMAPI.Data.dsp.get("scheduler.clay",getLanguage(UUIDFetcher.getUUID(p.getName()))));
                claymeta.setLore(Arrays.asList(new String[]{de.Iclipse.IMAPI.Data.dsp.get("scheduler.clay.lore", getLanguage(UUIDFetcher.getUUID(p.getName())))}));
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
            endermeta.setDisplayName(de.Iclipse.IMAPI.Data.dsp.get("startinventory.name.beam",getLanguage(UUIDFetcher.getUUID(p.getName()))));
            endermeta.setLore(Arrays.asList(new String[]{de.Iclipse.IMAPI.Data.dsp.get("startinventory.lore.beam", getLanguage(UUIDFetcher.getUUID(p.getName())))}));
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
                        for(Player all: getScoreboard.boards.keySet()){
                            ScoreboardSign ss = getScoreboard.boards.get(all);
                            String a = getScoreboard.getAnimation(all);
                            ss.setLine(0,"§6" + all.getName());
                            ss.setLine(1,"" + ChatColor.GOLD);
                            ss.setLine(2,"§2Buon Giorno");
                            ss.setLine(3,"" + a);
                            ss.setLine(4," "  + ChatColor.BLUE);
                            ss.setLine(5,"  " + ChatColor.RED);
                            ss.setLine(6, de.Iclipse.IMAPI.Data.dsp.get("scoreboard.line.6",getLanguage(UUIDFetcher.getUUID(all.getName()))));
                            ss.setLine(7, de.Iclipse.IMAPI.Data.dsp.get("scoreboard.line.7",getLanguage(UUIDFetcher.getUUID(all.getName()))));
                            ss.setLine(8, de.Iclipse.IMAPI.Data.dsp.get("scoreboard.line.8",getLanguage(UUIDFetcher.getUUID(all.getName()))));
                        }
                    }
                    if(getScoreboard.animation == 1){
                        for(Player all: getScoreboard.boards.keySet()){
                            ScoreboardSign ss = getScoreboard.boards.get(all);
                            String a = getScoreboard.getAnimation(all);
                            ss.setLine(0,"§6" + all.getName());
                            ss.setLine(1,"" + ChatColor.GOLD);
                            ss.setLine(2,"§2Buon Giorno");
                            ss.setLine(3," " + ChatColor.BLUE);
                            ss.setLine(4,"" + a);
                            ss.setLine(5,"  " + ChatColor.RED);
                            ss.setLine(6,de.Iclipse.IMAPI.Data.dsp.get("scoreboard.line.6",getLanguage(UUIDFetcher.getUUID(all.getName()))));
                            ss.setLine(7,de.Iclipse.IMAPI.Data.dsp.get("scoreboard.line.7",getLanguage(UUIDFetcher.getUUID(all.getName()))));
                            ss.setLine(8,de.Iclipse.IMAPI.Data.dsp.get("scoreboard.line.8",getLanguage(UUIDFetcher.getUUID(all.getName()))));
                        }
                    }
                    if(getScoreboard.animation == 2){
                        for(Player all: getScoreboard.boards.keySet()){
                            ScoreboardSign ss = getScoreboard.boards.get(all);
                            String a = getScoreboard.getAnimation(all);
                            ss.setLine(0,"§6" + all.getName());
                            ss.setLine(1,"" + ChatColor.GOLD);
                            ss.setLine(2,"§2Buon Giorno");
                            ss.setLine(3," " + ChatColor.BLUE);
                            ss.setLine(4,"  " + ChatColor.RED);
                            ss.setLine(5,"" + a);
                            ss.setLine(6,de.Iclipse.IMAPI.Data.dsp.get("scoreboard.line.6",getLanguage(UUIDFetcher.getUUID(all.getName()))));
                            ss.setLine(7,de.Iclipse.IMAPI.Data.dsp.get("scoreboard.line.7",getLanguage(UUIDFetcher.getUUID(all.getName()))));
                            ss.setLine(8,de.Iclipse.IMAPI.Data.dsp.get("scoreboard.line.8",getLanguage(UUIDFetcher.getUUID(all.getName()))));
                        }
                    }
                }
            }
        },0,1);
    }

    public static void onSneakJumperScheduler() {
        scheduler = Bukkit.getScheduler().scheduleSyncRepeatingTask(Data.instance, new Runnable() {
            @Override
            public void run() {
                Data.sneakjumper.forEach((player, integer) -> {
                    if(Data.sneakjumper.get(player)!=60){
                        int old = Data.sneakjumper.get(player);
                        int neu = old+1;
                        Data.sneakjumper.replace(player,old,neu);
                    }
                });
            }
        },1,1);
    }

    public static void stopScheduler(){
        Bukkit.getScheduler().cancelTask(scheduler);
    }

    public static void stopScheduler2(){
        scheduler2.cancel();
    }
}
