package IMLobby.Listener;

import IMLobby.Listener.PopupMenus.SettingsMenu;
import IMLobby.Listener.PopupMenus.TeleporterMenu;
import net.minecraft.server.v1_15_R1.Schedule;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import IMLobby.Data;

import java.util.Timer;

public class StartInventoryListener implements Listener {

    @EventHandler
    public void Teleporter(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack compass = e.getItem();
        Action click = e.getAction();
        if (click.equals(Action.RIGHT_CLICK_BLOCK) || click.equals(Action.RIGHT_CLICK_AIR)) {
            if (compass.getType().equals(Material.COMPASS) && compass.getItemMeta().getDisplayName().equals("Teleporter")) {
                e.setCancelled(true);
                TeleporterMenu.openTeleportMenu(p);
            }
        }
    }

    @EventHandler
    public void Settings(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack repeater = e.getItem();
        Action click = e.getAction();

        if (click.equals(Action.RIGHT_CLICK_BLOCK) || click.equals(Action.RIGHT_CLICK_AIR)) {
            if (repeater.getType().equals(Material.REPEATER) && repeater.getItemMeta().getDisplayName().equals("Settings")) {
                e.setCancelled(true);
                SettingsMenu.openSettingsMenu(p);
            }
        }
    }

    @EventHandler
    public void Enderpearl(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack enderpearl = e.getItem();
        Action click = e.getAction();
        long cooldown = 5;

        if (click.equals(Action.RIGHT_CLICK_BLOCK) || click.equals(Action.RIGHT_CLICK_AIR)) {
            if (enderpearl.getType().equals(Material.ENDER_PEARL) && enderpearl.getItemMeta().getDisplayName().equalsIgnoreCase("Beam")) {
                if (Data.enderCooldown.containsKey(p.getName())) {
                    long cooldownLeft = (Data.enderCooldown.get(p.getName()) / 1000 + cooldown) - (System.currentTimeMillis() / 1000);

                    if (cooldownLeft > 0) {
                        e.setCancelled(true);
                        p.sendMessage("§cDu musst noch " + cooldownLeft + " Sekunden warten!");
                    } else {
                        Data.enderCooldown.remove(p.getName());
                        p.getInventory().setItem(1,enderpearl);
                    }
                } else {
                    p.getInventory().setItem(1, enderpearl);
                    Data.enderCooldown.put(p.getName(), System.currentTimeMillis());
                }
            }
        }
    }

    @EventHandler
    public void News(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack book = e.getItem();
        Action c = e.getAction();
        if (c.equals(Action.RIGHT_CLICK_AIR) || c.equals(Action.RIGHT_CLICK_BLOCK)) {
            if (book.getType().equals(Material.BOOK) && book.getItemMeta().getDisplayName().equalsIgnoreCase("News")) {
                e.setCancelled(true);
                p.chat("/news");
            }
        }
    }

    @EventHandler
    public void Endermite(CreatureSpawnEvent e) {
        if (e.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.ENDER_PEARL) || e.getEntityType().equals(EntityType.ENDERMITE)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void NoDrop(PlayerDropItemEvent e) {
        Player p = e.getPlayer();
        ItemStack item = e.getItemDrop().getItemStack();
        e.setCancelled(true);
        if (item.equals(new ItemStack(Material.COMPASS))) {
            p.getInventory().setItem(0, item);
        }
        if (item.equals(new ItemStack(Material.ENDER_PEARL))) {
            if (!p.getInventory().getItem(1).equals(Material.ENDER_PEARL)) {
                p.getInventory().setItem(1, item);
            }
        }
        if (item.equals(new ItemStack(Material.REPEATER))) {
            p.getInventory().setItem(8, item);
        }
        if (item.equals(new ItemStack(Material.LEATHER_HELMET))) {
            p.getInventory().setHelmet(item);
        }
        if (item.equals(new ItemStack(Material.LEATHER_CHESTPLATE))) {
            p.getInventory().setChestplate(item);
        }
        if (item.equals(new ItemStack(Material.LEATHER_LEGGINGS))) {
            p.getInventory().setLeggings(item);
        }
        if (item.equals(new ItemStack(Material.LEATHER_BOOTS))) {
            p.getInventory().setBoots(item);
        }
    }


    @EventHandler
    public void NoClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        ItemStack item = e.getCursor();

        ClickType c = e.getClick();
        if (c.isLeftClick() || c.isRightClick() || c.isShiftClick() || c.isKeyboardClick()) {
            if (!c.isCreativeAction()) {
                e.setCancelled(true);
                if (item.equals(new ItemStack(Material.COMPASS))) {
                    p.getInventory().setItem(0, item);
                }
                if (item.equals(new ItemStack(Material.ENDER_PEARL))) {
                    p.getInventory().setItem(1, item);
                }
                if (item.equals(new ItemStack(Material.REPEATER))) {
                    p.getInventory().setItem(8, item);
                }
                if (item.equals(new ItemStack(Material.LEATHER_HELMET))) {
                    p.getInventory().setHelmet(item);
                }
                if (item.equals(new ItemStack(Material.LEATHER_CHESTPLATE))) {
                    p.getInventory().setChestplate(item);
                }
                if (item.equals(new ItemStack(Material.LEATHER_LEGGINGS))) {
                    p.getInventory().setLeggings(item);
                }
                if (item.equals(new ItemStack(Material.LEATHER_BOOTS))) {
                    p.getInventory().setBoots(item);
                }
            }
        }
    }
}
