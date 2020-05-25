package de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.Settings.Design;

import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.BackAction;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.ProfileMenu;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.Settings.SettingsMenu;
import org.bukkit.entity.Player;

import static de.MangoleHD.IMLobby.Data.dsp;

public class DesignMenu {
    public static void openDesignMenu(Player p) {
        PopupMenu menu = ProfileMenu.createSubProfileMenu(dsp.get("design_menu.title", p), p, 3, new BackAction() {
            @Override
            public void onBack(Player player) {
                SettingsMenu.openSettingsMenu(p);
            }
        });
        menu.addMenuItem(DesignItems.subDesignItem(p, "primary", menu), 2, 2);
        menu.addMenuItem(DesignItems.subDesignItem(p, "secondary", menu), 6, 2);
        menu.openMenu(p);
    }

    public static void openDesignMenu(Player p, BackAction action) {
        PopupMenu menu = ProfileMenu.createSubProfileMenu(dsp.get("design_menu.title", p), p, 3, action);
        menu.addMenuItem(DesignItems.subDesignItem(p, "primary", menu), 2, 2);
        menu.addMenuItem(DesignItems.subDesignItem(p, "secondary", menu), 6, 2);
        menu.openMenu(p);
    }

}
