package de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.Friendmenu;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import de.Iclipse.IMAPI.Database.Friend;
import de.Iclipse.IMAPI.Database.User;
import de.Iclipse.IMAPI.Database.UserSettings;
import de.Iclipse.IMAPI.Util.ItemStackBuilder;
import de.Iclipse.IMAPI.Util.SkullUtils;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.Iclipse.IMAPI.Util.menu.MenuItem;
import de.MangoleHD.IMLobby.Data;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.BackAction;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.ProfileItems;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static de.Iclipse.IMAPI.Data.heads;
import static de.MangoleHD.IMLobby.Data.dsp;

public class FriendItems {
    public static MenuItem onlineHead(Player p, UUID friend, int page) {
        ItemStackBuilder builder = ItemStackBuilder.fromItemStack(SkullUtils.getPlayerSkull(friend));
        if (Friend.isFavorite(UUIDFetcher.getUUID(p.getName()), friend)) {
            builder.withName(dsp.get("friend_menu.head.favorite_name", p, de.Iclipse.IMAPI.Data.tablist.getPrefix(friend) + UUIDFetcher.getName(friend)));
        } else {
            builder.withName(dsp.get("friend_menu.head.name", p, de.Iclipse.IMAPI.Data.tablist.getPrefix(friend) + UUIDFetcher.getName(friend)));
        }
        ArrayList<String> lores = new ArrayList<>();
        lores.add(dsp.get("friend_menu.head.online.lore", p, User.getServer(friend)));

        String status1 = UserSettings.getString(friend, "status_line1");
        String status2 = UserSettings.getString(friend, "status_line2");
        if (!status1.equalsIgnoreCase("") || !status2.equalsIgnoreCase("")) {
            lores.add("");
            if (!status1.equalsIgnoreCase("")) {
                lores.add(dsp.get("friend_menu.head.status", p, ChatColor.translateAlternateColorCodes('&', status1)));
            }
            if (!status2.equalsIgnoreCase("")) {
                lores.add(dsp.get("friend_menu.head.status", p, ChatColor.translateAlternateColorCodes('&', status2)));
            }
        }
        builder.withLore(lores);

        return new MenuItem(builder.buildStack()) {
            @Override
            public void onClick(Player player) {
                FriendheadMenu.openFriendheadMenu(player, friend, page);
            }
        };
    }

    public static MenuItem offlineHead(Player p, UUID friend, int page) {
        ItemStackBuilder builder = new ItemStackBuilder(Material.SKELETON_SKULL);
        if (Friend.isFavorite(UUIDFetcher.getUUID(p.getName()), friend)) {
            builder.withName("§e" + dsp.get("friend_menu.head.favorite_name", p, UUIDFetcher.getName(friend)));
        } else {
            builder.withName("§7" + dsp.get("friend_menu.head.name", p, UUIDFetcher.getName(friend)));
        }
        ArrayList<String> lores = new ArrayList<>();

        lores.add(dsp.get("friend_menu.head.offline.lore", p, getLastSeen(p, friend)));

        String status1 = UserSettings.getString(friend, "status_line1");
        String status2 = UserSettings.getString(friend, "status_line2");
        if (!status1.equalsIgnoreCase("") || !status2.equalsIgnoreCase("")) {
            lores.add("");
            if (!status1.equalsIgnoreCase("")) {
                lores.add(dsp.get("friend_menu.head.status", p, ChatColor.translateAlternateColorCodes('&', status1)));
            }
            if (!status2.equalsIgnoreCase("")) {
                lores.add(dsp.get("friend_menu.head.status", p, ChatColor.translateAlternateColorCodes('&', status2)));
            }
        }
        builder.withLore(lores);

        return new MenuItem(builder.buildStack()) {
            @Override
            public void onClick(Player player) {
                FriendheadMenu.openFriendheadMenu(player, friend, page);
            }
        };
    }

    public static MenuItem requestHead(Player p, UUID request, int friendPage) {
        ItemStackBuilder builder = ItemStackBuilder.fromItemStack(SkullUtils.getPlayerSkull(request));
        builder.withName(de.Iclipse.IMAPI.Data.tablist.getPrefix(request) + UUIDFetcher.getName(request));
        return new MenuItem(builder.buildStack()) {
            @Override
            public void onClick(Player player) {
                RequestheadMenu.openRequestheadMenu(p, request, friendPage);
            }
        };
    }

    public static MenuItem addFavoriteItem(Player p, UUID uuid, BackAction action) {
        /*
        ItemStackBuilder builder = ItemStackBuilder.fromItemStack(heads.get("friend_nonfavorite"));
        builder.withName(dsp.get("friend_menu.head_menu.addFavorite", p));
        builder.withLore(dsp.get("friend_menu.head_menu.addFavorite.lore", p, UUIDFetcher.getName(uuid)));
        return new MenuItem(builder.buildStack()) {
            @Override
            public void onClick(Player player) {
                Friend.setFavorite(UUIDFetcher.getUUID(p.getName()), uuid, true);
                player.updateInventory();
            }
        };
         */
        ItemStack item = heads.get("friend_nonfavorite");
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(dsp.get("friend_menu.head_menu.addFavorite", p));
        List<String> list = Arrays.asList(new String[]{dsp.get("friend_menu.head_menu.addFavorite.lore", p, UUIDFetcher.getName(uuid))});
        meta.setLore(list);
        item.setItemMeta(meta);
        return new MenuItem(item) {
            @Override
            public void onClick(Player player) {
                Friend.setFavorite(UUIDFetcher.getUUID(p.getName()), uuid, true);
                action.onBack(player);
            }
        };
    }

    public static MenuItem removeFavoriteItem(Player p, UUID uuid, BackAction action) {
        ItemStackBuilder builder = ItemStackBuilder.fromItemStack(heads.get("friend_favorite"));
        builder.withName(dsp.get("friend_menu.head_menu.removeFavorite", p));
        builder.withLore(dsp.get("friend_menu.head_menu.removeFavorite.lore", p, UUIDFetcher.getName(uuid)));
        return new MenuItem(builder.buildStack()) {
            @Override
            public void onClick(Player player) {
                Friend.setFavorite(UUIDFetcher.getUUID(p.getName()), uuid, false);
                action.onBack(player);
            }
        };
    }

    public static MenuItem jumpItem(Player p, UUID uuid) {
        ItemStackBuilder builder = new ItemStackBuilder(Material.ENDER_PEARL);
        builder.withName(dsp.get("friend_menu.head_menu.jump", p));
        builder.withLore(dsp.get("friend_menu.head_menu.jump.lore", p, UUIDFetcher.getName(uuid)));
        return new MenuItem(builder.buildStack()) {
            @Override
            public void onClick(Player player) {
                ByteArrayDataOutput out = ByteStreams.newDataOutput();
                out.writeUTF("Connect");
                out.writeUTF(User.getServer(uuid));
                player.sendPluginMessage(Data.instance, "BungeeCord", out.toByteArray());
            }
        };
    }

    public static MenuItem removeFriendItem(Player p, UUID uuid, int page) {
        ItemStackBuilder builder = new ItemStackBuilder(Material.BARRIER);
        builder.withName(dsp.get("friend_menu.head_menu.remove", p));
        builder.withLore(dsp.get("friend_menu.head_menu.remove.lore", p, UUIDFetcher.getName(uuid)));
        return new MenuItem(builder.buildStack()) {
            @Override
            public void onClick(Player player) {
                Friend.deleteFriend(UUIDFetcher.getUUID(p.getName()), uuid);
                FriendMenu.openFriendMenu(p, page);
            }
        };
    }

    public static MenuItem noFriendsItem(Player p) {
        ItemStackBuilder builder = new ItemStackBuilder(Material.BARRIER);
        builder.withName(dsp.get("friend_menu.noFriends", p));
        return new MenuItem(builder.buildStack()) {
            @Override
            public void onClick(Player player) {
            }
        };
    }


    public static MenuItem requestItem(Player p, int amount, int page) {
        ItemStackBuilder builder = new ItemStackBuilder(Material.BOOK);
        builder.withName(dsp.get("friend_menu.requests", p, amount + ""));
        builder.withLore(dsp.get("friend_menu.requests.lore0", p), dsp.get("friend_menu.requests.lore1", p));
        return new MenuItem(builder.buildStack()) {
            @Override
            public void onClick(Player player) {
                RequestMenu.openRequestMenu(p, 0, page);
            }
        };
    }

    public static MenuItem noFriendRequestItem(Player p) {
        ItemStackBuilder builder = new ItemStackBuilder(Material.BARRIER);
        builder.withName(dsp.get("friend_menu.requests.noRequests", p));
        return new MenuItem(builder.buildStack()) {
            @Override
            public void onClick(Player player) {
            }
        };
    }

    public static MenuItem acceptAllItem(Player p, ArrayList<UUID> requests) {
        ItemStackBuilder builder = new ItemStackBuilder(Material.GREEN_CONCRETE);
        builder.withName(dsp.get("friend_menu.requests.acceptAll", p));
        builder.withLore(dsp.get("friend_menu.requests.acceptAll.lore", p));
        return new MenuItem(builder.buildStack()) {
            @Override
            public void onClick(Player player) {
                requests.forEach(r -> Friend.accept(UUIDFetcher.getUUID(player.getName()), r));
            }
        };
    }

    public static MenuItem denyAllItem(Player p, ArrayList<UUID> requests) {
        ItemStackBuilder builder = new ItemStackBuilder(Material.RED_CONCRETE);
        builder.withName(dsp.get("friend_menu.requests.denyAll", p));
        builder.withLore(dsp.get("friend_menu.requests.denyAll.lore", p));
        return new MenuItem(builder.buildStack()) {
            @Override
            public void onClick(Player player) {
                requests.forEach(r -> Friend.deleteFriend(UUIDFetcher.getUUID(player.getName()), r));
            }
        };
    }

    public static MenuItem acceptRequestItem(Player p, UUID uuid, int friendPage) {
        ItemStackBuilder builder = new ItemStackBuilder(Material.GREEN_CONCRETE);
        builder.withName(dsp.get("friend_menu.requesthead_menu.accept", p));
        return new MenuItem(builder.buildStack()) {
            @Override
            public void onClick(Player player) {
                Friend.accept(UUIDFetcher.getUUID(p.getName()), uuid);
                RequestMenu.openRequestMenu(p, 0, friendPage);
            }
        };
    }

    public static MenuItem denyRequestItem(Player p, UUID uuid, int friendPage) {
        ItemStackBuilder builder = new ItemStackBuilder(Material.RED_CONCRETE);
        builder.withName(dsp.get("friend_menu.requesthead_menu.deny", p));
        return new MenuItem(builder.buildStack()) {
            @Override
            public void onClick(Player player) {
                Friend.deleteFriend(UUIDFetcher.getUUID(p.getName()), uuid);
                RequestMenu.openRequestMenu(p, 0, friendPage);
            }
        };
    }


    public static MenuItem sortItem(Player p, int page) {
        ItemStackBuilder builder = new ItemStackBuilder(Material.COMPARATOR);

        int option = UserSettings.getInt(UUIDFetcher.getUUID(p.getName()), "friend_sort");

        builder.withName(dsp.get("friend_menu.sort", p, dsp.get("friend_menu.sort.option" + option, p)));
        builder.withLore(dsp.get("friend_menu.sort.lore1", p), dsp.get("friend_menu.sort.lore2", p));
        return new MenuItem(builder.buildStack()) {
            @Override
            public void onClick(Player player) {
                FriendSortMenu.openFriendSortMenu(player, page);
            }
        };
    }

    public static MenuItem previousFriendPageItem(Player p, int page, int maxPage) {
        return new MenuItem(ProfileItems.previousPage(p, page, maxPage)) {
            @Override
            public void onClick(Player player) {
                FriendMenu.openFriendMenu(player, page - 1);
            }
        };
    }

    public static MenuItem nextFriendPageItem(Player p, int page, int maxPage) {
        return new MenuItem(ProfileItems.previousPage(p, page, maxPage)) {
            @Override
            public void onClick(Player player) {
                FriendMenu.openFriendMenu(player, page + 1);
            }
        };
    }

    public static MenuItem previousRequestPageItem(Player p, int page, int maxPage, int friendPage) {
        return new MenuItem(ProfileItems.previousPage(p, page, maxPage)) {
            @Override
            public void onClick(Player player) {
                RequestMenu.openRequestMenu(player, page - 1, friendPage);
            }
        };
    }

    public static MenuItem nextRequestPageItem(Player p, int page, int maxPage, int friendPage) {
        return new MenuItem(ProfileItems.previousPage(p, page, maxPage)) {
            @Override
            public void onClick(Player player) {
                RequestMenu.openRequestMenu(player, page + 1, friendPage);
            }
        };
    }

    public static MenuItem alphabetASortItem(Player p) {
        ItemStackBuilder builder = ItemStackBuilder.fromItemStack(heads.get("sort_A"));

        int option = 0;
        builder.withName(dsp.get("friend_menu.sort.option" + option, p));
        builder.withLore(dsp.get("friend_menu.sort.option" + option + ".lore0", p), dsp.get("friend_menu.sort.option" + option + ".lore1", p));
        return new MenuItem(builder.buildStack()) {
            @Override
            public void onClick(Player player) {
            }
        };
    }

    public static MenuItem alphabetZSortItem(Player p) {
        ItemStackBuilder builder = ItemStackBuilder.fromItemStack(heads.get("sort_Z"));

        int option = 1;
        builder.withName(dsp.get("friend_menu.sort.option" + option, p));
        builder.withLore(dsp.get("friend_menu.sort.option" + option + ".lore0", p), dsp.get("friend_menu.sort.option" + option + ".lore1", p));
        return new MenuItem(builder.buildStack()) {
            @Override
            public void onClick(Player player) {
            }
        };
    }

    public static MenuItem favoriteSortItem(Player p) {
        ItemStackBuilder builder = ItemStackBuilder.fromItemStack(heads.get("friend_favorite"));

        int option = 2;
        builder.withName(dsp.get("friend_menu.sort.option" + option, p));
        builder.withLore(dsp.get("friend_menu.sort.option" + option + ".lore0", p), dsp.get("friend_menu.sort.option" + option + ".lore1", p));
        return new MenuItem(builder.buildStack()) {
            @Override
            public void onClick(Player player) {
            }
        };
    }

    public static MenuItem onlineSortItem(Player p) {
        ItemStackBuilder builder = ItemStackBuilder.fromItemStack(heads.get("sort_Online"));

        int option = 3;
        builder.withName(dsp.get("friend_menu.sort.option" + option, p));
        builder.withLore(dsp.get("friend_menu.sort.option" + option + ".lore0", p), dsp.get("friend_menu.sort.option" + option + ".lore1", p));
        return new MenuItem(builder.buildStack()) {
            @Override
            public void onClick(Player player) {
            }
        };
    }

    public static MenuItem offlineSortItem(Player p) {
        ItemStackBuilder builder = ItemStackBuilder.fromItemStack(heads.get("sort_Offline"));

        int option = 4;
        builder.withName(dsp.get("friend_menu.sort.option" + option, p));
        builder.withLore(dsp.get("friend_menu.sort.option" + option + ".lore0", p), dsp.get("friend_menu.sort.option" + option + ".lore1", p));
        return new MenuItem(builder.buildStack()) {
            @Override
            public void onClick(Player player) {
            }
        };
    }

    public static MenuItem ageDescSortItem(Player p) {
        ItemStackBuilder builder = ItemStackBuilder.fromItemStack(heads.get("sort_AgeDesc"));

        int option = 5;
        builder.withName(dsp.get("friend_menu.sort.option" + option, p));
        builder.withLore(dsp.get("friend_menu.sort.option" + option + ".lore0", p), dsp.get("friend_menu.sort.option" + option + ".lore1", p));
        return new MenuItem(builder.buildStack()) {
            @Override
            public void onClick(Player player) {
            }
        };
    }

    public static MenuItem ageAscSortItem(Player p) {
        ItemStackBuilder builder = ItemStackBuilder.fromItemStack(heads.get("sort_AgeAsc"));

        int option = 6;
        builder.withName(dsp.get("friend_menu.sort.option" + option, p));
        builder.withLore(dsp.get("friend_menu.sort.option" + option + ".lore0", p), dsp.get("friend_menu.sort.option" + option + ".lore1", p));
        return new MenuItem(builder.buildStack()) {
            @Override
            public void onClick(Player player) {
            }
        };
    }

    public static MenuItem onlineTimeDescSortItem(Player p) {
        ItemStackBuilder builder = ItemStackBuilder.fromItemStack(heads.get("sort_OnlineTimeDesc"));

        int option = 7;
        builder.withName(dsp.get("friend_menu.sort.option" + option, p));
        builder.withLore(dsp.get("friend_menu.sort.option" + option + ".lore0", p), dsp.get("friend_menu.sort.option" + option + ".lore1", p));
        return new MenuItem(builder.buildStack()) {
            @Override
            public void onClick(Player player) {
            }
        };
    }

    public static MenuItem onlineTimeAscItem(Player p) {
        ItemStackBuilder builder = ItemStackBuilder.fromItemStack(heads.get("sort_OnlineTimeAsc"));

        int option = 8;
        builder.withName(dsp.get("friend_menu.sort.option" + option, p));
        builder.withLore(dsp.get("friend_menu.sort.option" + option + ".lore0", p), dsp.get("friend_menu.sort.option" + option + ".lore1", p));
        return new MenuItem(builder.buildStack()) {
            @Override
            public void onClick(Player player) {
            }
        };
    }

    public static MenuItem toggleItem(Player p, int option, int page) {
        boolean toggled = option == UserSettings.getInt(UUIDFetcher.getUUID(p.getName()), "friend_sort");
        return new MenuItem(ProfileItems.toggleItem(p, toggled)) {
            @Override
            public void onClick(Player player) {
                if (!toggled) {
                    UserSettings.setInt(UUIDFetcher.getUUID(p.getName()), "friend_sort", option);
                    FriendSortMenu.openFriendSortMenu(p, page);
                }
            }
        };
    }

    public static String getLastSeen(Player p, UUID uuid) {
        String s = "";
        long seconds = (System.currentTimeMillis() - User.getLastTime(uuid)) / 1000;
        if (seconds / 60.0 > 1) {
            if ((seconds / (60.0 * 60.0)) > 1) {
                if (seconds / (60.0 * 60.0 * 24) > 1) {
                    if (seconds / (60.0 * 60.0 * 24 * 7) > 1) {
                        if (seconds / (60.0 * 60.0 * 24 * 30) > 1) {
                            if (seconds / (60.0 * 60.0 * 24 * 365) > 1) {
                                return (int) (seconds / (60.0 * 60.0 * 24 * 365)) + " " + dsp.get("unit.years", p);
                            }
                            return (int) (seconds / (60.0 * 60.0 * 24 * 30)) + " " + dsp.get("unit.months", p);
                        }
                        return (int) (seconds / (60.0 * 60.0 * 24 * 7)) + " " + dsp.get("unit.weeks", p);
                    }
                    return (int) (seconds / (60.0 * 60.0 * 24)) + " " + dsp.get("unit.days", p);
                }
                return (int) (seconds / (60.0 * 60.0)) + " " + dsp.get("unit.hours", p);
            }
            return (int) (seconds / 60.0) + " " + dsp.get("unit.minutes", p);
        }
        return seconds + " " + dsp.get("unit.seconds", p);
    }

}
