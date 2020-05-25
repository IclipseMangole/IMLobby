package de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.LobbyInventory;


import de.Iclipse.IMAPI.Data;
import de.Iclipse.IMAPI.Util.menu.MenuItem;
import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.BackAction;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.ProfileMenu;
import de.MangoleHD.IMLobby.StaticClasses.getExtras;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public class ExtrasMenu {

    public static void openExtrasMenu(Player p, PopupMenu old) {
        //Menu
        PopupMenu extramenu = ProfileMenu.createSubProfileMenu("Extras", p, 3, new BackAction() {
            @Override
            public void onBack(Player player) {
                InventoryMenu.openInventoryMenu(p);
            }
        });
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
        extramenu.addMenuItem(rocket, 18);
        extramenu.addMenuItem(chickenbomb, 19);

        extramenu.openMenu(p);
    }
}
