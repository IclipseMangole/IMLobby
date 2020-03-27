package de.MangoleHD.IMLobby.Scheduler;

import de.MangoleHD.IMLobby.Data;
import de.MangoleHD.IMLobby.StaticClasses.getScoreboard;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitTask;

import java.util.Arrays;

public class Scheduler {
    public static int scheduler;
    public static BukkitTask scheduler2;
    private static PotionEffect ghost = new PotionEffect(PotionEffectType.INVISIBILITY, 20, 1, true, false);

    public static void GhostScheduler() {
        scheduler = Bukkit.getScheduler().scheduleSyncRepeatingTask(Data.instance, new Runnable() {
            @Override
            public void run() {
                Data.ghost.forEach(player -> {
                    player.addPotionEffect(ghost);
                });
            }
        }, 1, 1);
    }

    public static void EnderToClay(Player p) {
        Bukkit.getScheduler().runTaskLater(Data.instance, new Runnable() {
            @Override
            public void run() {
                ItemStack clay = new ItemStack(Material.CLAY_BALL);
                ItemMeta claymeta = clay.getItemMeta();
                claymeta.setDisplayName(Data.dsp.get("scheduler.clay", p));
                claymeta.setLore(Arrays.asList(new String[]{Data.dsp.get("scheduler.clay.lore", p)}));
                clay.setItemMeta(claymeta);
                p.getInventory().setItem(1, clay);
                ClayToEnder(p);
            }
        }, 1);
    }

    public static void ClayToEnder(Player p) {
        Bukkit.getScheduler().runTaskLater(Data.instance, new Runnable() {
            @Override
            public void run() {
                ItemStack ender = new ItemStack(Material.ENDER_PEARL);
                ItemMeta endermeta = ender.getItemMeta();
                endermeta.setDisplayName(Data.dsp.get("startinventory.name.beam", p));
                endermeta.setLore(Arrays.asList(new String[]{Data.dsp.get("startinventory.lore.beam", p)}));
                ender.setItemMeta(endermeta);
                p.getInventory().setItem(1, ender);
            }
        }, 5 * 20);
    }

    public static void scheduleScoreboard() {
        scheduler2 = Bukkit.getScheduler().runTaskTimer(Data.instance, new Runnable() {
            @Override
            public void run() {
                getScoreboard.ticks++;
                if (getScoreboard.ticks == 5) {
                    getScoreboard.ticks = 0;
                }
                if (getScoreboard.ticks == 0) {
                    getScoreboard.animation++;
                    if (getScoreboard.animation == 3) {
                        getScoreboard.animation = 0;
                    }
                    Bukkit.getOnlinePlayers().forEach(entry ->{
                        getScoreboard.updateScoreboard(entry);
                    });
                }
            }
        }, 0, 4);
    }

    public static void onSneakJumperScheduler() {
        scheduler = Bukkit.getScheduler().scheduleSyncRepeatingTask(Data.instance, new Runnable() {
            @Override
            public void run() {
                Data.sneakjumper.forEach((player, integer) -> {
                    if (Data.sneakjumper.get(player) != 60) {
                        int old = Data.sneakjumper.get(player);
                        int neu = old + 1;
                        Data.sneakjumper.replace(player, old, neu);
                    }
                });
            }
        }, 1, 1);
    }

    public static void stopScheduler() {
        Bukkit.getScheduler().cancelTask(scheduler);
    }

    public static void stopScheduler2() {
        scheduler2.cancel();
    }
}
