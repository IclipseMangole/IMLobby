package IMLobby.Listener.PopupMenus;

import de.Iclipse.IMAPI.Functions.MySQL.MySQL_UserSettings;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.Iclipse.IMAPI.Util.menu.MenuItem;
import de.Iclipse.IMAPI.Util.menu.PopupMenuAPI;
import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import IMLobby.Data;

public class ParticleMenu {

    public static void openParticleMenu(Player p, PopupMenu old){
        //Menu
        PopupMenu particles = new PopupMenu("Particles",1);
        //MenuItems
        MenuItem flames = new MenuItem("Flames", new ItemStack(Material.BLAZE_POWDER)) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()),"particles","flames");
                Data.dsp.send(player,"clothing.lava");

                particles.closeMenu(player);
            }
        };

        MenuItem water = new MenuItem("Water", new ItemStack(Material.WATER_BUCKET)) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()),"particles","water");
                Data.dsp.send(player,"clothing.lava");

                particles.closeMenu(player);
            }
        };

        MenuItem lava = new MenuItem("Lava", new ItemStack(Material.LAVA_BUCKET)) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()),"particles","lava");
                Data.dsp.send(player,"clothing.lava");

                particles.closeMenu(player);
            }
        };

        MenuItem love = new MenuItem("Love", new ItemStack(Material.POPPY)) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()),"particles","love");
                Data.dsp.send(player,"clothing.lava");
                particles.closeMenu(player);
            }
        };

        MenuItem music = new MenuItem("Music", new ItemStack(Material.JUKEBOX)) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()),"particles","music");
                Data.dsp.send(player,"clothing.lava");
                particles.closeMenu(player);
            }
        };

        MenuItem boom = new MenuItem("BOOM", new ItemStack(Material.TNT)) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()),"particles","boom");
                Data.dsp.send(player,"clothing.lava");
                particles.closeMenu(player);
            }
        };

        MenuItem smoke = new MenuItem("Smoke", new ItemStack(Material.BONE_MEAL)) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()),"particles","smoke");
                Data.dsp.send(player,"clothing.lava");
                particles.closeMenu(player);
            }
        };

        MenuItem slime = new MenuItem("Slime", new ItemStack(Material.SLIME_BALL)) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()),"particles","slime");
                Data.dsp.send(player,"clothing.lava");
                particles.closeMenu(player);
            }
        };

        MenuItem off = new MenuItem("Off", new ItemStack(Material.BARRIER)) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()),"particles","off");
                Data.dsp.send(player,"clothing.lava");
                particles.closeMenu(player);
            }
        };

        //Menu with Items
        particles.addMenuItem(flames,0);
        particles.addMenuItem(water,1);
        particles.addMenuItem(lava,2);
        particles.addMenuItem(love,3);
        particles.addMenuItem(music,4);
        particles.addMenuItem(boom,5);
        particles.addMenuItem(smoke,6);
        particles.addMenuItem(slime,7);
        particles.addMenuItem(off,8);

        PopupMenuAPI.switchMenu(p,old,particles);
    }
}
