package de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.Settings;

import de.Iclipse.IMAPI.Database.User;
import de.Iclipse.IMAPI.Database.UserSettings;
import de.Iclipse.IMAPI.Util.ItemStackBuilder;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.Iclipse.IMAPI.Util.menu.MenuItem;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.Settings.Design.DesignMenu;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.Settings.Language.LanguageMenu;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.Settings.Status.StatusMenu;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

import static de.Iclipse.IMAPI.Data.heads;
import static de.MangoleHD.IMLobby.Data.dsp;

public class SettingsItems {


    public static MenuItem statusItem(Player p) {
        ItemStackBuilder builder = new ItemStackBuilder(Material.NAME_TAG);
        builder.withName(dsp.get("status.name", p));
        builder.withLore(dsp.get("status.lore0", p));
        builder.withLore(dsp.get("status.lore1", p));
        return new MenuItem(builder.buildStack()) {
            @Override
            public void onClick(Player player) {
                StatusMenu.openStatusMenu(p);
            }
        };
    }

    public static MenuItem languageItem(Player p) {
        ItemStackBuilder builder = ItemStackBuilder.fromItemStack(heads.get(User.getLanguage(UUIDFetcher.getUUID(p.getName()))));
        builder.withName(dsp.get("language.name", p));
        builder.withLore(dsp.get("language.lore", p));
        return new MenuItem(builder.buildStack()) {
            @Override
            public void onClick(Player player) {
                LanguageMenu.openLanguageMenu(p);
            }
        };
    }

    public static MenuItem designItem(Player p) {
        ItemStackBuilder builder = new ItemStackBuilder(Material.getMaterial(UserSettings.getString(UUIDFetcher.getUUID(p.getName()), "design_primary") + "_STAINED_GLASS"));
        builder.withName(dsp.get("design_menu.name", p));
        builder.withLore(dsp.get("design_menu.lore", p));
        return new MenuItem(builder.buildStack()) {
            @Override
            public void onClick(Player player) {
                DesignMenu.openDesignMenu(p);
            }
        };
    }

    public static MenuItem comingSoonItem(Player p) {
        ItemStackBuilder builder = new ItemStackBuilder(Material.BARRIER);
        builder.withName(dsp.get("settings.comingsoon.name", p));
        builder.withLore(dsp.get("settings.comingsoon.lore", p));
        builder.addEnchantment(Enchantment.LUCK, 1);
        return new MenuItem(builder.buildStack()) {
            @Override
            public void onClick(Player player) {
            }
        };
    }
}
