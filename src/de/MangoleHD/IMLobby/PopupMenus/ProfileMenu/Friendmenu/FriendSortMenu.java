package de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.Friendmenu;

import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.ProfileMenu;
import org.bukkit.entity.Player;

import static de.MangoleHD.IMLobby.Data.dsp;

public class FriendSortMenu {
    public static void openFriendSortMenu(Player p, PopupMenu last) {
        PopupMenu menu = ProfileMenu.createSubProfileMenu(dsp.get("friend_menu.sort.title", p), last, p, 2);
        menu.addMenuItem(FriendItems.alphabetASortItem(p), 0, 2);
        menu.addMenuItem(FriendItems.alphabetZSortItem(p), 1, 2);
        menu.addMenuItem(FriendItems.favoriteSortItem(p), 2, 2);
        menu.addMenuItem(FriendItems.onlineSortItem(p), 3, 2);
        menu.addMenuItem(FriendItems.offlineSortItem(p), 4, 2);
        menu.addMenuItem(FriendItems.ageDescSortItem(p), 5, 2);
        menu.addMenuItem(FriendItems.ageAscSortItem(p), 6, 2);
        menu.addMenuItem(FriendItems.onlineTimeDescSortItem(p), 7, 2);
        menu.addMenuItem(FriendItems.onlineTimeAscItem(p), 8, 2);
        for (int i = 0; i < 9; i++) {
            menu.addMenuItem(FriendItems.toggleItem(p, i, last), i, 3);
        }
        menu.openMenu(p);
    }
}
