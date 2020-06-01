package de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.Settings.Status;

import de.Iclipse.IMAPI.Database.UserSettings;
import de.Iclipse.IMAPI.Util.ItemStackBuilder;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.Iclipse.IMAPI.Util.menu.MenuItem;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

import static de.MangoleHD.IMLobby.Data.dsp;

public class StatusItems {
    public static MenuItem statusLineItem(Player p, int line) {
        ItemStackBuilder builder = new ItemStackBuilder(Material.NAME_TAG);
        builder.withName(dsp.get("status.item.name", p, line + ""));
        ArrayList<String> list = new ArrayList<>();
        list.add(dsp.get("status.item.lore0", p, getStatus(p, line)));
        list.add("");
        list.add(dsp.get("status.item.lore1", p));
        list.add(dsp.get("status.item.lore2", p, line + ""));
        builder.withLore(list);
        return new MenuItem(builder.buildStack()) {
            @Override
            public void onClick(Player player) {
                StatusMenu.openChangeMenu(p, line);
            }
        };
    }

    public static MenuItem resetLineItem(Player p, int line) {
        ItemStackBuilder builder = new ItemStackBuilder(Material.BARRIER);
        builder.withName(dsp.get("status.reset.name", p, line + ""));
        ArrayList<String> list = new ArrayList<>();
        list.add(dsp.get("status.reset.lore0", p));
        list.add(dsp.get("status.reset.lore1", p, line + ""));
        builder.withLore(list);
        return new MenuItem(builder.buildStack()) {
            @Override
            public void onClick(Player player) {
                UserSettings.setString(UUIDFetcher.getUUID(p.getName()), "status_line" + line, "");
                StatusMenu.openStatusMenu(p);
            }
        };
    }

    public static ItemStack changeLineItem(Player p, int line) {
        ItemStackBuilder builder = new ItemStackBuilder(Material.NAME_TAG);
        builder.withName(getStatus(p, line));
        ArrayList<String> list = new ArrayList<>();
        list.add(dsp.get("status.change.lore0", p));
        list.add(dsp.get("status.change.lore1", p));
        builder.withLore(list);
        return builder.buildStack();
    }

    public static String getStatus(Player p, int line) {
        return UserSettings.getString(UUIDFetcher.getUUID(p.getName()), "status_line" + line) == null ? "" : UserSettings.getString(UUIDFetcher.getUUID(p.getName()), "status_line" + line);
    }
}
