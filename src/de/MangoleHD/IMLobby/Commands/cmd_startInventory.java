package de.MangoleHD.IMLobby.Commands;

import de.Iclipse.IMAPI.Util.Command.IMCommand;
import de.MangoleHD.IMLobby.Data;
import de.MangoleHD.IMLobby.StaticClasses.getVisibility;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;


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
        comp.setDisplayName(Data.dsp.get("startinventory.name.teleporter", p));
        comp.setLore(Arrays.asList(new String[]{Data.dsp.get("startinventory.lore.teleporter", p)}));
        compass.setItemMeta(comp);

        ItemStack settings = new ItemStack(Material.REPEATER);
        ItemMeta sett = settings.getItemMeta();
        sett.setDisplayName(Data.dsp.get("startinventory.name.settings", p));
        sett.setLore(Arrays.asList(new String[]{Data.dsp.get("startinventory.lore.settings", p)}));
        settings.setItemMeta(sett);

        ItemStack enderpearl = new ItemStack(Material.ENDER_PEARL);
        ItemMeta ender = enderpearl.getItemMeta();
        ender.setDisplayName(Data.dsp.get("startinventory.name.beam", p));
        ender.setLore(Arrays.asList(new String[]{Data.dsp.get("startinventory.lore.beam", p)}));
        enderpearl.setItemMeta(ender);

        ItemStack news = new ItemStack(Material.BOOK);
        ItemMeta n = news.getItemMeta();
        n.setDisplayName(Data.dsp.get("startinventory.name.news", p));
       n.setLore(Arrays.asList(new String[]{Data.dsp.get("startinventory.lore.news", p)}));
        news.setItemMeta(n);

        ItemStack visibility = new ItemStack(Material.LIME_DYE);
        ItemMeta visimeta = visibility.getItemMeta();
        visimeta.setDisplayName(Data.dsp.get("startinventory.name.visibility", p));
        visimeta.setLore(Arrays.asList(new String[]{Data.dsp.get("startinventory.lore.visibility", p)}));
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
