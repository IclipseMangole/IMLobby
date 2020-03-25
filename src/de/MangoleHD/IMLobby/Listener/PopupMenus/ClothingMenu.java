package de.MangoleHD.IMLobby.Listener.PopupMenus;

import de.Iclipse.IMAPI.Functions.MySQL.MySQL_UserSettings;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.Iclipse.IMAPI.Util.menu.MenuItem;
import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import de.Iclipse.IMAPI.Util.menu.PopupMenuAPI;
import de.MangoleHD.IMLobby.Data;
import de.MangoleHD.IMLobby.StaticClasses.getClothing;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class ClothingMenu {

    public static void openClothingMenu(Player p, PopupMenu old) {
        //Menu
        PopupMenu clothing = new PopupMenu(Data.dsp.get("clothing.menu", p), 3);
        //MenuItems
        ItemStack blackleather = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta blackmeta = (LeatherArmorMeta) blackleather.getItemMeta();
        blackmeta.setColor(Color.BLACK);
        blackleather.setItemMeta(blackmeta);
        MenuItem Black_Leather = new MenuItem(Data.dsp.get("clothing.black", p), blackleather) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()), "clothing", "black_leather");
                getClothing.onCloth(player);
                player.setAllowFlight(false);
                clothing.closeMenu(player);

            }
        };
        Black_Leather.setLore(Data.dsp.get("clothing.black.lore", p));

        ItemStack grayleather = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta graymeta = (LeatherArmorMeta) grayleather.getItemMeta();
        graymeta.setColor(Color.GRAY);
        grayleather.setItemMeta(graymeta);
        MenuItem Gray_Leather = new MenuItem(Data.dsp.get("clothing.gray", p), grayleather) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()), "clothing", "gray_leather");
                getClothing.onCloth(player);
                player.setAllowFlight(false);
                clothing.closeMenu(player);
            }
        };
        Gray_Leather.setLore(Data.dsp.get("clothing.gray.lore", p));

        ItemStack whiteleather = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta whitemeta = (LeatherArmorMeta) whiteleather.getItemMeta();
        whitemeta.setColor(Color.WHITE);
        whiteleather.setItemMeta(whitemeta);
        MenuItem White_Leather = new MenuItem(Data.dsp.get("clothing.white", p), whiteleather) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()), "clothing", "white_leather");
                getClothing.onCloth(player);
                player.setAllowFlight(false);
                clothing.closeMenu(player);
            }
        };
        White_Leather.setLore(Data.dsp.get("clothing.white.lore", p));

        ItemStack redleather = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta redmeta = (LeatherArmorMeta) redleather.getItemMeta();
        redmeta.setColor(Color.RED);
        redleather.setItemMeta(redmeta);
        MenuItem Red_Leather = new MenuItem(Data.dsp.get("clothing.red", p), redleather) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()), "clothing", "red_leather");
                getClothing.onCloth(player);
                player.setAllowFlight(false);
                clothing.closeMenu(player);
            }
        };
        Red_Leather.setLore(Data.dsp.get("clothing.red.lore", p));

        ItemStack blueleather = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta bluemeta = (LeatherArmorMeta) blueleather.getItemMeta();
        bluemeta.setColor(Color.BLUE);
        blueleather.setItemMeta(bluemeta);
        MenuItem Blue_Leather = new MenuItem(Data.dsp.get("clothing.blue", p), blueleather) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()), "clothing", "blue_leather");
                getClothing.onCloth(player);
                player.setAllowFlight(false);
                clothing.closeMenu(player);
            }
        };
        Blue_Leather.setLore(Data.dsp.get("clothing.blue.lore", p));

        ItemStack greenleather = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta greenmeta = (LeatherArmorMeta) greenleather.getItemMeta();
        greenmeta.setColor(Color.GREEN);
        greenleather.setItemMeta(greenmeta);
        MenuItem Green_Leather = new MenuItem(Data.dsp.get("clothing.green", p), greenleather) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()), "clothing", "green_leather");
                getClothing.onCloth(player);
                player.setAllowFlight(false);
                clothing.closeMenu(player);
            }
        };
        Green_Leather.setLore(Data.dsp.get("clothing.green.lore", p));

        ItemStack purpleleather = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta purplemeta = (LeatherArmorMeta) purpleleather.getItemMeta();
        purplemeta.setColor(Color.PURPLE);
        purpleleather.setItemMeta(purplemeta);
        MenuItem Purple_Leather = new MenuItem(Data.dsp.get("clothing.purple", p), purpleleather) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()), "clothing", "purple_leather");
                getClothing.onCloth(player);
                player.setAllowFlight(false);
                clothing.closeMenu(player);
            }
        };
        Purple_Leather.setLore(Data.dsp.get("clothing.purple.lore", p));

        ItemStack aqualeather = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta aquameta = (LeatherArmorMeta) aqualeather.getItemMeta();
        aquameta.setColor(Color.AQUA);
        aqualeather.setItemMeta(aquameta);
        MenuItem Aqua_Leather = new MenuItem(Data.dsp.get("clothing.aqua", p), aqualeather) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()), "clothing", "aqua_leather");
                getClothing.onCloth(player);
                player.setAllowFlight(false);
                clothing.closeMenu(player);
            }
        };
        Aqua_Leather.setLore(Data.dsp.get("clothing.aqua.lore", p));

        ItemStack orangeleather = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta orangemeta = (LeatherArmorMeta) orangeleather.getItemMeta();
        orangemeta.setColor(Color.ORANGE);
        orangeleather.setItemMeta(orangemeta);
        MenuItem Orange_Leather = new MenuItem(Data.dsp.get("clothing.orange", p), orangeleather) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()), "clothing", "orange_leather");
                getClothing.onCloth(player);
                player.setAllowFlight(false);
                clothing.closeMenu(player);
            }
        };
        Orange_Leather.setLore(Data.dsp.get("clothing.orange.lore", p));

        ItemStack yellowleather = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta yellowmeta = (LeatherArmorMeta) yellowleather.getItemMeta();
        yellowmeta.setColor(Color.YELLOW);
        yellowleather.setItemMeta(yellowmeta);
        MenuItem Yellow_Leather = new MenuItem(Data.dsp.get("clothing.yellow", p), yellowleather) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()), "clothing", "yellow_leather");
                getClothing.onCloth(player);
                player.setAllowFlight(false);
                clothing.closeMenu(player);
            }
        };
        Yellow_Leather.setLore(Data.dsp.get("clothing.yellow.lore", p));

        ItemStack oliveleather = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta olivemeta = (LeatherArmorMeta) oliveleather.getItemMeta();
        olivemeta.setColor(Color.OLIVE);
        oliveleather.setItemMeta(olivemeta);
        MenuItem Olive_Leather = new MenuItem(Data.dsp.get("clothing.olive", p), oliveleather) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()), "clothing", "olive_leather");
                getClothing.onCloth(player);
                player.setAllowFlight(false);
                clothing.closeMenu(player);
            }
        };
        Olive_Leather.setLore(Data.dsp.get("clothing.olive.lore", p));

        ItemStack navyleather = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta navymeta = (LeatherArmorMeta) navyleather.getItemMeta();
        navymeta.setColor(Color.NAVY);
        navyleather.setItemMeta(navymeta);
        MenuItem Navy_Leather = new MenuItem(Data.dsp.get("clothing.navy", p), navyleather) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()), "clothing", "navy_leather");
                getClothing.onCloth(player);
                player.setAllowFlight(false);
                clothing.closeMenu(player);
            }
        };
        Navy_Leather.setLore(Data.dsp.get("clothing.navy.lore", p));

        ItemStack fuchsialeather = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta fuchsiameta = (LeatherArmorMeta) fuchsialeather.getItemMeta();
        fuchsiameta.setColor(Color.FUCHSIA);
        fuchsialeather.setItemMeta(fuchsiameta);
        MenuItem Fuchsia_Leather = new MenuItem(Data.dsp.get("clothing.fuchsia", p), fuchsialeather) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()), "clothing", "fuchsia_leather");
                getClothing.onCloth(player);
                player.setAllowFlight(false);
                clothing.closeMenu(player);
            }
        };
        Fuchsia_Leather.setLore(Data.dsp.get("clothing.fuchsia.lore", p));

        ItemStack maroonleather = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta maroonmeta = (LeatherArmorMeta) maroonleather.getItemMeta();
        maroonmeta.setColor(Color.MAROON);
        maroonleather.setItemMeta(maroonmeta);
        MenuItem Maroon_Leather = new MenuItem(Data.dsp.get("clothing.maroon", p), maroonleather) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()), "clothing", "maroon_leather");
                getClothing.onCloth(player);
                player.setAllowFlight(false);
                clothing.closeMenu(player);
            }
        };
        Maroon_Leather.setLore(Data.dsp.get("clothing.maroon.lore", p));

        ItemStack silverleather = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta silvermeta = (LeatherArmorMeta) silverleather.getItemMeta();
        silvermeta.setColor(Color.SILVER);
        silverleather.setItemMeta(silvermeta);
        MenuItem Silver_Leather = new MenuItem(Data.dsp.get("clothing.silver", p), silverleather) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()), "clothing", "silver_leather");
                getClothing.onCloth(player);
                player.setAllowFlight(false);
                clothing.closeMenu(player);
            }
        };
        Silver_Leather.setLore(Data.dsp.get("clothing.silver.lore", p));

        ItemStack tealleather = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta tealmeta = (LeatherArmorMeta) tealleather.getItemMeta();
        tealmeta.setColor(Color.TEAL);
        tealleather.setItemMeta(tealmeta);
        MenuItem Teal_Leather = new MenuItem(Data.dsp.get("clothing.teal", p), tealleather) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()), "clothing", "teal_leather");
                getClothing.onCloth(player);
                player.setAllowFlight(false);
                clothing.closeMenu(player);
            }
        };
        Teal_Leather.setLore(Data.dsp.get("clothing.teal.lore", p));

        ItemStack goldchest = new ItemStack(Material.GOLDEN_CHESTPLATE);
        MenuItem King = new MenuItem(Data.dsp.get("clothing.king", p), goldchest) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()), "clothing", "king");
                getClothing.onCloth(player);
                player.setAllowFlight(false);
                clothing.closeMenu(player);
            }
        };
        King.setLore(Data.dsp.get("clothing.king.lore", p));

        ItemStack chainchest = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        MenuItem Thief = new MenuItem(Data.dsp.get("clothing.thief", p), chainchest) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()), "clothing", "thief");
                getClothing.onCloth(player);
                player.setAllowFlight(false);
                clothing.closeMenu(player);
            }
        };
        Thief.setLore(Data.dsp.get("clothing.thief.lore", p));

        ItemStack slime = new ItemStack(Material.SLIME_BLOCK);
        MenuItem Jumper = new MenuItem(Data.dsp.get("clothing.jumper", p), slime) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()), "clothing", "jumper");
                getClothing.onCloth(player);
                player.setAllowFlight(true);
                clothing.closeMenu(player);
            }
        };
        Jumper.setLore(Data.dsp.get("clothing.jumper.lore", p));

        ItemStack ghost = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        MenuItem Ghost = new MenuItem(Data.dsp.get("clothing.ghost", p), ghost) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()), "clothing", "ghost");
                getClothing.onCloth(player);
                player.setAllowFlight(false);
                clothing.closeMenu(player);
            }
        };
        Ghost.setLore(Data.dsp.get("clothing.ghost.lore", p));

        MenuItem Off = new MenuItem(Data.dsp.get("clothing.off", p), new ItemStack(Material.BARRIER)) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()), "clothing", "off");
                player.setAllowFlight(false);

                player.getInventory().setHelmet(new ItemStack(Material.AIR));
                player.getInventory().setChestplate(new ItemStack(Material.AIR));
                player.getInventory().setLeggings(new ItemStack(Material.AIR));
                player.getInventory().setBoots(new ItemStack(Material.AIR));

                clothing.closeMenu(player);
            }
        };
        Off.setLore(Data.dsp.get("clothing.off.lore", p));
        //Menu with Items
        clothing.addMenuItem(Black_Leather, 0);
        clothing.addMenuItem(Gray_Leather, 1);
        clothing.addMenuItem(Silver_Leather, 2);
        clothing.addMenuItem(Red_Leather, 3);
        clothing.addMenuItem(Maroon_Leather, 4);
        clothing.addMenuItem(Orange_Leather, 5);
        clothing.addMenuItem(Yellow_Leather, 6);
        clothing.addMenuItem(White_Leather, 7);
        clothing.addMenuItem(Olive_Leather, 8);
        clothing.addMenuItem(Green_Leather, 9);
        clothing.addMenuItem(Aqua_Leather, 10);
        clothing.addMenuItem(Teal_Leather, 11);
        clothing.addMenuItem(Blue_Leather, 12);
        clothing.addMenuItem(Navy_Leather, 13);
        clothing.addMenuItem(Fuchsia_Leather, 14);
        clothing.addMenuItem(Purple_Leather, 15);
        clothing.addMenuItem(King, 0, 2);
        clothing.addMenuItem(Thief, 1, 2);
        clothing.addMenuItem(Jumper, 2, 2);
        clothing.addMenuItem(Ghost, 3, 2);
        clothing.addMenuItem(Off, 26);

        PopupMenuAPI.switchMenu(p, old, clothing);
    }
}
