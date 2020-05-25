package de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.Settings.Design;

import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.BackAction;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.ProfileMenu;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.Settings.SettingsMenu;
import org.bukkit.entity.Player;

import static de.MangoleHD.IMLobby.Data.dsp;

public class SubDesignMenu {
    public static void openSubDesignMenu(Player p, String subDesign, PopupMenu last) {
        PopupMenu menu = ProfileMenu.createSubProfileMenu(dsp.get("design_menu.title", p), p, 2, new BackAction() {
            @Override
            public void onBack(Player player) {
                DesignMenu.openDesignMenu(p, new BackAction() {
                    @Override
                    public void onBack(Player player) {
                        SettingsMenu.openSettingsMenu(player);
                    }
                });
            }
        });


        //FirstRow
        menu.addMenuItem(DesignItems.colorItem(p, subDesign, "PINK", last), 1, 2);
        menu.addMenuItem(DesignItems.colorItem(p, subDesign, "RED", last), 2, 2);
        menu.addMenuItem(DesignItems.colorItem(p, subDesign, "ORANGE", last), 3, 2);
        menu.addMenuItem(DesignItems.colorItem(p, subDesign, "YELLOW", last), 4, 2);
        menu.addMenuItem(DesignItems.colorItem(p, subDesign, "GREEN", last), 5, 2);
        menu.addMenuItem(DesignItems.colorItem(p, subDesign, "BLACK", last), 6, 2);
        menu.addMenuItem(DesignItems.colorItem(p, subDesign, "GRAY", last), 7, 2);

        //SecondRow
        menu.addMenuItem(DesignItems.colorItem(p, subDesign, "PURPLE", last), 0, 3);
        menu.addMenuItem(DesignItems.colorItem(p, subDesign, "MAGENTA", last), 1, 3);
        menu.addMenuItem(DesignItems.colorItem(p, subDesign, "BLUE", last), 2, 3);
        menu.addMenuItem(DesignItems.colorItem(p, subDesign, "LIGHT_BLUE", last), 3, 3);
        menu.addMenuItem(DesignItems.colorItem(p, subDesign, "CYAN", last), 4, 3);
        menu.addMenuItem(DesignItems.colorItem(p, subDesign, "LIME", last), 5, 3);
        menu.addMenuItem(DesignItems.colorItem(p, subDesign, "BROWN", last), 6, 3);
        menu.addMenuItem(DesignItems.colorItem(p, subDesign, "LIGHT_GRAY", last), 7, 3);
        menu.addMenuItem(DesignItems.colorItem(p, subDesign, "WHITE", last), 8, 3);

        menu.openMenu(p);
    }
}
