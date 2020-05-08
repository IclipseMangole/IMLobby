package de.MangoleHD.IMLobby.Extras.Minigames;

import de.Iclipse.IMAPI.Database.User;
import de.Iclipse.IMAPI.Database.UserSettings;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.MangoleHD.IMLobby.Data;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

import static de.MangoleHD.IMLobby.Data.dsp;

public class MiniArena implements Listener {

    @EventHandler
    public void onWait(PlayerInteractEvent event){
        Player player = event.getPlayer();
        Action action = event.getAction();
        Block block = event.getClickedBlock();
        if(action.equals(Action.RIGHT_CLICK_BLOCK) || action.equals(Action.LEFT_CLICK_BLOCK)){
            if(block.getType().equals(Material.OAK_WALL_SIGN) || block.getType().equals(Material.OAK_SIGN)){
                Location sign = new Location(Bukkit.getWorld("world"),40, 54, -22);
                if(sign.equals(block.getLocation())){
                    if(!Data.miniArena.containsKey(player)) {
                        if (Data.miniArena.size() == 0) {
                            Data.miniArena.put(player, 1);
                            dsp.send(player, "miniArena.join");
                        } else if (Data.miniArena.size() == 1) {
                            Data.miniArena.put(player, 2);
                            dsp.send(player, "miniArena.join");
                        } else {
                            dsp.send(player, "miniArena.full");
                        }
                    }else{
                        Data.miniArena.remove(player);
                        dsp.send(player, "miniArena.leave");
                    }
                }
            }
        }
    }

    @EventHandler
    public void onCountdownMove(PlayerMoveEvent event){
        Player player = event.getPlayer();
        if(Data.miniArena.containsKey(player)) {
            if (Data.miniArena.get(player) == 0) {
                if (Data.arenaCountdown > 0) {
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onCountdownClick(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if(Data.miniArena.containsKey(player)) {
            if (Data.miniArena.get(player) == 0) {
                if (Data.arenaCountdown > 0) {
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event){
        Player player = event.getPlayer();
        if(Data.miniArena.containsKey(player) && Data.miniArena.get(player) == 0){
            if(event.getBlock().getType().equals(Material.COBWEB) || event.getBlock().getType().equals(Material.LAVA) || event.getBlock().getType().equals(Material.WATER)){
                Data.placed.add(event.getBlock());
            }
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        Player player = event.getPlayer();
        if(Data.miniArena.containsKey(player) && Data.miniArena.get(player) == 0){
            if(event.getBlock().getType().equals(Material.COBWEB) || event.getBlock().getType().equals(Material.LAVA) || event.getBlock().getType().equals(Material.WATER)){
                if(Data.placed.contains(event.getBlock())) {
                    Data.placed.remove(event.getBlock());
                }
            }
        }
    }

    @EventHandler
    public void onKill(PlayerDeathEvent event){
        Player dead = event.getEntity();
        Player killer = dead.getKiller();
        User.addSchnitzel(UUIDFetcher.getUUID(killer.getName()), 10);
        dsp.send(killer,"miniArena.schnitzel");
        event.setDeathMessage(getDeathMessage(killer,dead));
        finishArena(dead);
        finishArena(killer);
    }

    public String getDeathMessage(Player killer, Player dead){
        Random random = new Random();
        int message = random.nextInt(5);
        return dsp.get("miniArena.deathMessage." + message, killer, dead.getDisplayName(), killer.getDisplayName());
    }

    public static void finishArena(Player player){
        player.chat("/startInventory");
        player.teleport(Data.spawn);
        Data.arenaCountdown = 5;
        Data.miniArena.clear();
        clearArena();
    }

    public static void clearArena(){
        Data.placed.forEach(block -> {
            block.setType(Material.AIR);
        });
    }

    public static void startArena(Player player, int place, int mode){
        player.setGameMode(GameMode.SURVIVAL);
        player.getInventory().clear();
        player.setHealth(20);
        player.setAllowFlight(false);
        player.getActivePotionEffects().clear();
        player.setFoodLevel(20);
        ArenaInventory(player, mode);

        Location place1 = new Location(Bukkit.getWorld("world"), 40, 47, -33, 0, 0);
        Location place2 = new Location(Bukkit.getWorld("world"), 40, 47, -13, 180, 0);

        if(place == 1){
            player.teleport(place1);
        }else{
            player.teleport(place2);
        }
        Data.arenaCountdown = 5;
    }

    private static void ArenaInventory(Player player, int mode){
        switch (mode){
            case 0:getLeather(player);
                break;
            case 1:getChain(player);
                break;
            case 2:getIron(player);
                break;
            case 3:getDiamond(player);
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
        inventory.setItem(1, new ItemStack(Material.COOKED_BEEF,10));
        inventory.setItem(2, new ItemStack(Material.COBWEB,5));
    }

    private static void getChain(Player player) {
        PlayerInventory inventory = player.getInventory();
        inventory.setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));
        inventory.setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
        inventory.setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
        inventory.setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
        inventory.setItem(0, new ItemStack(Material.STONE_SWORD));
        inventory.setItem(1, new ItemStack(Material.BOW));
        inventory.setItem(2, new ItemStack(Material.ARROW,10));
        inventory.setItem(3, new ItemStack(Material.COOKED_BEEF,10));
        inventory.setItem(4, new ItemStack(Material.COBWEB,5));
    }

    private static void getIron(Player player) {
        PlayerInventory inventory = player.getInventory();

        ItemStack healPotion = new ItemStack(Material.POTION);
        PotionMeta potionMeta = (PotionMeta) healPotion.getItemMeta();
        potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.HEAL,0,1),false);
        healPotion.setItemMeta(potionMeta);

        inventory.setHelmet(new ItemStack(Material.IRON_HELMET));
        inventory.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        inventory.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        inventory.setBoots(new ItemStack(Material.IRON_BOOTS));
        inventory.setItem(0, new ItemStack(Material.IRON_SWORD));
        inventory.setItem(1, new ItemStack(Material.BOW));
        inventory.setItem(2, new ItemStack(Material.ARROW,15));
        inventory.setItem(3, new ItemStack(Material.COOKED_BEEF,15));
        inventory.setItem(4, new ItemStack(Material.GOLDEN_APPLE,1));
        inventory.setItem(5, healPotion);
        inventory.setItem(6, new ItemStack(Material.COBWEB,5));
    }

    public static void getDiamond(Player player) {
        PlayerInventory inventory = player.getInventory();

        ItemStack healPotion = new ItemStack(Material.POTION);
        PotionMeta potionMeta = (PotionMeta) healPotion.getItemMeta();
        potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.HEAL,0,2),false);
        healPotion.setItemMeta(potionMeta);

        ItemStack damagePotion = new ItemStack(Material.POTION);
        PotionMeta potionMeta2 = (PotionMeta) damagePotion.getItemMeta();
        potionMeta2.addCustomEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,500,1),false);
        damagePotion.setItemMeta(potionMeta2);

        inventory.setHelmet(new ItemStack(Material.DIAMOND_HELMET));
        inventory.setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
        inventory.setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
        inventory.setBoots(new ItemStack(Material.DIAMOND_BOOTS));
        inventory.setItem(0, new ItemStack(Material.DIAMOND_SWORD));
        inventory.setItem(1, new ItemStack(Material.BOW));
        inventory.setItem(9, new ItemStack(Material.ARROW,20));
        inventory.setItem(2, new ItemStack(Material.COOKED_BEEF,20));
        inventory.setItem(3, new ItemStack(Material.GOLDEN_APPLE,3));
        inventory.setItem(4, damagePotion);
        inventory.setItem(5, healPotion);
        inventory.setItem(6, new ItemStack(Material.COBWEB,5));
        inventory.setItem(7, new ItemStack(Material.LAVA_BUCKET));
        inventory.setItem(8, new ItemStack(Material.WATER_BUCKET));
    }
}
