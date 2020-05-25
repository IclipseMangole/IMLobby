package de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.Settings;

import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.ProfileMenu;
import org.bukkit.entity.Player;

public class SettingsMenu {
    public static void openSettingsMenu(Player p) {
        PopupMenu menu = ProfileMenu.createProfileMenu("Settings", p);
        menu.addMenuItem(SettingsItems.comingSoonItem(p), 0, 2);
        menu.addMenuItem(SettingsItems.comingSoonItem(p), 1, 2);
        menu.addMenuItem(SettingsItems.comingSoonItem(p), 2, 2);
        menu.addMenuItem(SettingsItems.comingSoonItem(p), 3, 2);
        menu.addMenuItem(SettingsItems.comingSoonItem(p), 4, 2);
        menu.addMenuItem(SettingsItems.comingSoonItem(p), 5, 2);
        menu.addMenuItem(SettingsItems.statusItem(p), 6, 2);
        menu.addMenuItem(SettingsItems.languageItem(p), 7, 2);
        menu.addMenuItem(SettingsItems.designItem(p), 8, 2);
        menu.openMenu(p);
    }
}
