package de.MangoleHD.IMLobby.Listener.PopupMenus;

import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import de.Iclipse.IMAPI.Util.menu.PopupMenuAPI;
import org.bukkit.entity.Player;

public class FriendMenu {

    public static void openFriendMenu(Player p, PopupMenu old) {
        //Menu
        PopupMenu FriendMenu = new PopupMenu("§rFriends", 6);
        //Menuitems
        //Menu with items
        //open Menu
        PopupMenuAPI.switchMenu(p, old, FriendMenu);
    }
}
