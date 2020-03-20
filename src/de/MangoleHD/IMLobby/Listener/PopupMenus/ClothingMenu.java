package de.MangoleHD.IMLobby.Listener.PopupMenus;

import de.MangoleHD.IMLobby.StaticClasses.getClothing;
import de.Iclipse.IMAPI.Functions.MySQL.MySQL_UserSettings;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.Iclipse.IMAPI.Util.menu.MenuItem;
import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import de.Iclipse.IMAPI.Util.menu.PopupMenuAPI;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class ClothingMenu {

    public static void openClothingMenu(Player p, PopupMenu old){
        //Menu
        PopupMenu clothing = new PopupMenu("Clothing",3);
        //MenuItems
        ItemStack blackleather = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta blackmeta = (LeatherArmorMeta) blackleather.getItemMeta();
        blackmeta.setColor(Color.BLACK);
        blackleather.setItemMeta(blackmeta);
        MenuItem Black_Leather = new MenuItem("Black",blackleather) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()),"clothing","black_leather");
                getClothing.onCloth(player);
                clothing.closeMenu(player);

            }
        };

        ItemStack grayleather = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta graymeta = (LeatherArmorMeta) grayleather.getItemMeta();
        graymeta.setColor(Color.GRAY);
        grayleather.setItemMeta(graymeta);
        MenuItem Gray_Leather = new MenuItem("Gray",grayleather) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()),"clothing","gray_leather");
                getClothing.onCloth(player);
                clothing.closeMenu(player);
            }
        };

        ItemStack whiteleather = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta whitemeta = (LeatherArmorMeta) whiteleather.getItemMeta();
        whitemeta.setColor(Color.WHITE);
        whiteleather.setItemMeta(whitemeta);
        MenuItem White_Leather = new MenuItem("White",whiteleather) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()),"clothing","white_leather");
                getClothing.onCloth(player);
                clothing.closeMenu(player);
            }
        };

        ItemStack redleather = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta redmeta = (LeatherArmorMeta) redleather.getItemMeta();
        redmeta.setColor(Color.RED);
        redleather.setItemMeta(redmeta);
        MenuItem Red_Leather = new MenuItem("Red",redleather) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()),"clothing","red_leather");
                getClothing.onCloth(player);
                clothing.closeMenu(player);
            }
        };

        ItemStack blueleather = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta bluemeta = (LeatherArmorMeta) blueleather.getItemMeta();
        bluemeta.setColor(Color.BLUE);
        blueleather.setItemMeta(bluemeta);
        MenuItem Blue_Leather = new MenuItem("Blue",blueleather) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()),"clothing","blue_leather");
                getClothing.onCloth(player);
                clothing.closeMenu(player);
            }
        };

        ItemStack greenleather = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta greenmeta = (LeatherArmorMeta) greenleather.getItemMeta();
        greenmeta.setColor(Color.GREEN);
        greenleather.setItemMeta(greenmeta);
        MenuItem Green_Leather = new MenuItem("Green",greenleather) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()),"clothing","green_leather");
                getClothing.onCloth(player);
                clothing.closeMenu(player);
            }
        };

        ItemStack purpleleather = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta purplemeta = (LeatherArmorMeta) purpleleather.getItemMeta();
        purplemeta.setColor(Color.PURPLE);
        purpleleather.setItemMeta(purplemeta);
        MenuItem Purple_Leather = new MenuItem("Purple",purpleleather) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()),"clothing","purple_leather");
                getClothing.onCloth(player);
                clothing.closeMenu(player);
            }
        };

        ItemStack aqualeather = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta aquameta = (LeatherArmorMeta) aqualeather.getItemMeta();
        aquameta.setColor(Color.AQUA);
        aqualeather.setItemMeta(aquameta);
        MenuItem Aqua_Leather = new MenuItem("Aqua",aqualeather) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()),"clothing","aqua_leather");
                getClothing.onCloth(player);
                clothing.closeMenu(player);
            }
        };

        ItemStack orangeleather = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta orangemeta = (LeatherArmorMeta) orangeleather.getItemMeta();
        orangemeta.setColor(Color.ORANGE);
        orangeleather.setItemMeta(orangemeta);
        MenuItem Orange_Leather = new MenuItem("Orange",orangeleather) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()),"clothing","orange_leather");
                getClothing.onCloth(player);
                clothing.closeMenu(player);
            }
        };

        ItemStack yellowleather = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta yellowmeta = (LeatherArmorMeta) yellowleather.getItemMeta();
        yellowmeta.setColor(Color.YELLOW);
        yellowleather.setItemMeta(yellowmeta);
        MenuItem Yellow_Leather = new MenuItem("Yellow",yellowleather) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()),"clothing","yellow_leather");
                getClothing.onCloth(player);
                clothing.closeMenu(player);
            }
        };

        ItemStack oliveleather = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta olivemeta = (LeatherArmorMeta) oliveleather.getItemMeta();
        olivemeta.setColor(Color.OLIVE);
        oliveleather.setItemMeta(olivemeta);
        MenuItem Olive_Leather = new MenuItem("Olive",oliveleather) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()),"clothing","olive_leather");
                getClothing.onCloth(player);
                clothing.closeMenu(player);
            }
        };

        ItemStack navyleather = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta navymeta = (LeatherArmorMeta) navyleather.getItemMeta();
        navymeta.setColor(Color.NAVY);
        navyleather.setItemMeta(navymeta);
        MenuItem Navy_Leather = new MenuItem("Navy",navyleather) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()),"clothing","navy_leather");
                getClothing.onCloth(player);
                clothing.closeMenu(player);
            }
        };

        ItemStack fuchsialeather = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta fuchsiameta = (LeatherArmorMeta) fuchsialeather.getItemMeta();
        fuchsiameta.setColor(Color.FUCHSIA);
        fuchsialeather.setItemMeta(fuchsiameta);
        MenuItem Fuchsia_Leather = new MenuItem("Fuchsia",fuchsialeather) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()),"clothing","fuchsia_leather");
                getClothing.onCloth(player);
                clothing.closeMenu(player);
            }
        };

        ItemStack maroonleather = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta maroonmeta = (LeatherArmorMeta) maroonleather.getItemMeta();
        maroonmeta.setColor(Color.MAROON);
        maroonleather.setItemMeta(maroonmeta);
        MenuItem Maroon_Leather = new MenuItem("Maroon",maroonleather) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()),"clothing","maroon_leather");
                getClothing.onCloth(player);
                clothing.closeMenu(player);
            }
        };

        ItemStack silverleather = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta silvermeta = (LeatherArmorMeta) silverleather.getItemMeta();
        silvermeta.setColor(Color.SILVER);
        silverleather.setItemMeta(silvermeta);
        MenuItem Silver_Leather = new MenuItem("Silver",silverleather) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()),"clothing","silver_leather");
                getClothing.onCloth(player);
                clothing.closeMenu(player);
            }
        };

        ItemStack tealleather = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta tealmeta = (LeatherArmorMeta) tealleather.getItemMeta();
        tealmeta.setColor(Color.TEAL);
        tealleather.setItemMeta(tealmeta);
        MenuItem Teal_Leather = new MenuItem("Teal",tealleather) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()),"clothing","teal_leather");
                getClothing.onCloth(player);
                clothing.closeMenu(player);
            }
        };

        ItemStack goldchest = new ItemStack(Material.GOLDEN_CHESTPLATE);
        MenuItem King = new MenuItem("King",goldchest) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()),"clothing","king");
                getClothing.onCloth(player);
                clothing.closeMenu(player);
            }
        };

        ItemStack chainchest = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        MenuItem Thief = new MenuItem("Thief",chainchest) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()),"clothing","thief");
                getClothing.onCloth(player);
                clothing.closeMenu(player);
            }
        };

        ItemStack slime = new ItemStack(Material.SLIME_BLOCK);
        MenuItem Slime = new MenuItem("Jumper",slime) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()),"clothing","jumper");
                getClothing.onCloth(player);
                clothing.closeMenu(player);
            }
        };

        ItemStack ghost = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        MenuItem Ghost = new MenuItem("Ghost",ghost) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()),"clothing","ghost");
                getClothing.onCloth(player);
                clothing.closeMenu(player);
            }
        };

        MenuItem Off = new MenuItem("Off",new ItemStack(Material.BARRIER)) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()),"clothing","off");

                player.getInventory().setHelmet(new ItemStack(Material.AIR));
                player.getInventory().setChestplate(new ItemStack(Material.AIR));
                player.getInventory().setLeggings(new ItemStack(Material.AIR));
                player.getInventory().setBoots(new ItemStack(Material.AIR));

                clothing.closeMenu(player);
            }
        };
        //Menu with Items
        clothing.addMenuItem(Black_Leather,0);
        clothing.addMenuItem(Gray_Leather,1);
        clothing.addMenuItem(White_Leather,2);
        clothing.addMenuItem(Red_Leather,3);
        clothing.addMenuItem(Green_Leather,4);
        clothing.addMenuItem(Blue_Leather,5);
        clothing.addMenuItem(Yellow_Leather,6);
        clothing.addMenuItem(Aqua_Leather,7);
        clothing.addMenuItem(Purple_Leather,8);
        clothing.addMenuItem(Orange_Leather,9);
        clothing.addMenuItem(Navy_Leather,10);
        clothing.addMenuItem(Olive_Leather,11);
        clothing.addMenuItem(Fuchsia_Leather,12);
        clothing.addMenuItem(Maroon_Leather,13);
        clothing.addMenuItem(Silver_Leather,14);
        clothing.addMenuItem(Teal_Leather,15);
        clothing.addMenuItem(King,0,2);
        clothing.addMenuItem(Thief,1,2);
        clothing.addMenuItem(Slime,2,2);
        clothing.addMenuItem(Ghost,3,2);
        clothing.addMenuItem(Off,26);

        PopupMenuAPI.switchMenu(p,old,clothing);
    }
}
