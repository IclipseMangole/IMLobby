package de.MangoleHD.IMLobby.StaticClasses;

import de.Iclipse.IMAPI.Database.UserSettings;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.MangoleHD.IMLobby.Data;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class getVisibility {

    public static void changeDye(ItemStack item, Player p) {
        if (item.getType().equals(Material.LIME_DYE)) {
            getPurple(p);
        } else if (item.getType().equals(Material.PURPLE_DYE)) {
            getGray(p);
        } else {
            getGreen(p);
        }
    }


    public static void getGreen(Player p) {
        ItemStack dye = new ItemStack(Material.LIME_DYE);
        ItemMeta dyemeta = dye.getItemMeta();
        dyemeta.setDisplayName(Data.dsp.get("visibility.green", p));
        dye.setItemMeta(dyemeta);
        p.getInventory().setItem(2,dye);
        p.setCustomNameVisible(true);

        for(Player all: Bukkit.getOnlinePlayers()){
            if (!UserSettings.getBoolean(UUIDFetcher.getUUID(all.getName()), "vanish")) {
                p.showPlayer(Data.instance, all);
            }
        }
        UserSettings.setString(UUIDFetcher.getUUID(p.getName()), "visibility", "all");
    }

    public static void getPurple(Player p){
        ItemStack dye = new ItemStack(Material.PURPLE_DYE);
        ItemMeta dyemeta = dye.getItemMeta();
        dyemeta.setDisplayName(Data.dsp.get("visibility.purple",p));
        dye.setItemMeta(dyemeta);
        p.getInventory().setItem(2,dye);
        for(Player all: Bukkit.getOnlinePlayers()){
            if (!UserSettings.getBoolean(UUIDFetcher.getUUID(all.getName()), "vanish")) {
                p.showPlayer(Data.instance, all);
            }
        }
        UserSettings.setString(UUIDFetcher.getUUID(p.getName()), "visibility", "friends and teammates");
    }

    public static void getGray(Player p){
        ItemStack dye = new ItemStack(Material.GRAY_DYE);
        ItemMeta dyemeta = dye.getItemMeta();
        dyemeta.setDisplayName(Data.dsp.get("visibility.gray",p));
        dye.setItemMeta(dyemeta);
        p.getInventory().setItem(2,dye);
        for(Player all: Bukkit.getOnlinePlayers()){
            p.hidePlayer(Data.instance,all);
        }
        UserSettings.setString(UUIDFetcher.getUUID(p.getName()), "visibility", "nobody");
    }
}