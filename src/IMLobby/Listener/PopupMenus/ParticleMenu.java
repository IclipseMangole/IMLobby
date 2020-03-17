package IMLobby.Listener.PopupMenus;

import de.Iclipse.IMAPI.Functions.MySQL.MySQL_UserSettings;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.Iclipse.IMAPI.Util.menu.MenuItem;
import de.Iclipse.IMAPI.Util.menu.PopupMenuAPI;
import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ParticleMenu {

    public static void openParticleMenu(Player p, PopupMenu old){
        //Menu
        PopupMenu particles = new PopupMenu("Particles",1);
        //MenuItems
        MenuItem flames = new MenuItem("Flames", new ItemStack(Material.BLAZE_POWDER)) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()),"particles","flames");
                player.sendMessage("§6Verbrenne dich nicht!");

                particles.closeMenu(player);
            }
        };

        MenuItem water = new MenuItem("Water", new ItemStack(Material.WATER_BUCKET)) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()),"particles","water");
                player.sendMessage("§bDu möchtest nasse Füße haben? Von mir aus.");

                particles.closeMenu(player);
            }
        };

        MenuItem lava = new MenuItem("Lava", new ItemStack(Material.LAVA_BUCKET)) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()),"particles","lava");
                player.sendMessage("§cHEIß, HEIß, HEIß!!!");

                particles.closeMenu(player);
            }
        };

        MenuItem love = new MenuItem("Love", new ItemStack(Material.POPPY)) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()),"particles","love");
                player.sendMessage("§dDu bist ja richtig sexy heute...");

                particles.closeMenu(player);
            }
        };

        MenuItem music = new MenuItem("Music", new ItemStack(Material.NOTE_BLOCK)) {
            @Override
            public void onClick(Player player) {

            }
        };

        MenuItem off = new MenuItem("Off", new ItemStack(Material.BARRIER)) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()),"particles","off");

                particles.closeMenu(player);
            }
        };

        //Menu with Items
        particles.addMenuItem(flames,0);
        particles.addMenuItem(water,1);
        particles.addMenuItem(lava,2);
        particles.addMenuItem(love,3);
        particles.addMenuItem(off,8);

        PopupMenuAPI.switchMenu(p,old,particles);
    }
}
