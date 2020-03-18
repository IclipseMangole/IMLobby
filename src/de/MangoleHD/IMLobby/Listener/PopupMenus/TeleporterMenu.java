package de.MangoleHD.IMLobby.Listener.PopupMenus;

import de.Iclipse.IMAPI.Util.menu.MenuItem;
import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class TeleporterMenu {
    public static void openTeleportMenu(Player p) {
        //Menu
        PopupMenu teleMenu = new PopupMenu("Teleporter", 5);
        //MenuItems
        MenuItem spawn = new MenuItem("Spawn", new ItemStack(Material.DIAMOND)) {
            @Override
            public void onClick(Player player) {
                Location spawn = new Location(player.getWorld(), 0.5, 4, 0.5, 180, 0);
                player.teleport(spawn);
                p.playSound(spawn, Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
            }
        };
        //Menu with Items
        teleMenu.addMenuItem(spawn, 4, 2);

        teleMenu.openMenu(p);
    }
}