package de.MangoleHD.IMLobby.Listener.PopupMenus;

import de.Iclipse.IMAPI.Functions.MySQL.MySQL_Mode;
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

        MySQL_Mode.getModes().forEach(mode ->{
            MenuItem modeitem = new MenuItem(MySQL_Mode.getDisplayname(mode), MySQL_Mode.getItem(mode)) {
                @Override
                public void onClick(Player player) {
                    player.teleport(MySQL_Mode.getLocation(mode));
                    p.playSound(MySQL_Mode.getLocation(mode), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
                }
            };
            teleMenu.addMenuItem(modeitem, MySQL_Mode.getSlot(mode));
        });
        teleMenu.openMenu(p);
    }
}