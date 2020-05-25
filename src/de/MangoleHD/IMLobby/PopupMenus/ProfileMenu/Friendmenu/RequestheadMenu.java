package de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.Friendmenu;

import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.BackAction;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.ProfileMenu;
import org.bukkit.entity.Player;

import java.util.UUID;

import static de.MangoleHD.IMLobby.Data.dsp;

public class RequestheadMenu {
    public static void openRequestheadMenu(Player p, UUID request, int friendPage) {
        PopupMenu menu = ProfileMenu.createSubProfileMenu(dsp.get("friend_menu.requesthead_menu.title", p, de.Iclipse.IMAPI.Data.tablist.getPrefix(request) + UUIDFetcher.getName(request)), p, 3, new BackAction() {
            @Override
            public void onBack(Player player) {
                RequestMenu.openRequestMenu(p, 0, friendPage);
            }
        });
        menu.addMenuItem(FriendItems.acceptRequestItem(p, request, friendPage), 2, 2);
        menu.addMenuItem(FriendItems.denyRequestItem(p, request, friendPage), 6, 2);
        menu.openMenu(p);
    }
}
