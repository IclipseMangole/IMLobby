package de.MangoleHD.IMLobby.StaticClasses;

import de.MangoleHD.IMLobby.Data;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class getExtras {

    public static void getRocket(Player p) {
        ItemStack rocket = new ItemStack(Material.FIREWORK_ROCKET);
        ItemMeta rocketmeta = rocket.getItemMeta();
        rocketmeta.setDisplayName(Data.dsp.get("extras.rocket", p));
        rocket.setItemMeta(rocketmeta);
        p.getInventory().setItem(4, rocket);
    }

    public static void getChickenBomb(Player p) {
        ItemStack egg = new ItemStack(Material.EGG);
        ItemMeta eggmeta = egg.getItemMeta();
        eggmeta.setDisplayName(Data.dsp.get("extras.chickenbomb", p));
        egg.setItemMeta(eggmeta);
        p.getInventory().setItem(4, egg);
    }
}
