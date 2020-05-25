package de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.Friendmenu;

import de.Iclipse.IMAPI.IMAPI;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.ProfileMenu;
import net.alpenblock.bungeeperms.BungeePermsAPI;
import org.bukkit.entity.Player;

import java.util.UUID;

import static de.MangoleHD.IMLobby.Data.dsp;

public class RequestheadMenu {
    public static void openRequestheadMenu(Player p, UUID request, PopupMenu last) {
        PopupMenu menu = ProfileMenu.createSubProfileMenu(dsp.get("friend_menu.requesthead_menu.title", p, BungeePermsAPI.userPrefix(request.toString(), IMAPI.getServerName(), null) + UUIDFetcher.getName(request)), last, p, 3);
        menu.addMenuItem(FriendItems.acceptRequestItem(p, request, last), 2, 2);
        menu.addMenuItem(FriendItems.denyRequestItem(p, request, last), 6, 2);
        menu.openMenu(p);
    }
}
