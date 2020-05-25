package de.MangoleHD.IMLobby.PopupMenus.ProfileMenu;

import org.bukkit.entity.Player;

public abstract class BackAction {
    /**
     * Called when a player clicks the back button
     *
     * @param player The clicking player
     */
    public abstract void onBack(Player player);
}
