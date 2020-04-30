package de.MangoleHD.IMLobby.Listener.PopupMenus;


import de.Iclipse.IMAPI.Data;
import de.Iclipse.IMAPI.Util.menu.MenuItem;
import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import de.Iclipse.IMAPI.Util.menu.PopupMenuAPI;
import de.MangoleHD.IMLobby.StaticClasses.getExtras;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public class ExtrasMenu {

    public static void openExtrasMenu(Player p, PopupMenu old) {
        //Menu
        PopupMenu extramenu = new PopupMenu("Settings", 1);
        //Items
        MenuItem rocket = new MenuItem(Data.dsp.get("extras.rocket", p), new ItemStack(Material.FIREWORK_ROCKET)) {
            @Override
            public void onClick(Player player) {
                getExtras.getRocket(player);
                extramenu.closeMenu(player);
            }
        };
        rocket.setLore(Data.dsp.get("extras.rocket.lore", p));

        MenuItem chickenbomb = new MenuItem(Data.dsp.get("extras.chickenbomb", p), new ItemStack(Material.EGG)) {
            @Override
            public void onClick(Player player) {
                getExtras.getChickenBomb(player);
                extramenu.closeMenu(player);
            }
        };
        chickenbomb.setLore(Data.dsp.get("extras.chickenbomb.lore", p));

        //Menu with Items
        extramenu.addMenuItem(rocket, 0);
        extramenu.addMenuItem(chickenbomb, 1);

        PopupMenuAPI.switchMenu(p, old, extramenu);
    }
}
