package de.MangoleHD.IMLobby.PopupMenus.ProfileMenu;


import de.Iclipse.IMAPI.Database.UserSettings;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.Friendmenu.FriendMenu;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.LobbyInventory.InventoryMenu;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.News.NewsMenu;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.Settings.SettingsMenu;
import org.bukkit.entity.Player;

import static de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.ProfileItems.*;

public class ProfileMenu {

    public static void openProfileMenu(Player p) {
        switch (UserSettings.getInt(UUIDFetcher.getUUID(p.getName()), "profile_page")) {
            case 0:
                FriendMenu.openFriendMenu(p, 0);
                break;
            case 1:
                SettingsMenu.openSettingsMenu(p);
                break;
            case 2:
                InventoryMenu.openInventoryMenu(p);
                break;
            default:
                NewsMenu.openNewsMenu(p, 0);
        }
    }

    public static PopupMenu createProfileMenu(String title, Player p) {
        PopupMenu menu = new PopupMenu(title, 6);
        //Fill with primary Glass
        for (int x = 0; x < 9; x++) {
            menu.addMenuItem(primaryGlass(p), x, 4);
        }
        menu.addMenuItem(primaryGlass(p), 4, 5);
        //Set Secondary Glass
        menu.removeMenuItem(UserSettings.getInt(UUIDFetcher.getUUID(p.getName()), "profile_page"), 4);
        menu.addMenuItem(secondaryGlass(p), UserSettings.getInt(UUIDFetcher.getUUID(p.getName()), "profile_page"), 4);
        //Add special items
        menu.addMenuItem(friendItem(p), 0, 5);
        menu.addMenuItem(settingsItem(p), 1, 5);
        menu.addMenuItem(inventoryItem(p), 2, 5);
        menu.addMenuItem(newsItem(p), 3, 5);
        return menu;
    }

    public static PopupMenu createSubProfileMenu(String title, Player p, int lines, BackAction action) {
        PopupMenu menu = createProfileMenu(title, p);
        for (int i = 0; i < 4 - lines; i++) {
            for (int x = 0; x < 9; x++) {
                menu.addMenuItem(primaryGlass(p), x, i);
            }
        }
        menu.removeMenuItem(8, 0);
        menu.addMenuItem(closeItem(p, action), 8, 0);
        return menu;
    }


}
