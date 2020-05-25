package de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.Friendmenu;

import de.Iclipse.IMAPI.Database.Friend;
import de.Iclipse.IMAPI.Database.User;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.BackAction;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.ProfileMenu;
import org.bukkit.entity.Player;

import java.util.UUID;

import static de.MangoleHD.IMLobby.Data.dsp;

public class FriendheadMenu {

    public static void openFriendheadMenu(Player p, UUID uuid, int page) {
        PopupMenu menu = ProfileMenu.createSubProfileMenu(dsp.get("friend_menu.head_menu.title", p, de.Iclipse.IMAPI.Data.tablist.getPrefix(uuid) + UUIDFetcher.getName(uuid)), p, 3, new BackAction() {
            @Override
            public void onBack(Player player) {
                FriendMenu.openFriendMenu(p, page);
            }
        });
        int favoriteStack;
        if (User.isOnline(uuid)) {
            menu.addMenuItem(FriendItems.onlineHead(p, uuid, page), 1, 2);
            favoriteStack = 3;
            menu.addMenuItem(FriendItems.jumpItem(p, uuid), 5, 2);
        } else {
            menu.addMenuItem(FriendItems.offlineHead(p, uuid, page), 1, 2);
            favoriteStack = 4;
        }

        BackAction headOpen = new BackAction() {
            @Override
            public void onBack(Player player) {
                openFriendheadMenu(p, uuid, page);
            }
        };

        if (Friend.isFavorite(UUIDFetcher.getUUID(p.getName()), uuid)) {
            menu.addMenuItem(FriendItems.removeFavoriteItem(p, uuid, headOpen), favoriteStack, 2);
        } else {
            menu.addMenuItem(FriendItems.addFavoriteItem(p, uuid, headOpen), favoriteStack, 2);
        }


        menu.addMenuItem(FriendItems.removeFriendItem(p, uuid, page), 7, 2);
        menu.openMenu(p);
    }

}
