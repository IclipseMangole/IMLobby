package de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.Settings.Status;

import de.Iclipse.IMAPI.Database.UserSettings;
import de.Iclipse.IMAPI.Util.Anvil.AnvilGUI;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import de.MangoleHD.IMLobby.Data;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.BackAction;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.ProfileMenu;
import de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.Settings.SettingsMenu;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

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

        menu.addMenuItem(StatusItems.statusLineItem(p, 1), 2, 2);
        menu.addMenuItem(StatusItems.statusLineItem(p, 2), 6, 2);

        menu.addMenuItem(StatusItems.resetLineItem(p, 1), 2, 3);
        menu.addMenuItem(StatusItems.resetLineItem(p, 2), 6, 3);
        menu.openMenu(p);
    }


    public static void openChangeMenu(Player p, int line) {
        /*
        Inventory inventory = Bukkit.createInventory(p, InventoryType.ANVIL, dsp.get("status.change.title", p, line + ""));
        inventory.setItem(0, StatusItems.changeLineItem(p, line));
        p.openInventory(inventory);
        editingLines.put(p, line);
         */
        AnvilGUI.Builder builder = new AnvilGUI.Builder();
        builder.title(dsp.get("status.change.title", p, line + ""));
        builder.item(StatusItems.changeLineItem(p, line));
        builder.plugin(Data.instance);
        builder.onComplete((player, s) -> {
            UserSettings.setString(UUIDFetcher.getUUID(p.getName()), "status_line" + editingLines.get(p), s);
            openStatusMenu(p);
            return AnvilGUI.Response.close();
        });
        builder.onClose(player -> {
            editingLines.remove(player);
        });

        String status = StatusItems.getStatus(p, line) == "" ? "Status" : StatusItems.getStatus(p, line);
        builder.text(status);
        editingLines.put(p, line);
        builder.open(p);
    }

}
