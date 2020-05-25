package de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.LobbyInventory;

import de.Iclipse.IMAPI.Database.UserSettings;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.Iclipse.IMAPI.Util.menu.MenuItem;
import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import de.MangoleHD.IMLobby.Data;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class InventoryItems {
    public static MenuItem particleItem(Player p, PopupMenu last) {
        MenuItem particles = new MenuItem(Data.dsp.get("particle.title", p), currentParticleItem(p)) {
            @Override
            public void onClick(Player player) {
                ParticleMenu.openParticleMenu(player, last);
            }
        };
        particles.setLore(Data.dsp.get("particle.lore", p));
        return particles;
    }

    public static MenuItem clothingItem(Player p, PopupMenu last) {
        MenuItem clothing = new MenuItem(Data.dsp.get("clothing.title", p), new ItemStack(Material.LEATHER_CHESTPLATE)) {
            @Override
            public void onClick(Player player) {
                ClothingMenu.openClothingMenu(player);
            }
        };
        clothing.setLore(Data.dsp.get("clothing.lore", p));
        return clothing;
    }

    public static MenuItem extrasItem(Player p, PopupMenu last) {
        MenuItem extras = new MenuItem(Data.dsp.get("extras.title", p), new ItemStack(Material.SNOWBALL)) {
            @Override
            public void onClick(Player player) {
                ExtrasMenu.openExtrasMenu(player, last);
            }
        };
        extras.setLore(Data.dsp.get("extras.lore", p));
        return extras;
    }

    public static ItemStack currentParticleItem(Player p) {
        switch (UserSettings.getString(UUIDFetcher.getUUID(p.getName()), "particles")) {
            case "flames":
                return new ItemStack(Material.BLAZE_POWDER);
            case "water":
                return new ItemStack(Material.WATER_BUCKET);
            case "lava":
                return new ItemStack(Material.LAVA_BUCKET);
            case "love":
                return new ItemStack(Material.POPPY);
            case "music":
                return new ItemStack(Material.JUKEBOX);
            case "boom":
                return new ItemStack(Material.TNT);
            case "smoke":
                return new ItemStack(Material.BONE_MEAL);
            case "slime":
                return new ItemStack(Material.SLIME_BALL);
            default:
                return new ItemStack(Material.BARRIER);
        }
    }
}
