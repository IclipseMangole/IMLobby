package de.MangoleHD.IMLobby.PopupMenus;

import de.Iclipse.IMAPI.Util.menu.MenuItem;
import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import de.MangoleHD.IMLobby.Data;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class TeleporterMenu {
    public static void openTeleportMenu(Player p) {
        //Menu
        PopupMenu teleMenu = new PopupMenu(Data.dsp.get("teleporter.menu", p), 5);
        //MenuItems
        MenuItem spawn = new MenuItem(Data.dsp.get("teleporter.spawn", p), new ItemStack(Material.DIAMOND)) {
            @Override
            public void onClick(Player player) {
                player.teleport(Data.spawn);
                p.playSound(Data.spawn, Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
            }
        };
        spawn.setLore(Data.dsp.get("teleporter.spawn.lore", p));

        //Menu with Items
        teleMenu.addMenuItem(spawn, 4, 2);

        teleMenu.openMenu(p);
    }
}