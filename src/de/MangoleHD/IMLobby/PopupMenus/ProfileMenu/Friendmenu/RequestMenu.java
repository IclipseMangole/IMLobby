package de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.Friendmenu;

import de.Iclipse.IMAPI.Database.Friend;
import de.Iclipse.IMAPI.IMAPI;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.ProfileMenu;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

import static de.MangoleHD.IMLobby.Data.dsp;

public class RequestMenu {

    public static void openRequestMenu(Player p, PopupMenu last, int page) {
        ArrayList<UUID> requests = Friend.getRequests(UUIDFetcher.getUUID(p.getName()));
        PopupMenu menu = ProfileMenu.createSubProfileMenu(dsp.get("friend_menu.requests", p, requests.size() + ""), last, p, 3);
        if (requests.size() == 0) {
            menu.addMenuItem(FriendItems.noFriendRequestItem(p), 4, 2);
        } else {
            ArrayList<UUID> shown = IMAPI.getPage(requests, 27, page);
            for (int i = 0; i < shown.size(); i++) {
                UUID request = shown.get(i);
                menu.addMenuItem(FriendItems.requestHead(p, request, menu), 9 + i);
            }
            menu.addMenuItem(FriendItems.acceptAllItem(p, requests), 5, 5);
            menu.addMenuItem(FriendItems.denyAllItem(p, requests), 6, 5);
            if (IMAPI.hasPage(requests, 27, page - 1)) {
                menu.addMenuItem(FriendItems.nextRequestPageItem(p, last, page, (requests.size() / 27)), 7, 5);
            }
            if (IMAPI.hasPage(requests, 27, page + 1)) {
                menu.addMenuItem(FriendItems.previousRequestPageItem(p, last, page, (requests.size() / 27)), 8, 5);
            }
        }
        menu.openMenu(p);
    }
}
