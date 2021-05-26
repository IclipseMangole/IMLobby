package de.MangoleHD.IMLobby.Listener;

import de.MangoleHD.IMLobby.Data;
import de.MangoleHD.IMLobby.IMLobby;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class ExtrasListener implements Listener {

    private IMLobby imLobby;

    public ExtrasListener(IMLobby imLobby) {
        this.imLobby = imLobby;
    }

    @EventHandler
    public void onRocket(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        Action click = e.getAction();
        ItemStack rocket = e.getItem();

        if (click.equals(Action.RIGHT_CLICK_AIR) || click.equals(Action.RIGHT_CLICK_BLOCK)) {
            if (p.isOnGround()) {
                if (e.hasItem()) {
                    if (rocket.getItemMeta().getDisplayName().equals(imLobby.getData().getDispatcher().get("extras.rocket", p))) {
                        Vector v = new Vector();
                        v.setX(0).setY(50).setZ(0);
                        p.setVelocity(v);
                        p.getInventory().setItem(4, new ItemStack(Material.AIR));
                    }
                }
            }
        }
    }
}
