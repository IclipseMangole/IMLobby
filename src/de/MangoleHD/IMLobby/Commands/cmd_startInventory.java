package de.MangoleHD.IMLobby.Commands;

import de.Iclipse.IMAPI.Util.Command.IMCommand;
import de.Iclipse.IMAPI.Util.menu.MenuItem;
import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;

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
        comp.setDisplayName("Teleporter");
        compass.setItemMeta(comp);

        ItemStack settings = new ItemStack(Material.REPEATER);
        ItemMeta sett = settings.getItemMeta();
        sett.setDisplayName("Settings");
        settings.setItemMeta(sett);

        ItemStack enderpearl = new ItemStack(Material.ENDER_PEARL);
        ItemMeta ender = enderpearl.getItemMeta();
        ender.setDisplayName("Beam");
        enderpearl.setItemMeta(ender);

        ItemStack news = new ItemStack(Material.BOOK);
        ItemMeta n = news.getItemMeta();
        n.setDisplayName("News");
        news.setItemMeta(n);
        //Inventory
        i.setItem(0,compass);
        i.setItem(8,settings);
        i.setItem(1,enderpearl);
        i.setItem(7,news);

    }
}
