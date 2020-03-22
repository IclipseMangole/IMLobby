package de.MangoleHD.IMLobby.Listener.PopupMenus;

import de.Iclipse.IMAPI.Data;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.Iclipse.IMAPI.Util.menu.MenuItem;
import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.awt.*;
import java.util.UUID;

import static de.Iclipse.IMAPI.Functions.MySQL.MySQL_User.getLanguage;

public class SettingsMenu {

    public static void openSettingsMenu(Player p) {
        UUID uuid = UUIDFetcher.getUUID(p.getName());
        //Menu
        PopupMenu settMenu = new PopupMenu(Data.dsp.get("settings.menu",getLanguage(uuid)),5);
        //MenuItems
        MenuItem particles = new MenuItem(Data.dsp.get("settings.particles",getLanguage(uuid)), new ItemStack(Material.EMERALD)) {
            @Override
            public void onClick(Player player) {
                ParticleMenu.openParticleMenu(player, settMenu);
            }
        };
        particles.setLore(Data.dsp.get("settings.particles.lore",getLanguage(uuid)));

        MenuItem clothing = new MenuItem(Data.dsp.get("settings.clothing",getLanguage(uuid)), new ItemStack(Material.LEATHER_CHESTPLATE)) {
            @Override
            public void onClick(Player player) {
                ClothingMenu.openClothingMenu(player, settMenu);
            }
        };
        clothing.setLore(Data.dsp.get("settings.clothing.lore",getLanguage(uuid)));

        MenuItem extras = new MenuItem(Data.dsp.get("settings.extras",getLanguage(uuid)), new ItemStack(Material.SNOWBALL)) {
            @Override
            public void onClick(Player player) {
                ExtrasMenu.openExtrasMenu(player, settMenu);
            }
        };
        extras.setLore(Data.dsp.get("settings.extras.lore",getLanguage(uuid)));

        MenuItem friends = new MenuItem(Data.dsp.get("settings.friends",getLanguage(uuid)), new ItemStack(Material.PLAYER_HEAD)) {
            @Override
            public void onClick(Player player) {
                FriendMenu.openFriendMenu(player, settMenu);
            }
        };
        friends.setLore(Data.dsp.get("settings.friends.lore",getLanguage(uuid)));

        //Menu with Items
        settMenu.addMenuItem(particles,2,2);
        settMenu.addMenuItem(clothing,6,2);
        settMenu.addMenuItem(extras,4,1);
        settMenu.addMenuItem(friends,4,3);

        settMenu.openMenu(p);
    }
}
