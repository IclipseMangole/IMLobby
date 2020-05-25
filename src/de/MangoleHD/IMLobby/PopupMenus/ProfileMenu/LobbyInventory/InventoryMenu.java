package de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.LobbyInventory;

import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.ProfileItems;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.ProfileMenu;
import org.bukkit.entity.Player;

import static de.MangoleHD.IMLobby.Data.dsp;

public class InventoryMenu {
    public static void openInventoryMenu(Player p) {
        PopupMenu menu = ProfileMenu.createProfileMenu(dsp.get("profile.inventory", p), p);
        for (int i = 0; i < 9; i++) {
            menu.addMenuItem(ProfileItems.primaryGlass(p), i);
        }
        menu.addMenuItem(InventoryItems.particleItem(p, menu), 1, 2);
        menu.addMenuItem(InventoryItems.clothingItem(p, menu), 4, 2);
        menu.addMenuItem(InventoryItems.extrasItem(p, menu), 7, 2);
        menu.openMenu(p);
    }
}
