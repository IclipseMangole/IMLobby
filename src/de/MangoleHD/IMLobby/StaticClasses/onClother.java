package de.MangoleHD.IMLobby.StaticClasses;

import de.Iclipse.IMAPI.Functions.MySQL.MySQL_UserSettings;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class onClother implements Listener {

    private static void onCloth(Player p, Color color) {
        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
        ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);

        LeatherArmorMeta h = (LeatherArmorMeta) helmet.getItemMeta();
        LeatherArmorMeta c = (LeatherArmorMeta) chest.getItemMeta();
        LeatherArmorMeta l = (LeatherArmorMeta) leggings.getItemMeta();
        LeatherArmorMeta b = (LeatherArmorMeta) boots.getItemMeta();

        h.setColor(color);
        c.setColor(color);
        l.setColor(color);
        b.setColor(color);

        helmet.setItemMeta(h);
        chest.setItemMeta(c);
        leggings.setItemMeta(l);
        boots.setItemMeta(b);

        p.getInventory().setHelmet(helmet);
        p.getInventory().setChestplate(chest);
        p.getInventory().setLeggings(leggings);
        p.getInventory().setBoots(boots);
    }

    public static void onCloth(Player p) {
        if (MySQL_UserSettings.getString(UUIDFetcher.getUUID(p.getName()), "clothing").equals("black_leather")) {
            onCloth(p, Color.BLACK);
        }
        if (MySQL_UserSettings.getString(UUIDFetcher.getUUID(p.getName()), "clothing").equals("gray_leather")) {
            onCloth(p, Color.GRAY);
        }
        if (MySQL_UserSettings.getString(UUIDFetcher.getUUID(p.getName()), "clothing").equals("white_leather")) {
            onCloth(p, Color.WHITE);
        }
        if (MySQL_UserSettings.getString(UUIDFetcher.getUUID(p.getName()), "clothing").equals("red_leather")) {
            onCloth(p, Color.RED);
        }
        if (MySQL_UserSettings.getString(UUIDFetcher.getUUID(p.getName()), "clothing").equals("blue_leather")) {
            onCloth(p, Color.BLUE);
        }
        if (MySQL_UserSettings.getString(UUIDFetcher.getUUID(p.getName()), "clothing").equals("green_leather")) {
            onCloth(p, Color.GREEN);
        }
        if (MySQL_UserSettings.getString(UUIDFetcher.getUUID(p.getName()), "clothing").equals("purple_leather")) {
            onCloth(p, Color.PURPLE);
        }
        if (MySQL_UserSettings.getString(UUIDFetcher.getUUID(p.getName()), "clothing").equals("aqua_leather")) {
            onCloth(p, Color.AQUA);
        }
        if (MySQL_UserSettings.getString(UUIDFetcher.getUUID(p.getName()), "clothing").equals("orange_leather")) {
            onCloth(p, Color.ORANGE);
        }
        if (MySQL_UserSettings.getString(UUIDFetcher.getUUID(p.getName()), "clothing").equals("yellow_leather")) {
            onCloth(p, Color.YELLOW);
        }
        if (MySQL_UserSettings.getString(UUIDFetcher.getUUID(p.getName()), "clothing").equals("olive_leather")) {
            onCloth(p, Color.OLIVE);
        }
        if (MySQL_UserSettings.getString(UUIDFetcher.getUUID(p.getName()), "clothing").equals("navy_leather")) {
            onCloth(p, Color.NAVY);
        }
        if (MySQL_UserSettings.getString(UUIDFetcher.getUUID(p.getName()), "clothing").equals("fuchsia_leather")) {
            onCloth(p, Color.FUCHSIA);
        }
        if (MySQL_UserSettings.getString(UUIDFetcher.getUUID(p.getName()), "clothing").equals("jumper")) {
            onCloth(p, Color.LIME);
        }
        if (MySQL_UserSettings.getString(UUIDFetcher.getUUID(p.getName()), "clothing").equals("maroon_leather")) {
            onCloth(p, Color.MAROON);
        }
        if (MySQL_UserSettings.getString(UUIDFetcher.getUUID(p.getName()), "clothing").equals("silver_leather")) {
            onCloth(p, Color.SILVER);
        }
        if (MySQL_UserSettings.getString(UUIDFetcher.getUUID(p.getName()), "clothing").equals("teal_leather")) {
            onCloth(p, Color.TEAL);
        }
        if (MySQL_UserSettings.getString(UUIDFetcher.getUUID(p.getName()), "clothing").equals("king")) {
            onClothKing(p);
        }
        if (MySQL_UserSettings.getString(UUIDFetcher.getUUID(p.getName()), "clothing").equals("thief")) {
            onClothThief(p);
        }
        if (MySQL_UserSettings.getString(UUIDFetcher.getUUID(p.getName()), "clothing").equals("off")) {
            p.getInventory().setHelmet(new ItemStack(Material.AIR));
            p.getInventory().setChestplate(new ItemStack(Material.AIR));
            p.getInventory().setLeggings(new ItemStack(Material.AIR));
            p.getInventory().setBoots(new ItemStack(Material.AIR));
        }
    }

    public static void onClothKing(Player p) {
        ItemStack helmet = new ItemStack(Material.GOLDEN_HELMET);
        ItemStack chest = new ItemStack(Material.GOLDEN_CHESTPLATE);
        ItemStack leggings = new ItemStack(Material.GOLDEN_LEGGINGS);
        ItemStack boots = new ItemStack(Material.GOLDEN_BOOTS);

        p.getInventory().setHelmet(helmet);
        p.getInventory().setChestplate(chest);
        p.getInventory().setLeggings(leggings);
        p.getInventory().setBoots(boots);
    }

    public static void onClothThief(Player p) {
        ItemStack helmet = new ItemStack(Material.CHAINMAIL_HELMET);
        ItemStack chest = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        ItemStack leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS);
        ItemStack boots = new ItemStack(Material.CHAINMAIL_BOOTS);

        p.getInventory().setHelmet(helmet);
        p.getInventory().setChestplate(chest);
        p.getInventory().setLeggings(leggings);
        p.getInventory().setBoots(boots);

    }
}
