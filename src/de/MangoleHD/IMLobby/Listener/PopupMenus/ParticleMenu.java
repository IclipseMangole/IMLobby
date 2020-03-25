package de.MangoleHD.IMLobby.Listener.PopupMenus;

import de.Iclipse.IMAPI.Functions.MySQL.MySQL_UserSettings;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.Iclipse.IMAPI.Util.menu.MenuItem;
import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import de.Iclipse.IMAPI.Util.menu.PopupMenuAPI;
import de.MangoleHD.IMLobby.Data;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ParticleMenu {

    public static void openParticleMenu(Player p, PopupMenu old) {
        //Menu
        PopupMenu particles = new PopupMenu(Data.dsp.get("particle.menu", p), 1);
        //MenuItems
        MenuItem flames = new MenuItem(Data.dsp.get("particle.flames", p), new ItemStack(Material.BLAZE_POWDER)) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()), "particles", "flames");
                Data.dsp.send(player, "particle.flames.text");

                particles.closeMenu(player);
            }
        };
        flames.setLore(Data.dsp.get("particle.flames.lore", p));

        MenuItem water = new MenuItem(Data.dsp.get("particle.water", p), new ItemStack(Material.WATER_BUCKET)) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()), "particles", "water");
                Data.dsp.send(player, "particle.water.text");

                particles.closeMenu(player);
            }
        };
        water.setLore(Data.dsp.get("particle.water.lore", p));

        MenuItem lava = new MenuItem(Data.dsp.get("particle.lava", p), new ItemStack(Material.LAVA_BUCKET)) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()), "particles", "lava");
                Data.dsp.send(player, "particle.lava.text");

                particles.closeMenu(player);
            }
        };
        lava.setLore(Data.dsp.get("particle.lava.lore", p));

        MenuItem love = new MenuItem(Data.dsp.get("particle.love", p), new ItemStack(Material.POPPY)) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()), "particles", "love");
                Data.dsp.send(player, "particle.love.text");
                particles.closeMenu(player);
            }
        };
        love.setLore(Data.dsp.get("particle.love.lore", p));

        MenuItem music = new MenuItem(Data.dsp.get("particle.music", p), new ItemStack(Material.JUKEBOX)) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()), "particles", "music");
                Data.dsp.send(player, "particle.music.text");
                particles.closeMenu(player);
            }
        };
        music.setLore(Data.dsp.get("particle.music.lore", p));

        MenuItem boom = new MenuItem(Data.dsp.get("particle.boom", p), new ItemStack(Material.TNT)) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()), "particles", "boom");
                Data.dsp.send(player, "particle.boom.text");
                particles.closeMenu(player);
            }
        };
        boom.setLore(Data.dsp.get("particle.boom.lore", p));

        MenuItem smoke = new MenuItem(Data.dsp.get("particle.smoke", p), new ItemStack(Material.BONE_MEAL)) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()), "particles", "smoke");
                Data.dsp.send(player, "particle.smoke.text");
                particles.closeMenu(player);
            }
        };
        smoke.setLore(Data.dsp.get("particle.smoke.lore", p));

        MenuItem slime = new MenuItem(Data.dsp.get("particle.slime", p), new ItemStack(Material.SLIME_BALL)) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()), "particles", "slime");
                Data.dsp.send(player, "particle.slime.text");
                particles.closeMenu(player);
            }
        };
        slime.setLore(Data.dsp.get("particle.slime.lore", p));

        MenuItem off = new MenuItem(Data.dsp.get("particle.off", p), new ItemStack(Material.BARRIER)) {
            @Override
            public void onClick(Player player) {
                MySQL_UserSettings.setString(UUIDFetcher.getUUID(player.getName()), "particles", "off");
                Data.dsp.send(player, "particle.off.text");
                particles.closeMenu(player);
            }
        };
        off.setLore(Data.dsp.get("particle.off.lore", p));

        //Menu with Items
        particles.addMenuItem(flames, 0);
        particles.addMenuItem(water, 1);
        particles.addMenuItem(lava, 2);
        particles.addMenuItem(love, 3);
        particles.addMenuItem(music, 4);
        particles.addMenuItem(boom, 5);
        particles.addMenuItem(smoke, 6);
        particles.addMenuItem(slime, 7);
        particles.addMenuItem(off, 8);

        PopupMenuAPI.switchMenu(p, old, particles);
    }
}
