package de.MangoleHD.IMLobby.Commands;

import de.Iclipse.IMAPI.Data;
import de.Iclipse.IMAPI.Util.Command.IMCommand;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.Iclipse.IMAPI.Util.menu.MenuItem;
import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import de.MangoleHD.IMLobby.StaticClasses.getVisibility;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.List;

import static de.Iclipse.IMAPI.Functions.MySQL.MySQL_User.getLanguage;
import static de.MangoleHD.IMLobby.Data.dsp;

public class cmd_startInventory {

    @IMCommand(
            name = "startInventory",
            noConsole = true,
            minArgs = 0,
            maxArgs = 0,
            permissions = "im.cmd.startinventory"

    )
    public void execute(Player p) {
        Inventory i = p.getInventory();
        i.clear();
        //Items
        ItemStack compass = new ItemStack(Material.COMPASS);
        ItemMeta comp = compass.getItemMeta();
        comp.setDisplayName(Data.dsp.get("startinventory.name.teleporter", getLanguage(UUIDFetcher.getUUID(p.getName()))));
        //comp.setLore(new String[]{Data.dsp.get("startinventory.lore.teleporter", getLanguage(UUIDFetcher.getUUID(p.getName())))});
        compass.setItemMeta(comp);

        ItemStack settings = new ItemStack(Material.REPEATER);
        ItemMeta sett = settings.getItemMeta();
        sett.setDisplayName(Data.dsp.get("startinventory.name.settings", getLanguage(UUIDFetcher.getUUID(p.getName()))));
        //sett.setLore({Data.dsp.get("startinventory.lore.settings", getLanguage(UUIDFetcher.getUUID(p.getName())))});
        settings.setItemMeta(sett);

        ItemStack enderpearl = new ItemStack(Material.ENDER_PEARL);
        ItemMeta ender = enderpearl.getItemMeta();
        ender.setDisplayName(Data.dsp.get("startinventory.name.beam", getLanguage(UUIDFetcher.getUUID(p.getName()))));
       // ender.setLore(Data.dsp.get("startinventory.lore.beam", getLanguage(UUIDFetcher.getUUID(p.getName()))));
        enderpearl.setItemMeta(ender);

        ItemStack news = new ItemStack(Material.BOOK);
        ItemMeta n = news.getItemMeta();
        n.setDisplayName(Data.dsp.get("startinventory.name.news", getLanguage(UUIDFetcher.getUUID(p.getName()))));
       // n.setLore(Data.dsp.get("startinventory.lore.news", getLanguage(UUIDFetcher.getUUID(p.getName()))));
        news.setItemMeta(n);

        ItemStack visibility = new ItemStack(Material.LIME_DYE);
        ItemMeta visimeta = visibility.getItemMeta();
        visimeta.setDisplayName(Data.dsp.get("startinventory.name.visibility", getLanguage(UUIDFetcher.getUUID(p.getName()))));
       // visimeta.setLore(Data.dsp.get("startinventory.lore.visibility", getLanguage(UUIDFetcher.getUUID(p.getName()))));
        visibility.setItemMeta(visimeta);

        //Inventory
        i.setItem(0,compass);
        i.setItem(8,settings);
        i.setItem(1,enderpearl);
        i.setItem(7,news);
        i.setItem(2,visibility);

        p.setFoodLevel(20);
        p.setHealth(20);
        getVisibility.getGreen(p);

    }
}
