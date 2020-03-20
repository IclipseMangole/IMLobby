package de.MangoleHD.IMLobby.StaticClasses;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class getExtras {

    public static void getRocket(Player p){
        ItemStack rocket = new ItemStack(Material.FIREWORK_ROCKET);
        ItemMeta rocketmeta = rocket.getItemMeta();
        rocketmeta.setDisplayName("§cRocket");
        rocket.setItemMeta(rocketmeta);
        p.getInventory().setItem(4,rocket);
    }

    public static void getChickenBomb(Player p){
        ItemStack egg = new ItemStack(Material.EGG);
        ItemMeta eggmeta = egg.getItemMeta();
        eggmeta.setDisplayName("§cChickenBomb");
        egg.setItemMeta(eggmeta);
        p.getInventory().setItem(4,egg);
    }
}
