package IMLobby.Listener;

import IMLobby.Listener.PopupMenus.ClothingMenu;
import IMLobby.Listener.PopupMenus.ParticleMenu;
import de.Iclipse.IMAPI.Util.menu.MenuItem;
import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class SettingsInventory implements Listener {
    @EventHandler
    public void Settings(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack repeater = e.getItem();
        Action click = e.getAction();

        if (click.equals(Action.RIGHT_CLICK_BLOCK) || click.equals(Action.RIGHT_CLICK_AIR)) {
            if (repeater.getType().equals(Material.REPEATER) && repeater.getItemMeta().getDisplayName().equals("Settings")) {
                e.setCancelled(true);
                //Menu
                PopupMenu settMenu = new PopupMenu("Settings",5);
                //MenuItems
                MenuItem particles = new MenuItem("Particles", new ItemStack(Material.EMERALD)) {
                    @Override
                    public void onClick(Player player) {
                        ParticleMenu.openParticleMenu(player, settMenu);
                    }
                };

                MenuItem clothing = new MenuItem("Particles", new ItemStack(Material.LEATHER_CHESTPLATE)) {
                    @Override
                    public void onClick(Player player) {
                        ClothingMenu.openClothingMenu(player, settMenu);
                    }
                };
                //Menu with Items
                settMenu.addMenuItem(particles,2,2);

                settMenu.openMenu(p);
            }
        }
    }
}
