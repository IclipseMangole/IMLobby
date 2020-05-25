package de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.Settings.Language;

import de.Iclipse.IMAPI.Database.User;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.BackAction;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.ProfileItems;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.ProfileMenu;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.Settings.SettingsMenu;
import org.bukkit.entity.Player;

import static de.MangoleHD.IMLobby.Data.dsp;

public class LanguageMenu {
    public static void openLanguageMenu(Player p) {
        PopupMenu menu = ProfileMenu.createSubProfileMenu(dsp.get("language.name", p), p, 3, new BackAction() {
            @Override
            public void onBack(Player player) {
                SettingsMenu.openSettingsMenu(player);
            }
        });

        if (User.getLanguage(UUIDFetcher.getUUID(p.getName())).equals("EN")) {
            menu.removeMenuItem(2, 0);
            menu.addMenuItem(ProfileItems.secondaryGlass(p), 2, 0);
        } else {
            menu.removeMenuItem(6, 0);
            menu.addMenuItem(ProfileItems.secondaryGlass(p), 6, 0);
        }

        menu.addMenuItem(LanguageItems.languageItem(p, "EN"), 2, 2);
        menu.addMenuItem(LanguageItems.languageItem(p, "DE"), 6, 2);
        menu.openMenu(p);
    }
}
