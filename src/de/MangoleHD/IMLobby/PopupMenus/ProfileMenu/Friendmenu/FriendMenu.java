package de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.Friendmenu;


import de.Iclipse.IMAPI.Database.Friend;
import de.Iclipse.IMAPI.Database.User;
import de.Iclipse.IMAPI.Database.UserSettings;
import de.Iclipse.IMAPI.IMAPI;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.ProfileMenu;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

import static de.MangoleHD.IMLobby.Data.dsp;


public class FriendMenu {

    public static void openFriendMenu(Player p, int page) {
        PopupMenu menu = ProfileMenu.createProfileMenu(dsp.get("profile.friend_menu", p), p);
        ArrayList<UUID> friends = Friend.getFriendsSorted(UUIDFetcher.getUUID(p.getName()), UserSettings.getInt(UUIDFetcher.getUUID(p.getName()), "friend_sort"));

        ArrayList<UUID> shown = IMAPI.getPage(friends, 36, page);
        if (friends.size() > 0) {
            for (int i = 0; i < shown.size(); i++) {
                UUID friend = shown.get(i);
                if (User.isOnline(friend)) {
                    menu.addMenuItem(FriendItems.onlineHead(p, friend, menu), i);
                } else {
                    menu.addMenuItem(FriendItems.offlineHead(p, friend, menu), i);
                }
            }
        } else {
            menu.addMenuItem(FriendItems.noFriendsItem(p), 4, 2);
        }
        menu.addMenuItem(FriendItems.requestItem(p, Friend.getRequests(UUIDFetcher.getUUID(p.getName())).size(), menu), 5, 5);
        menu.addMenuItem(FriendItems.sortItem(p, menu), 6, 5);
        if (IMAPI.hasPage(friends, 36, page - 1)) {
            menu.addMenuItem(FriendItems.previousFriendPageItem(p, page, IMAPI.maxPage(friends, 36)), 7, 5);
        }
        if (IMAPI.hasPage(friends, 36, page + 1)) {
            menu.addMenuItem(FriendItems.nextFriendPageItem(p, page, IMAPI.maxPage(friends, 36)), 8, 5);
        }
        menu.openMenu(p);
    }
}
