package de.MangoleHD.IMLobby.Listener.PopupMenus;

import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import de.Iclipse.IMAPI.Util.menu.PopupMenuAPI;
import org.bukkit.entity.Player;

import static de.MangoleHD.IMLobby.Data.dsp;

public class FriendheadMenu {

    public static void openFriendheadMenu(Player p, String friendname, PopupMenu old){
        //Menu
        PopupMenu FriendheadMenu = new PopupMenu(friendname,1);
        //Menuitems
        //Menu with items
        PopupMenuAPI.switchMenu(p,old,FriendheadMenu);
    }
}
