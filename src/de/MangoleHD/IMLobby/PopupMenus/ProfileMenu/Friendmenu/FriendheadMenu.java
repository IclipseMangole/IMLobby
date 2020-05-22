package de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.Friendmenu;

import de.Iclipse.IMAPI.Database.Friend;
import de.Iclipse.IMAPI.Database.User;
import de.Iclipse.IMAPI.IMAPI;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.ProfileMenu;
import net.alpenblock.bungeeperms.BungeePermsAPI;
import org.bukkit.entity.Player;

import java.util.UUID;

import static de.MangoleHD.IMLobby.Data.dsp;

public class FriendheadMenu {

    public static void openFriendheadMenu(Player p, UUID uuid, PopupMenu old) {
        PopupMenu menu = ProfileMenu.createSubProfileMenu(dsp.get("friend_menu.head_menu.title", p, BungeePermsAPI.userPrefix(uuid.toString(), IMAPI.getServerName(), null)), old, p, 3);
        int favoriteStack;
        if (User.isOnline(uuid)) {
            menu.addMenuItem(FriendItems.onlineHead(p, uuid, menu), 1, 2);
            favoriteStack = 3;
            menu.addMenuItem(FriendItems.jumpItem(p, uuid), 5, 2);
        } else {
            menu.addMenuItem(FriendItems.offlineHead(p, uuid, menu), 1, 2);
            favoriteStack = 4;
        }

        if (Friend.isFavorite(UUIDFetcher.getUUID(p.getName()), uuid)) {
            menu.addMenuItem(FriendItems.removeFavoriteItem(p, uuid), favoriteStack, 2);
        } else {
            menu.addMenuItem(FriendItems.addFavoriteItem(p, uuid), favoriteStack, 2);
        }


        menu.addMenuItem(FriendItems.removeFriendItem(p, uuid, old), 7, 2);
        menu.openMenu(p);
    }

}
