package de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.Settings.Status;

import de.Iclipse.IMAPI.Database.UserSettings;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.BackAction;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.ProfileMenu;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.Settings.SettingsMenu;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;

import static de.MangoleHD.IMLobby.Data.dsp;

public class StatusMenu implements Listener {
    private static HashMap<Player, Integer> editingLines = new HashMap<>();

    public static void openStatusMenu(Player p) {
        PopupMenu menu = ProfileMenu.createSubProfileMenu(dsp.get("status.name", p), p, 2, new BackAction() {
            @Override
            public void onBack(Player player) {
                SettingsMenu.openSettingsMenu(p);
            }
        });

        menu.addMenuItem(StatusItems.statusLineItem(p, 0), 2, 2);
        menu.addMenuItem(StatusItems.statusLineItem(p, 1), 6, 2);

        menu.addMenuItem(StatusItems.resetLineItem(p, 0), 2, 3);
        menu.addMenuItem(StatusItems.resetLineItem(p, 1), 6, 3);
        menu.openMenu(p);
    }


    public static void openChangeMenu(Player p, int line) {
        Inventory inventory = Bukkit.createInventory(p, InventoryType.ANVIL, dsp.get("status.change.title", p, line + ""));
        inventory.setItem(0, StatusItems.changeLineItem(p, line));
        p.openInventory(inventory);
        editingLines.put(p, line);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Inventory inv = e.getInventory();
        if (inv instanceof AnvilInventory) {

            if (e.getSlot() == 2) {
                Player p = (Player) e.getWhoClicked();
                if (editingLines.containsKey(p)) {
                    UserSettings.setString(UUIDFetcher.getUUID(p.getName()), "status_line" + editingLines.get(p), ((AnvilInventory) inv).getRenameText());
                    openStatusMenu(p);
                    editingLines.remove(p);
                }
            }
        }
    }

    @EventHandler
    public void onClose(InventoryCloseEvent e) {
        if (editingLines.containsKey(e.getPlayer())) {
            editingLines.remove(e.getPlayer());
        }
    }
}
