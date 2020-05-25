package de.MangoleHD.IMLobby.PopupMenus.ProfileMenu;

import de.Iclipse.IMAPI.Data;
import de.Iclipse.IMAPI.Database.UserSettings;
import de.Iclipse.IMAPI.Util.ItemStackBuilder;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.Iclipse.IMAPI.Util.menu.MenuItem;
import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.Friendmenu.FriendMenu;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.LobbyInventory.InventoryMenu;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.News.NewsMenu;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.Settings.SettingsMenu;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

import static de.MangoleHD.IMLobby.Data.dsp;

public class ProfileItems {
    public static MenuItem friendItem(Player p) {
        /*
        ItemStackBuilder builder = ItemStackBuilder.fromItemStack(Data.heads.get("friendmenu"));
        builder.withName(dsp.get("profile.friend_menu", p));
        builder.withLore(dsp.get("profile.friend_menu.lore", p));
        return new MenuItem(builder.buildStack()) {
            @Override
            public void onClick(Player player) {
                UserSettings.setInt(UUIDFetcher.getUUID(p.getName()), "profile_page", 0);
                FriendMenu.openFriendMenu(player, 0);
            }
        };
         */
        ItemStack item = Data.heads.get("friendmenu");
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(dsp.get("profile.friend_menu", p));
        meta.setLore(Arrays.asList(new String[]{dsp.get("profile.friend_menu.lore", p)}));
        item.setItemMeta(meta);
        return new MenuItem(item) {
            @Override
            public void onClick(Player player) {
                UserSettings.setInt(UUIDFetcher.getUUID(p.getName()), "profile_page", 0);
                FriendMenu.openFriendMenu(player, 0);
            }
        };
    }

    public static MenuItem settingsItem(Player p) {
        ItemStackBuilder builder = new ItemStackBuilder(Material.REPEATER);
        builder.withName(dsp.get("profile.settings", p));
        builder.withLore(dsp.get("profile.settings.lore", p));
        return new MenuItem(builder.buildStack()) {
            @Override
            public void onClick(Player player) {
                UserSettings.setInt(UUIDFetcher.getUUID(p.getName()), "profile_page", 1);
                SettingsMenu.openSettingsMenu(player);
            }
        };
    }

    public static MenuItem inventoryItem(Player p) {
        ItemStackBuilder builder = new ItemStackBuilder(Material.CHEST);
        builder.withName(dsp.get("profile.inventory", p));
        builder.withLore(dsp.get("profile.inventory.lore", p));
        return new MenuItem(builder.buildStack()) {
            @Override
            public void onClick(Player player) {
                UserSettings.setInt(UUIDFetcher.getUUID(p.getName()), "profile_page", 2);
                InventoryMenu.openInventoryMenu(player);
            }
        };
    }

    public static MenuItem newsItem(Player p) {
        ItemStackBuilder builder = ItemStackBuilder.fromItemStack(Data.heads.get("news"));
        builder.withName(dsp.get("profile.news", p));
        builder.withLore(dsp.get("profile.news.lore", p));
        return new MenuItem(builder.buildStack()) {
            @Override
            public void onClick(Player player) {
                UserSettings.setInt(UUIDFetcher.getUUID(p.getName()), "profile_page", 3);
                NewsMenu.openNewsMenu(player, 0);
            }
        };
    }

    public static MenuItem primaryGlass(Player p) {
        ItemStackBuilder builder = new ItemStackBuilder(Material.getMaterial(UserSettings.getString(UUIDFetcher.getUUID(p.getName()), "design_primary") + "_STAINED_GLASS_PANE"));
        builder.withName(" ");
        builder.withLore(" ");
        return new MenuItem(builder.buildStack()) {
            @Override
            public void onClick(Player player) {
            }
        };
    }

    public static MenuItem secondaryGlass(Player p) {
        ItemStackBuilder builder = new ItemStackBuilder(Material.getMaterial(UserSettings.getString(UUIDFetcher.getUUID(p.getName()), "design_secondary") + "_STAINED_GLASS_PANE"));
        builder.withName(" ");
        builder.withLore(" ");
        builder.addEnchantment(Enchantment.LUCK, 1);
        return new MenuItem(builder.buildStack()) {
            @Override
            public void onClick(Player player) {
            }
        };
    }

    public static MenuItem closeItem(Player p, PopupMenu last) {
        ItemStackBuilder builder = new ItemStackBuilder(Material.BARRIER);
        builder.withName(dsp.get("profile.close", p));
        builder.withLore(" ");
        return new MenuItem(builder.buildStack()) {
            @Override
            public void onClick(Player player) {
                last.openMenu(p);
            }
        };
    }

    public static MenuItem closeItem(Player p, BackAction action) {
        ItemStackBuilder builder = new ItemStackBuilder(Material.BARRIER);
        builder.withName(dsp.get("profile.close", p));
        builder.withLore(" ");
        return new MenuItem(builder.buildStack()) {
            @Override
            public void onClick(Player player) {
                action.onBack(player);
            }
        };
    }

    public static ItemStack previousPage(Player p, int page, int maxPage) {
        ItemStackBuilder builder = ItemStackBuilder.fromItemStack(Data.heads.get("arrowLeft" + UserSettings.getString(UUIDFetcher.getUUID(p.getName()), "design_secondary")));
        builder.withName(dsp.get("profile.previousPage", p));
        builder.withLore("§8" + dsp.get("profile.page", p) + " " + (page - 1) + "/" + maxPage);
        return builder.buildStack();
    }

    public static ItemStack nextPage(Player p, int page, int maxPage) {
        ItemStackBuilder builder = ItemStackBuilder.fromItemStack(Data.heads.get("arrowRight" + UserSettings.getString(UUIDFetcher.getUUID(p.getName()), "design_secondary")));
        builder.withName(dsp.get("profile.nextPage", p));
        builder.withLore("§8" + dsp.get("profile.page", p) + " " + (page + 1) + "/" + maxPage);
        return builder.buildStack();
    }

    public static ItemStack increaseItem(Player p) {
        ItemStackBuilder builder = ItemStackBuilder.fromItemStack(Data.heads.get("arrowUp" + UserSettings.getString(UUIDFetcher.getUUID(p.getName()), "design_secondary")));
        builder.withName(dsp.get("profile.increase", p));
        return builder.buildStack();
    }

    public static ItemStack decreaseItem(Player p) {
        ItemStackBuilder builder = ItemStackBuilder.fromItemStack(Data.heads.get("arrowDown" + UserSettings.getString(UUIDFetcher.getUUID(p.getName()), "design_secondary")));
        builder.withName(dsp.get("profile.decrease", p));
        return builder.buildStack();
    }

    public static ItemStack luckyBlockItem(Player p) {
        ItemStackBuilder builder = ItemStackBuilder.fromItemStack(Data.heads.get("luckyBlock" + UserSettings.getString(UUIDFetcher.getUUID(p.getName()), "design_secondary")));
        return builder.buildStack();
    }

    public static ItemStack toggleItem(Player p, boolean toggled) {
        ItemStackBuilder builder;
        if (toggled) {
            builder = new ItemStackBuilder(Material.LIME_DYE);
            builder.withName(dsp.get("profile.toggled", p));
        } else {
            builder = new ItemStackBuilder(Material.GRAY_DYE);
            builder.withName(dsp.get("profile.nottoggled", p));
        }
        return builder.buildStack();
    }
}
