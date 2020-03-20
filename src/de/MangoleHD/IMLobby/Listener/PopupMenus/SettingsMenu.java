package de.MangoleHD.IMLobby.Listener.PopupMenus;

import de.Iclipse.IMAPI.Util.menu.MenuItem;
import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SettingsMenu {

    public static void openSettingsMenu(Player p) {
        //Menu
        PopupMenu settMenu = new PopupMenu("Settings",5);
        //MenuItems
        MenuItem particles = new MenuItem("Particles", new ItemStack(Material.EMERALD)) {
            @Override
            public void onClick(Player player) {
                ParticleMenu.openParticleMenu(player, settMenu);
            }
        };

        MenuItem clothing = new MenuItem("Clothing", new ItemStack(Material.LEATHER_CHESTPLATE)) {
            @Override
            public void onClick(Player player) {
                ClothingMenu.openClothingMenu(player, settMenu);
            }
        };

        MenuItem extras = new MenuItem("Extras", new ItemStack(Material.SNOWBALL)) {
            @Override
            public void onClick(Player player) {
                ExtrasMenu.openExtrasMenu(player, settMenu);
            }
        };

        //Menu with Items
        settMenu.addMenuItem(particles,2,2);
        settMenu.addMenuItem(clothing,6,2);
        settMenu.addMenuItem(extras,4,1);

        settMenu.openMenu(p);
    }
}
