package de.MangoleHD.IMLobby.Listener.PopupMenus;

import de.Iclipse.IMAPI.Util.menu.MenuItem;
import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import de.MangoleHD.IMLobby.Data;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SettingsMenu {

    public static void openSettingsMenu(Player p) {
        //Menu
        PopupMenu settMenu = new PopupMenu(Data.dsp.get("settings.menu", p), 5);
        //MenuItems
        MenuItem particles = new MenuItem(Data.dsp.get("settings.particles", p), new ItemStack(Material.EMERALD)) {
            @Override
            public void onClick(Player player) {
                ParticleMenu.openParticleMenu(player, settMenu);
            }
        };
        particles.setLore(Data.dsp.get("settings.particles.lore", p));

        MenuItem clothing = new MenuItem(Data.dsp.get("settings.clothing", p), new ItemStack(Material.LEATHER_CHESTPLATE)) {
            @Override
            public void onClick(Player player) {
                ClothingMenu.openClothingMenu(player, settMenu);
            }
        };
        clothing.setLore(Data.dsp.get("settings.clothing.lore", p));

        MenuItem extras = new MenuItem(Data.dsp.get("settings.extras", p), new ItemStack(Material.SNOWBALL)) {
            @Override
            public void onClick(Player player) {
                ExtrasMenu.openExtrasMenu(player, settMenu);
            }
        };
        extras.setLore(Data.dsp.get("settings.extras.lore", p));

        MenuItem friends = new MenuItem(Data.dsp.get("settings.friends", p), new ItemStack(Material.PLAYER_HEAD)) {
            @Override
            public void onClick(Player player) {
                FriendMenu.openFriendMenu(player, settMenu);
            }
        };
        friends.setLore(Data.dsp.get("settings.friends.lore", p));

        //Menu with Items
        settMenu.addMenuItem(particles, 2, 2);
        settMenu.addMenuItem(clothing, 6, 2);
        settMenu.addMenuItem(extras, 4, 1);
        settMenu.addMenuItem(friends, 4, 3);

        settMenu.openMenu(p);
    }
}
