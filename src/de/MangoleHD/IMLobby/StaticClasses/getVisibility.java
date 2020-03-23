package de.MangoleHD.IMLobby.StaticClasses;

import de.Iclipse.IMAPI.Functions.MySQL.MySQL_UserSettings;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.MangoleHD.IMLobby.Data;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static de.Iclipse.IMAPI.Functions.MySQL.MySQL_User.getLanguage;

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
        dyemeta.setDisplayName(de.Iclipse.IMAPI.Data.dsp.get("visibility.green",getLanguage(UUIDFetcher.getUUID(p.getName()))));
        dye.setItemMeta(dyemeta);
        p.getInventory().setItem(2,dye);
        p.setCustomNameVisible(true);

        for(Player all: Bukkit.getOnlinePlayers()){
            if(MySQL_UserSettings.getInt(UUIDFetcher.getUUID(all.getName()),"vanish")==0) {
                p.showPlayer(Data.instance, all);
            }
        }
        MySQL_UserSettings.setString(UUIDFetcher.getUUID(p.getName()),"visibility","all");
    }

    public static void getPurple(Player p){
        ItemStack dye = new ItemStack(Material.PURPLE_DYE);
        ItemMeta dyemeta = dye.getItemMeta();
        dyemeta.setDisplayName(de.Iclipse.IMAPI.Data.dsp.get("visibility.purple",getLanguage(UUIDFetcher.getUUID(p.getName()))));
        dye.setItemMeta(dyemeta);
        p.getInventory().setItem(2,dye);
        for(Player all: Bukkit.getOnlinePlayers()){
            if(MySQL_UserSettings.getInt(UUIDFetcher.getUUID(all.getName()),"vanish")==0) {
                p.showPlayer(Data.instance, all);
            }
        }
        MySQL_UserSettings.setString(UUIDFetcher.getUUID(p.getName()),"visibility","friends and teammates");
    }

    public static void getGray(Player p){
        ItemStack dye = new ItemStack(Material.GRAY_DYE);
        ItemMeta dyemeta = dye.getItemMeta();
        dyemeta.setDisplayName(de.Iclipse.IMAPI.Data.dsp.get("visibility.gray",getLanguage(UUIDFetcher.getUUID(p.getName()))));
        dye.setItemMeta(dyemeta);
        p.getInventory().setItem(2,dye);
        for(Player all: Bukkit.getOnlinePlayers()){
            p.hidePlayer(Data.instance,all);
        }
        MySQL_UserSettings.setString(UUIDFetcher.getUUID(p.getName()),"visibility","nobody");
    }
}