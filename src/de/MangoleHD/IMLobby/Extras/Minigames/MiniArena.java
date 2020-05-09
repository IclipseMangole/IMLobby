package de.MangoleHD.IMLobby.Extras.Minigames;

import de.Iclipse.IMAPI.Database.User;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.MangoleHD.IMLobby.Data;
import org.bukkit.Color;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

import static de.MangoleHD.IMLobby.Data.*;

public class MiniArena implements Listener {

    @EventHandler
    public void onWait(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();
        Block block = event.getClickedBlock();
        if (action.equals(Action.RIGHT_CLICK_BLOCK) || action.equals(Action.LEFT_CLICK_BLOCK)) {
            if (block.getType().equals(Material.OAK_WALL_SIGN) || block.getType().equals(Material.OAK_SIGN)) {
                Location sign = new Location(Bukkit.getWorld("world"), 40, 54, -22);
                if (sign.equals(block.getLocation())) {
                    if (!Data.waiting.contains(player)) {
                        if (Data.waiting.size() == 0) {
                            Data.waiting.add(player);
                            dsp.send(player, "miniArena.join");
                        } else if (Data.waiting.size() == 1) {
                            Data.waiting.add(player);
                            dsp.send(player, "miniArena.join");
                        } else {
                            dsp.send(player, "miniArena.full");
                        }
                    } else {
                        Data.waiting.remove(player);
                        dsp.send(player, "miniArena.leave");
                    }
                }
            }
        }
    }

    @EventHandler
    public void onCountdownMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (Data.fighting.contains(player)) {
            if (Data.arenaCountdown > 0) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onCountdownClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (Data.fighting.contains(player)) {
            if (Data.arenaCountdown > 0) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onTeleport(PlayerTeleportEvent event) {
        if (Data.fighting.contains(event.getPlayer())) {
            if (event.getCause().equals(PlayerTeleportEvent.TeleportCause.ENDER_PEARL)) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if (Data.fighting.contains(player)) {
            Data.placed.add(event.getBlock());
        }
    }

    @EventHandler
    public void onPlaceWaterLava(PlayerBucketEmptyEvent event){
        Player player = event.getPlayer();
        if(fighting.contains(player)){
            placed.add(event.getBlock());
        }
    }

    @EventHandler
    public void onBreakWaterLava(PlayerBucketFillEvent event){
        Player player = event.getPlayer();
        if(placed.contains(event.getBlock())){
            placed.remove(event.getBlock());
        }
    }

    @EventHandler
    public void onLavaWater(BlockFromToEvent event) {
        if (event.getBlock().getType().equals(Material.LAVA) || event.getBlock().getType().equals(Material.WATER)) {
            if (event.getToBlock().getType().equals(Material.WATER) || event.getToBlock().getType().equals(Material.LAVA) || event.getToBlock().getType().equals(Material.AIR)) {
                Data.placed.add(event.getToBlock());
                placed.add(event.getBlock());
            }
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if(placed.contains(event.getBlock())) {
            Data.placed.remove(event.getBlock());
        }else{
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onKill(PlayerDeathEvent event) {
        Player dead = event.getEntity();
        Player killer;
        int deadIndex = fighting.indexOf(dead);
        if (deadIndex == 0) {
            killer = fighting.get(1);
        } else {
            killer = fighting.get(0);
        }
        User.addSchnitzel(UUIDFetcher.getUUID(killer.getName()), 10);
        dsp.send(killer, "miniArena.schnitzel");
        event.setDeathMessage(null);
        Bukkit.getOnlinePlayers().forEach(entry -> {
            entry.sendMessage(getDeathMessage(entry, killer, dead));
        });

        finishArena();
    }

    public String getDeathMessage(Player entry, Player killer, Player dead) {
        Random random = new Random();
        int message = random.nextInt(5);
        return dsp.get("miniArena.deathMessage." + message, entry, dead.getDisplayName(), killer.getDisplayName());
    }

    public static void finishArena() {
        fighting.forEach(player -> {
            player.chat("/startInventory");
            player.teleport(Data.spawn);
        });
        Data.fighting.clear();
        Data.waiting.clear();
        clearArena();
    }

    public static void clearArena() {
        Data.placed.forEach(block -> {
            block.setType(Material.AIR);
        });
        Data.placed.clear();
        Bukkit.getWorld("world").getEntities().forEach(entity -> {
            if(entity.getType().equals(EntityType.DROPPED_ITEM) || entity.getType().equals(EntityType.ARROW)){
                entity.remove();
            }
        });
    }

    public static void startArena(Player player, int place, int mode) {
        player.setGameMode(GameMode.SURVIVAL);
        player.getInventory().clear();
        player.setHealth(20);
        player.setAllowFlight(false);
        player.getActivePotionEffects().clear();
        player.setFoodLevel(20);
        ArenaInventory(player, mode);

        Location place0 = new Location(Bukkit.getWorld("world"), 40.5, 47, -32.5, 0, 0);
        Location place1 = new Location(Bukkit.getWorld("world"), 40.5, 47, -12.5, 180, 0);

        if (place == 0) {
            player.teleport(place0);
        } else {
            player.teleport(place1);
        }

        Data.arenaCountdown = 5;
    }

    private static void ArenaInventory(Player player, int mode) {
        switch (mode) {
            case 0:
                getLeather(player);
                break;
            case 1:
                getChain(player);
                break;
            case 2:
                getIron(player);
                break;
            case 3:
                getDiamond(player);
                break;
        }
    }

    private static void getLeather(Player player) {
        PlayerInventory inventory = player.getInventory();
        inventory.setHelmet(new ItemStack(Material.LEATHER_HELMET));
        inventory.setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
        inventory.setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
        inventory.setBoots(new ItemStack(Material.LEATHER_BOOTS));
        inventory.setItem(0, new ItemStack(Material.WOODEN_SWORD));
        inventory.setItem(1, new ItemStack(Material.COOKED_BEEF, 10));
        inventory.setItem(2, new ItemStack(Material.COBWEB, 5));
    }

    private static void getChain(Player player) {
        PlayerInventory inventory = player.getInventory();
        inventory.setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));
        inventory.setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
        inventory.setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
        inventory.setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
        inventory.setItem(0, new ItemStack(Material.STONE_SWORD));
        inventory.setItem(1, new ItemStack(Material.BOW));
        inventory.setItem(2, new ItemStack(Material.ARROW, 10));
        inventory.setItem(3, new ItemStack(Material.COOKED_BEEF, 10));
        inventory.setItem(4, new ItemStack(Material.COBWEB, 5));
    }

    private static void getIron(Player player) {
        PlayerInventory inventory = player.getInventory();

        ItemStack healPotion = new ItemStack(Material.POTION);
        PotionMeta potionMeta = (PotionMeta) healPotion.getItemMeta();
        potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.HEAL, 0, 1), false);
        potionMeta.setDisplayName("§dHeilungs-Trank");
        potionMeta.setColor(Color.FUCHSIA);
        healPotion.setItemMeta(potionMeta);

        inventory.setHelmet(new ItemStack(Material.IRON_HELMET));
        inventory.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        inventory.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        inventory.setBoots(new ItemStack(Material.IRON_BOOTS));
        inventory.setItem(0, new ItemStack(Material.IRON_SWORD));
        inventory.setItem(1, new ItemStack(Material.BOW));
        inventory.setItem(2, new ItemStack(Material.ARROW, 15));
        inventory.setItem(3, new ItemStack(Material.COOKED_BEEF, 15));
        inventory.setItem(4, new ItemStack(Material.GOLDEN_APPLE, 1));
        inventory.setItem(5, healPotion);
        inventory.setItem(6, new ItemStack(Material.COBWEB, 5));
    }

    public static void getDiamond(Player player) {
        PlayerInventory inventory = player.getInventory();

        ItemStack healPotion = new ItemStack(Material.POTION);
        PotionMeta potionMeta = (PotionMeta) healPotion.getItemMeta();
        potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.HEAL, 0, 1), false);
        potionMeta.setDisplayName("§dHeilungs-Trank");
        potionMeta.setColor(Color.FUCHSIA);
        healPotion.setItemMeta(potionMeta);

        ItemStack damagePotion = new ItemStack(Material.POTION);
        PotionMeta potionMeta2 = (PotionMeta) damagePotion.getItemMeta();
        potionMeta2.addCustomEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 500, 0), false);
        potionMeta2.setDisplayName("§4Stärke-Trank");
        potionMeta2.setColor(Color.MAROON);
        damagePotion.setItemMeta(potionMeta2);

        inventory.setHelmet(new ItemStack(Material.DIAMOND_HELMET));
        inventory.setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
        inventory.setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
        inventory.setBoots(new ItemStack(Material.DIAMOND_BOOTS));
        inventory.setItem(0, new ItemStack(Material.DIAMOND_SWORD));
        inventory.setItem(1, new ItemStack(Material.BOW));
        inventory.setItem(9, new ItemStack(Material.ARROW, 20));
        inventory.setItem(2, new ItemStack(Material.COOKED_BEEF, 20));
        inventory.setItem(3, new ItemStack(Material.GOLDEN_APPLE, 3));
        inventory.setItem(4, damagePotion);
        inventory.setItem(5, healPotion);
        inventory.setItem(6, new ItemStack(Material.COBWEB, 5));
        inventory.setItem(7, new ItemStack(Material.LAVA_BUCKET));
        inventory.setItem(8, new ItemStack(Material.WATER_BUCKET));
    }
}
