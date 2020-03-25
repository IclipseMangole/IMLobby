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
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class StartInventoryListener implements Listener {

    @EventHandler
    public void onTeleporter(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack compass = e.getItem();
        Action click = e.getAction();
        if (click.equals(Action.RIGHT_CLICK_BLOCK) || click.equals(Action.RIGHT_CLICK_AIR)) {
            if (compass.getType().equals(Material.COMPASS) && compass.getItemMeta().getDisplayName().equals(Data.dsp.get("startinventory.name.teleporter", p))) {
                e.setCancelled(true);
                TeleporterMenu.openTeleportMenu(p);
            }
        }
    }

    @EventHandler
    public void onSettings(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack repeater = e.getItem();
        Action click = e.getAction();

        if (click.equals(Action.RIGHT_CLICK_BLOCK) || click.equals(Action.RIGHT_CLICK_AIR)) {
            if (repeater.getType().equals(Material.REPEATER)) {
                e.setCancelled(true);
                SettingsMenu.openSettingsMenu(p);
            }
        }
    }

    @EventHandler
    public void onEnderpearl(ProjectileLaunchEvent e) {
        Projectile ender = e.getEntity();
        Player p = (Player) ender.getShooter();
        if (ender instanceof EnderPearl) {
            if (((EnderPearl) ender).getItem().getItemMeta().getDisplayName().equals(Data.dsp.get("startinventory.name.beam", p))) {
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
            if (book.getType().equals(Material.BOOK) && book.getItemMeta().getDisplayName().equalsIgnoreCase(Data.dsp.get("startinventory.name.news", p))) {
                e.setCancelled(true);
                p.chat("/news");
            }
        }
    }

    @EventHandler
    public void onVisibility(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack dye = e.getItem();
        Action c = e.getAction();
        if (c.equals(Action.RIGHT_CLICK_AIR) || c.equals(Action.RIGHT_CLICK_BLOCK)) {
            if (dye.getType().equals(Material.LIME_DYE) || dye.getType().equals(Material.PURPLE_DYE) || dye.getType().equals(Material.GRAY_DYE)) {
                e.setCancelled(true);
                getVisibility.changeDye(dye, p);
            }
        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
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
        if (item.getItemMeta().getDisplayName().endsWith("Helmet")) {
            p.getInventory().setHelmet(item);
        }
        if (item.getItemMeta().getDisplayName().endsWith("Hat")) {
            p.getInventory().setHelmet(item);
        }
        if (item.getItemMeta().getDisplayName().endsWith("Chestplate")) {
            p.getInventory().setChestplate(item);
        }
        if (item.getItemMeta().getDisplayName().endsWith("Tunic")) {
            p.getInventory().setChestplate(item);
        }
        if (item.getItemMeta().getDisplayName().endsWith("Leggings")) {
            p.getInventory().setLeggings(item);
        }
        if (item.getItemMeta().getDisplayName().endsWith("Trousers")) {
            p.getInventory().setLeggings(item);
        }
        if (item.getItemMeta().getDisplayName().endsWith("Boots")) {
            p.getInventory().setBoots(item);
        }
        if (item.getItemMeta().getDisplayName().endsWith("§cRocket")) {
            p.getInventory().setItem(4, item);
        }
    }


    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        ItemStack item = e.getCursor();
        if (!item.getType().equals(Material.AIR)) {
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
                    if (item.getItemMeta().getDisplayName().endsWith("Helmet")) {
                        p.getInventory().setHelmet(item);
                    }
                    if (item.getItemMeta().getDisplayName().endsWith("Hat")) {
                        p.getInventory().setHelmet(item);
                    }
                    if (item.getItemMeta().getDisplayName().endsWith("Chestplate")) {
                        p.getInventory().setChestplate(item);
                    }
                    if (item.getItemMeta().getDisplayName().endsWith("Tunic")) {
                        p.getInventory().setChestplate(item);
                    }
                    if (item.getItemMeta().getDisplayName().endsWith("Leggings")) {
                        p.getInventory().setLeggings(item);
                    }
                    if (item.getItemMeta().getDisplayName().endsWith("Trousers")) {
                        p.getInventory().setLeggings(item);
                    }
                    if (item.getItemMeta().getDisplayName().endsWith("Boots")) {
                        p.getInventory().setBoots(item);
                    }
                    if (item.getItemMeta().getDisplayName().endsWith(Data.dsp.get("extras.rocket", p))) {
                        p.getInventory().setItem(4, item);
                    }
                }
            }
        }
    }
}
