package de.MangoleHD.IMLobby.Listener.PopupMenus;

import de.Iclipse.IMAPI.Database.Friend;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.Iclipse.IMAPI.Util.menu.MenuItem;
import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import de.Iclipse.IMAPI.Util.menu.PopupMenuAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.UUID;

import static de.MangoleHD.IMLobby.Data.dsp;
import static de.MangoleHD.IMLobby.Listener.PopupMenus.FriendheadMenu.openFriendheadMenu;

public class FriendMenu {

    public static void openFriendMenu(Player p, PopupMenu old) {
        String name = p.getName();
        UUID uuid = UUIDFetcher.getUUID(name);
        ArrayList<String> all = Friend.getFriendnames(uuid);
        ArrayList<String> online = new ArrayList<>();
        ArrayList<String> offline = new ArrayList<>();
        ArrayList<String> pending = new ArrayList<>();

        all.forEach(friendname -> {
            Player player = Bukkit.getPlayer(friendname);
            if (Friend.isFriendshipActive(name, friendname)) {
                if (Bukkit.getOnlinePlayers().contains(player)) {
                    online.add(friendname);
                } else {
                    offline.add(friendname);
                }
            } else {
                pending.add(friendname);
            }
        });

        //Menu
        PopupMenu FriendMenu = new PopupMenu(dsp.get("friend.menu",p), 6);
        //Menuitems
            for(int i = 0; i<online.size(); i++) {
                ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
                SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
                skullMeta.setDisplayName(online.get(i));
                skullMeta.setOwner(online.get(i));
                skull.setItemMeta(skullMeta);
                int finalI = i;
                MenuItem friendhead = new MenuItem(online.get(finalI), skull) {
                    @Override
                    public void onClick(Player player) {
                        openFriendheadMenu(player, online.get(finalI), FriendMenu);
                    }
                };
                //Menu with items
                if(i<45) {
                    FriendMenu.addMenuItem(friendhead, i);
                }
            }
        //Menu with items
        //open Menu
        PopupMenuAPI.switchMenu(p, old, FriendMenu);
    }
}
