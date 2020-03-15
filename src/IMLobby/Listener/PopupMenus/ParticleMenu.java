package IMLobby.Listener.PopupMenus;

import IMLobby.MySQL.MySQL_LobbySettings;
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
        MenuItem flame = new MenuItem("Flames", new ItemStack(Material.BLAZE_POWDER)) {
            @Override
            public void onClick(Player player) {
                MySQL_LobbySettings.setParticles(UUIDFetcher.getUUID(player.getName()), "Flames");
                player.sendMessage("Verbrenne dich nicht!");
            }
        };

        MenuItem water = new MenuItem("Water", new ItemStack(Material.WATER_BUCKET)) {
            @Override
            public void onClick(Player player) {
                MySQL_LobbySettings.setParticles(UUIDFetcher.getUUID(player.getName()), "Water");
                player.sendMessage("Du magst nasse Füße haben? Von mir aus.");
            }
        };

        MenuItem lava = new MenuItem("Lava", new ItemStack(Material.LAVA_BUCKET)) {
            @Override
            public void onClick(Player player) {
                MySQL_LobbySettings.setParticles(UUIDFetcher.getUUID(player.getName()), "Lava");
                player.sendMessage("HEIß, HEIß, HEIß!!!");
            }
        };

        MenuItem love = new MenuItem("Love", new ItemStack(Material.POPPY)) {
            @Override
            public void onClick(Player player) {
                MySQL_LobbySettings.setParticles(UUIDFetcher.getUUID(player.getName()), "Love");
                player.sendMessage("Du bist ja richtig sexy heute...");
            }
        };
        //Menu with Items
        particles.addMenuItem(flame,  0);
        particles.addMenuItem(water, 1);
        particles.addMenuItem(lava,2);
        particles.addMenuItem(love,3);

        PopupMenuAPI.switchMenu(p,old,particles);
    }
}
