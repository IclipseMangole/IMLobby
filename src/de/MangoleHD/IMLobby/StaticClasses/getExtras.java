package de.MangoleHD.IMLobby.StaticClasses;

import de.Iclipse.IMAPI.Data;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static de.Iclipse.IMAPI.Functions.MySQL.MySQL_User.getLanguage;

public class getExtras {

    public static void getRocket(Player p){
        ItemStack rocket = new ItemStack(Material.FIREWORK_ROCKET);
        ItemMeta rocketmeta = rocket.getItemMeta();
        rocketmeta.setDisplayName(Data.dsp.get("extras.rocket", getLanguage(UUIDFetcher.getUUID(p.getName()))));
        rocket.setItemMeta(rocketmeta);
        p.getInventory().setItem(4,rocket);
    }

    public static void getChickenBomb(Player p){
        ItemStack egg = new ItemStack(Material.EGG);
        ItemMeta eggmeta = egg.getItemMeta();
        eggmeta.setDisplayName(Data.dsp.get("extras.chickenbomb", getLanguage(UUIDFetcher.getUUID(p.getName()))));
        egg.setItemMeta(eggmeta);
        p.getInventory().setItem(4,egg);
    }
}
