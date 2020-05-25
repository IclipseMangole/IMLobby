package de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.Settings.Design;

import de.Iclipse.IMAPI.Database.UserSettings;
import de.Iclipse.IMAPI.Util.ItemStackBuilder;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.Iclipse.IMAPI.Util.menu.MenuItem;
import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

import static de.MangoleHD.IMLobby.Data.dsp;

public class DesignItems {
    public static MenuItem subDesignItem(Player p, String subDesign, PopupMenu menu) {
        ItemStackBuilder builder = new ItemStackBuilder(Material.getMaterial(UserSettings.getString(UUIDFetcher.getUUID(p.getName()), "design_" + subDesign) + "_STAINED_GLASS"));
        builder.withName(dsp.get("design_menu." + subDesign + ".name", p));
        builder.withLore(dsp.get("design_menu." + subDesign + ".lore", p));
        return new MenuItem(builder.buildStack()) {
            @Override
            public void onClick(Player player) {
                SubDesignMenu.openSubDesignMenu(p, subDesign, menu);
            }
        };
    }

    public static MenuItem colorItem(Player p, String subDesign, String color, PopupMenu menu) {
        ItemStackBuilder builder = new ItemStackBuilder(Material.getMaterial(color + "_STAINED_GLASS"));
        builder.withName(dsp.get("design_menu.color." + color, p));
        if (UserSettings.getString(UUIDFetcher.getUUID(p.getName()), "design_" + subDesign).equals(color)) {
            builder.addEnchantment(Enchantment.LUCK, 1);
        }
        return new MenuItem(builder.buildStack()) {
            @Override
            public void onClick(Player player) {
                UserSettings.setString(UUIDFetcher.getUUID(p.getName()), "design_" + subDesign, color);
                SubDesignMenu.openSubDesignMenu(p, subDesign, menu);
            }
        };
    }

}
