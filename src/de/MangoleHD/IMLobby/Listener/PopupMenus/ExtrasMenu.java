package de.MangoleHD.IMLobby.Listener.PopupMenus;

import de.Iclipse.IMAPI.Util.menu.MenuItem;
import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import de.Iclipse.IMAPI.Util.menu.PopupMenuAPI;
import de.MangoleHD.IMLobby.StaticClasses.getExtras;
import net.minecraft.server.v1_15_R1.Items;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ExtrasMenu {

    public static void openExtrasMenu(Player p, PopupMenu old){
        //Menu
        PopupMenu extramenu = new PopupMenu("Settings",1);
        //Items
        MenuItem rocket = new MenuItem("Rocket", new ItemStack(Material.FIREWORK_ROCKET)) {
            @Override
            public void onClick(Player player) {
                getExtras.getRocket(player);
                extramenu.closeMenu(player);
            }
        };

        MenuItem chickenbomb = new MenuItem("ChickenBomb", new ItemStack(Material.EGG)) {
            @Override
            public void onClick(Player player) {
                getExtras.getChickenBomb(player);
                extramenu.closeMenu(player);
            }
        };

        //Menu with Items
        extramenu.addMenuItem(rocket,0);
        extramenu.addMenuItem(chickenbomb,1);

        PopupMenuAPI.switchMenu(p,old,extramenu);
    }
}
