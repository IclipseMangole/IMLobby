package de.MangoleHD.IMLobby.Scheduler;

import de.Iclipse.IMAPI.Util.TickParser;
import de.MangoleHD.IMLobby.Data;
import de.MangoleHD.IMLobby.Extras.Animations.Flag;
import de.MangoleHD.IMLobby.Extras.Animations.Grave;
import de.MangoleHD.IMLobby.Extras.Animations.Vent;
import de.MangoleHD.IMLobby.Extras.Animations.Windmill;
import de.MangoleHD.IMLobby.Extras.Bell;
import de.MangoleHD.IMLobby.Extras.Minigames.MiniArena;
import de.MangoleHD.IMLobby.StaticClasses.getScoreboard;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitTask;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;

import static de.MangoleHD.IMLobby.Data.*;

public class Scheduler {
    public static BukkitTask scheduler2;
    private static PotionEffect ghost = new PotionEffect(PotionEffectType.INVISIBILITY, 25, 1, true, false);


    public static void EnderToClay(Player p) {
        Bukkit.getScheduler().runTaskLater(Data.instance, new Runnable() {
            @Override
            public void run() {
                ItemStack clay = new ItemStack(Material.CLAY_BALL);
                ItemMeta claymeta = clay.getItemMeta();
                claymeta.setDisplayName(dsp.get("scheduler.clay", p));
                claymeta.setLore(Arrays.asList(new String[]{dsp.get("scheduler.clay.lore", p)}));
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
                endermeta.setDisplayName(dsp.get("startinventory.name.beam", p));
                endermeta.setLore(Arrays.asList(new String[]{dsp.get("startinventory.lore.beam", p)}));
                ender.setItemMeta(endermeta);
                p.getInventory().setItem(1, ender);
            }
        }, 5 * 20);
    }

    static int seconds;

    public static void startScheduler() {
        scheduler2 = Bukkit.getScheduler().runTaskTimer(Data.instance, new Runnable() {
            @Override
            public void run() {
                getScoreboard.animation++;
                if (getScoreboard.animation == 3) {
                    getScoreboard.animation = 0;
                }
                Bukkit.getOnlinePlayers().forEach(entry -> {
                    getScoreboard.updateScoreboard(entry);
                });

                Data.ghost.forEach(player -> {
                    player.addPotionEffect(ghost);
                });

                Data.sneakjumper.forEach((player, integer) -> {
                    if (Data.sneakjumper.get(player) != 60) {
                        int old = Data.sneakjumper.get(player);
                        int neu = old + 15;
                        Data.sneakjumper.replace(player, old, neu);
                    }
                });
                if (seconds == 59) {
                    Bukkit.getWorlds().forEach(world -> world.setTime(TickParser.parse(new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime()))));
                }
                seconds = seconds % 60 + 1;
                if (!Data.killlag) {
                    Vent.vent();
                    Windmill.windmill();
                    Flag.flag();
                    Grave.grave();
                    Bell.bell();
                }
                Random random = new Random();
                int mode = random.nextInt(4);
                if(Data.miniArena.size() == 2){
                  Data.miniArena.forEach((player, aInteger) -> {
                      //waiting
                      if(Data.miniArena.get(player) == 1){
                          Data.miniArena.replace(player,1,0);
                          MiniArena.startArena(player,1, mode);
                      }else if(Data.miniArena.get(player) == 2){
                          Data.miniArena.replace(player,2,0);
                          MiniArena.startArena(player,2,mode);
                          //fighting
                      }else if(Data.miniArena.get(player) == 0) {
                        if(arenaCountdown > 0){
                            dsp.send(player,"miniArena.countdown", "" + arenaCountdown, dsp.get("miniArena.unit", player));
                            arenaCountdown--;
                        }
                      }
                  });
                }
            }
        }, 0, 20);
    }


    public static void stopScheduler() {
        scheduler2.cancel();
    }
}
