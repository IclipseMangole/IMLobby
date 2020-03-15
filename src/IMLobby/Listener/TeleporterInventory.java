package IMLobby.Listener;

import de.Iclipse.IMAPI.Util.menu.MenuItem;
import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class TeleporterInventory implements Listener {
    @EventHandler
    public void Teleporter(PlayerInteractEvent e){
        Player p = e.getPlayer();
        ItemStack compass = e.getItem();
        Action click = e.getAction();
        if(click.equals(Action.RIGHT_CLICK_BLOCK)||click.equals(Action.RIGHT_CLICK_AIR)){
            if(compass.getType().equals(Material.COMPASS)&&compass.getItemMeta().getDisplayName().equals("Teleporter")){
                e.setCancelled(true);
                //Menu
                PopupMenu teleMenu = new PopupMenu("Teleporter",5);
                //MenuItems
                MenuItem spawn = new MenuItem("Spawn", new ItemStack(Material.DIAMOND)) {
                    @Override
                    public void onClick(Player player) {
                        Location spawn = new Location(player.getWorld(),0.5,4,0.5, 180, 0);
                        player.teleport(spawn);
                        p.playSound(spawn, Sound.ENTITY_ENDERMAN_TELEPORT,1,1);
                    }
                };
                //Menu with Items
                teleMenu.addMenuItem(spawn,4,2);

                teleMenu.openMenu(p);
            }
        }
    }
}
