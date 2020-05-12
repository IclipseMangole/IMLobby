package de.MangoleHD.IMLobby.Listener;

import de.MangoleHD.IMLobby.Data;
import de.MangoleHD.IMLobby.Listener.PopupMenus.SettingsMenu;
import de.MangoleHD.IMLobby.Listener.PopupMenus.TeleporterMenu;
import de.MangoleHD.IMLobby.Scheduler.Scheduler;
import de.MangoleHD.IMLobby.StaticClasses.getVisibility;
import org.bukkit.Material;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import static de.MangoleHD.IMLobby.Data.dsp;

public class StartInventoryListener implements Listener {

    @EventHandler
    public void onTeleporter(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack compass = e.getItem();
        Action click = e.getAction();
        if (click.equals(Action.RIGHT_CLICK_BLOCK) || click.equals(Action.RIGHT_CLICK_AIR)) {
            if (e.getItem() != null) {
                if (compass.getType().equals(Material.COMPASS) && compass.getItemMeta().getDisplayName().equalsIgnoreCase(dsp.get("startinventory.name.teleporter", p))) {
                    TeleporterMenu.openTeleportMenu(p);
                }
            }
        }
    }

    @EventHandler
    public void onSettings(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack repeater = e.getItem();
        Action click = e.getAction();

        if (click.equals(Action.RIGHT_CLICK_BLOCK) || click.equals(Action.RIGHT_CLICK_AIR)) {
            if (e.getItem() != null) {
                if (repeater.getType().equals(Material.REPEATER)) {
                    SettingsMenu.openSettingsMenu(p);
                }
            }
        }
    }

    @EventHandler
    public void onEnderpearl(ProjectileLaunchEvent e) {
        Projectile ender = e.getEntity();
        Player p = (Player) ender.getShooter();
        if (ender instanceof EnderPearl) {
            if (((EnderPearl) ender).getItem().getItemMeta().getDisplayName().equalsIgnoreCase(dsp.get("startinventory.name.beam", p))) {
                Scheduler.EnderToClay(p);
            }
        }
    }

    @EventHandler
    public void onNews(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack book = e.getItem();
        Action c = e.getAction();
        if (c.equals(Action.RIGHT_CLICK_AIR) || c.equals(Action.RIGHT_CLICK_BLOCK)) {
            if (e.getItem() != null) {
                if (book.getType().equals(Material.BOOK) && book.getItemMeta().getDisplayName().equalsIgnoreCase(dsp.get("startinventory.name.news", p))) {
                    p.chat("/news");
                }
            }
        }
    }

    @EventHandler
    public void onVisibility(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack dye = e.getItem();
        Action c = e.getAction();
        if (c.equals(Action.RIGHT_CLICK_AIR) || c.equals(Action.RIGHT_CLICK_BLOCK)) {
            if (e.getItem() != null) {
                if (dye.getType().equals(Material.LIME_DYE) || dye.getType().equals(Material.PURPLE_DYE) || dye.getType().equals(Material.GRAY_DYE)) {
                    getVisibility.changeDye(dye, p);
                }
            }
        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onDrag(InventoryDragEvent e) {
        if (e.getWhoClicked() != null) {
            if (e.getInventory().equals(e.getWhoClicked().getInventory())) {
                e.setCancelled(true);
            }
        }
    }


    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (e.getClickedInventory() != null) {
            if (e.getClickedInventory().equals(e.getWhoClicked().getInventory())) {
                if (!Data.fighting.contains(player)) {
                    e.setCancelled(true);
                }
            }
        }
    }
}
