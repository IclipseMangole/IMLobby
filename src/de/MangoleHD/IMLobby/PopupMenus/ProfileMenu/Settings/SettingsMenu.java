package de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.Settings;

import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.ProfileMenu;
import org.bukkit.entity.Player;

public class SettingsMenu {
    public static void openSettingsMenu(Player p) {
        PopupMenu menu = ProfileMenu.createProfileMenu("Settings", p);
        menu.openMenu(p);
    }
}
