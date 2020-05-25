package de.MangoleHD.IMLobby.StartInventory;

import de.Iclipse.IMAPI.Util.Command.IMCommand;
import de.MangoleHD.IMLobby.StaticClasses.getVisibility;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class StartInventoryCMD {
    @IMCommand(
            name = "startInventory",
            noConsole = true,
            minArgs = 0,
            maxArgs = 0,
            permissions = "im.cmd.startinventory"

    )
    public void execute(Player p) {
        Inventory i = p.getInventory();
        i.clear();
        //Items


        //Inventory
        i.setItem(0, StartInventoryItems.getCompass(p));
        i.setItem(1, StartInventoryItems.getPearl(p));
        i.setItem(2, StartInventoryItems.getVisibility(p));
        i.setItem(8, StartInventoryItems.getProfile(p));
        //getClothing.onCloth(p);

        p.setFoodLevel(20);
        p.setHealth(20);
        getVisibility.getGreen(p);
        p.setGameMode(GameMode.SURVIVAL);
        p.setAllowFlight(false);
    }
}
