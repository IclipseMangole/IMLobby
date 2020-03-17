package IMLobby.Listener.PopupMenus;

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

                ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
                ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);

                LeatherArmorMeta h = (LeatherArmorMeta) helmet.getItemMeta();
                LeatherArmorMeta c = (LeatherArmorMeta) chest.getItemMeta();
                LeatherArmorMeta l = (LeatherArmorMeta) leggings.getItemMeta();
                LeatherArmorMeta b = (LeatherArmorMeta) boots.getItemMeta();

                h.setColor(Color.BLACK);
                c.setColor(Color.BLACK);
                l.setColor(Color.BLACK);
                b.setColor(Color.BLACK);

                helmet.setItemMeta(h);
                chest.setItemMeta(c);
                leggings.setItemMeta(l);
                boots.setItemMeta(b);

                player.getInventory().setHelmet(helmet);
                player.getInventory().setChestplate(chest);
                player.getInventory().setLeggings(leggings);
                player.getInventory().setBoots(boots);

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

                ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
                ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);

                LeatherArmorMeta h = (LeatherArmorMeta) helmet.getItemMeta();
                LeatherArmorMeta c = (LeatherArmorMeta) chest.getItemMeta();
                LeatherArmorMeta l = (LeatherArmorMeta) leggings.getItemMeta();
                LeatherArmorMeta b = (LeatherArmorMeta) boots.getItemMeta();

                h.setColor(Color.GRAY);
                c.setColor(Color.GRAY);
                l.setColor(Color.GRAY);
                b.setColor(Color.GRAY);

                helmet.setItemMeta(h);
                chest.setItemMeta(c);
                leggings.setItemMeta(l);
                boots.setItemMeta(b);

                player.getInventory().setHelmet(helmet);
                player.getInventory().setChestplate(chest);
                player.getInventory().setLeggings(leggings);
                player.getInventory().setBoots(boots);

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

                ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
                ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);

                LeatherArmorMeta h = (LeatherArmorMeta) helmet.getItemMeta();
                LeatherArmorMeta c = (LeatherArmorMeta) chest.getItemMeta();
                LeatherArmorMeta l = (LeatherArmorMeta) leggings.getItemMeta();
                LeatherArmorMeta b = (LeatherArmorMeta) boots.getItemMeta();

                h.setColor(Color.WHITE);
                c.setColor(Color.WHITE);
                l.setColor(Color.WHITE);
                b.setColor(Color.WHITE);

                helmet.setItemMeta(h);
                chest.setItemMeta(c);
                leggings.setItemMeta(l);
                boots.setItemMeta(b);

                player.getInventory().setHelmet(helmet);
                player.getInventory().setChestplate(chest);
                player.getInventory().setLeggings(leggings);
                player.getInventory().setBoots(boots);

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

                ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
                ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);

                LeatherArmorMeta h = (LeatherArmorMeta) helmet.getItemMeta();
                LeatherArmorMeta c = (LeatherArmorMeta) chest.getItemMeta();
                LeatherArmorMeta l = (LeatherArmorMeta) leggings.getItemMeta();
                LeatherArmorMeta b = (LeatherArmorMeta) boots.getItemMeta();

                h.setColor(Color.RED);
                c.setColor(Color.RED);
                l.setColor(Color.RED);
                b.setColor(Color.RED);

                helmet.setItemMeta(h);
                chest.setItemMeta(c);
                leggings.setItemMeta(l);
                boots.setItemMeta(b);

                player.getInventory().setHelmet(helmet);
                player.getInventory().setChestplate(chest);
                player.getInventory().setLeggings(leggings);
                player.getInventory().setBoots(boots);

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

                ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
                ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);

                LeatherArmorMeta h = (LeatherArmorMeta) helmet.getItemMeta();
                LeatherArmorMeta c = (LeatherArmorMeta) chest.getItemMeta();
                LeatherArmorMeta l = (LeatherArmorMeta) leggings.getItemMeta();
                LeatherArmorMeta b = (LeatherArmorMeta) boots.getItemMeta();

                h.setColor(Color.BLUE);
                c.setColor(Color.BLUE);
                l.setColor(Color.BLUE);
                b.setColor(Color.BLUE);

                helmet.setItemMeta(h);
                chest.setItemMeta(c);
                leggings.setItemMeta(l);
                boots.setItemMeta(b);

                player.getInventory().setHelmet(helmet);
                player.getInventory().setChestplate(chest);
                player.getInventory().setLeggings(leggings);
                player.getInventory().setBoots(boots);

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

                ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
                ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);

                LeatherArmorMeta h = (LeatherArmorMeta) helmet.getItemMeta();
                LeatherArmorMeta c = (LeatherArmorMeta) chest.getItemMeta();
                LeatherArmorMeta l = (LeatherArmorMeta) leggings.getItemMeta();
                LeatherArmorMeta b = (LeatherArmorMeta) boots.getItemMeta();

                h.setColor(Color.GREEN);
                c.setColor(Color.GREEN);
                l.setColor(Color.GREEN);
                b.setColor(Color.GREEN);

                helmet.setItemMeta(h);
                chest.setItemMeta(c);
                leggings.setItemMeta(l);
                boots.setItemMeta(b);

                player.getInventory().setHelmet(helmet);
                player.getInventory().setChestplate(chest);
                player.getInventory().setLeggings(leggings);
                player.getInventory().setBoots(boots);

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

                ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
                ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);

                LeatherArmorMeta h = (LeatherArmorMeta) helmet.getItemMeta();
                LeatherArmorMeta c = (LeatherArmorMeta) chest.getItemMeta();
                LeatherArmorMeta l = (LeatherArmorMeta) leggings.getItemMeta();
                LeatherArmorMeta b = (LeatherArmorMeta) boots.getItemMeta();

                h.setColor(Color.PURPLE);
                c.setColor(Color.PURPLE);
                l.setColor(Color.PURPLE);
                b.setColor(Color.PURPLE);

                helmet.setItemMeta(h);
                chest.setItemMeta(c);
                leggings.setItemMeta(l);
                boots.setItemMeta(b);

                player.getInventory().setHelmet(helmet);
                player.getInventory().setChestplate(chest);
                player.getInventory().setLeggings(leggings);
                player.getInventory().setBoots(boots);

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

                ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
                ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);

                LeatherArmorMeta h = (LeatherArmorMeta) helmet.getItemMeta();
                LeatherArmorMeta c = (LeatherArmorMeta) chest.getItemMeta();
                LeatherArmorMeta l = (LeatherArmorMeta) leggings.getItemMeta();
                LeatherArmorMeta b = (LeatherArmorMeta) boots.getItemMeta();

                h.setColor(Color.AQUA);
                c.setColor(Color.AQUA);
                l.setColor(Color.AQUA);
                b.setColor(Color.AQUA);

                helmet.setItemMeta(h);
                chest.setItemMeta(c);
                leggings.setItemMeta(l);
                boots.setItemMeta(b);

                player.getInventory().setHelmet(helmet);
                player.getInventory().setChestplate(chest);
                player.getInventory().setLeggings(leggings);
                player.getInventory().setBoots(boots);

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

                ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
                ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);

                LeatherArmorMeta h = (LeatherArmorMeta) helmet.getItemMeta();
                LeatherArmorMeta c = (LeatherArmorMeta) chest.getItemMeta();
                LeatherArmorMeta l = (LeatherArmorMeta) leggings.getItemMeta();
                LeatherArmorMeta b = (LeatherArmorMeta) boots.getItemMeta();

                h.setColor(Color.ORANGE);
                c.setColor(Color.ORANGE);
                l.setColor(Color.ORANGE);
                b.setColor(Color.ORANGE);

                helmet.setItemMeta(h);
                chest.setItemMeta(c);
                leggings.setItemMeta(l);
                boots.setItemMeta(b);

                player.getInventory().setHelmet(helmet);
                player.getInventory().setChestplate(chest);
                player.getInventory().setLeggings(leggings);
                player.getInventory().setBoots(boots);

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

                ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
                ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);

                LeatherArmorMeta h = (LeatherArmorMeta) helmet.getItemMeta();
                LeatherArmorMeta c = (LeatherArmorMeta) chest.getItemMeta();
                LeatherArmorMeta l = (LeatherArmorMeta) leggings.getItemMeta();
                LeatherArmorMeta b = (LeatherArmorMeta) boots.getItemMeta();

                h.setColor(Color.YELLOW);
                c.setColor(Color.YELLOW);
                l.setColor(Color.YELLOW);
                b.setColor(Color.YELLOW);

                helmet.setItemMeta(h);
                chest.setItemMeta(c);
                leggings.setItemMeta(l);
                boots.setItemMeta(b);

                player.getInventory().setHelmet(helmet);
                player.getInventory().setChestplate(chest);
                player.getInventory().setLeggings(leggings);
                player.getInventory().setBoots(boots);

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

                ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
                ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);

                LeatherArmorMeta h = (LeatherArmorMeta) helmet.getItemMeta();
                LeatherArmorMeta c = (LeatherArmorMeta) chest.getItemMeta();
                LeatherArmorMeta l = (LeatherArmorMeta) leggings.getItemMeta();
                LeatherArmorMeta b = (LeatherArmorMeta) boots.getItemMeta();

                h.setColor(Color.OLIVE);
                c.setColor(Color.OLIVE);
                l.setColor(Color.OLIVE);
                b.setColor(Color.OLIVE);

                helmet.setItemMeta(h);
                chest.setItemMeta(c);
                leggings.setItemMeta(l);
                boots.setItemMeta(b);

                player.getInventory().setHelmet(helmet);
                player.getInventory().setChestplate(chest);
                player.getInventory().setLeggings(leggings);
                player.getInventory().setBoots(boots);

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

                ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
                ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);

                LeatherArmorMeta h = (LeatherArmorMeta) helmet.getItemMeta();
                LeatherArmorMeta c = (LeatherArmorMeta) chest.getItemMeta();
                LeatherArmorMeta l = (LeatherArmorMeta) leggings.getItemMeta();
                LeatherArmorMeta b = (LeatherArmorMeta) boots.getItemMeta();

                h.setColor(Color.NAVY);
                c.setColor(Color.NAVY);
                l.setColor(Color.NAVY);
                b.setColor(Color.NAVY);

                helmet.setItemMeta(h);
                chest.setItemMeta(c);
                leggings.setItemMeta(l);
                boots.setItemMeta(b);

                player.getInventory().setHelmet(helmet);
                player.getInventory().setChestplate(chest);
                player.getInventory().setLeggings(leggings);
                player.getInventory().setBoots(boots);

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
        clothing.addMenuItem(Off,26);


        PopupMenuAPI.switchMenu(p,old,clothing);
    }
}
