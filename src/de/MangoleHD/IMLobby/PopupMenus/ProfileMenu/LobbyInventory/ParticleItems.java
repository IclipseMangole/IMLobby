package de.MangoleHD.IMLobby.PopupMenus.ProfileMenu.LobbyInventory;

import de.Iclipse.IMAPI.Database.UserSettings;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.Iclipse.IMAPI.Util.menu.MenuItem;
import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import de.MangoleHD.IMLobby.Data;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ParticleItems {
    public static MenuItem flamesItem(Player p, PopupMenu last) {
        ItemStack item = new ItemStack(Material.BLAZE_POWDER);
        if (UserSettings.getString(UUIDFetcher.getUUID(p.getName()), "particles").equals("flames")) {
            item.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }
        MenuItem menuItem = new MenuItem(Data.dsp.get("particle.flames", p), item) {
            @Override
            public void onClick(Player player) {
                UserSettings.setString(UUIDFetcher.getUUID(player.getName()), "particles", "flames");
                Data.dsp.send(player, "particle.flames.text");

                ParticleMenu.openParticleMenu(p, last);
            }
        };
        menuItem.setLore(Data.dsp.get("particle.flames.lore", p));
        return menuItem;
    }

    public static MenuItem waterItem(Player p, PopupMenu last) {
        ItemStack item = new ItemStack(Material.WATER_BUCKET);
        if (UserSettings.getString(UUIDFetcher.getUUID(p.getName()), "particles").equals("water")) {
            item.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }
        MenuItem menuItem = new MenuItem(Data.dsp.get("particle.water", p), item) {
            @Override
            public void onClick(Player player) {
                UserSettings.setString(UUIDFetcher.getUUID(player.getName()), "particles", "water");
                Data.dsp.send(player, "particle.water.text");

                ParticleMenu.openParticleMenu(p, last);
            }
        };
        menuItem.setLore(Data.dsp.get("particle.water.lore", p));
        return menuItem;
    }

    public static MenuItem lavaItem(Player p, PopupMenu last) {
        ItemStack item = new ItemStack(Material.LAVA_BUCKET);
        if (UserSettings.getString(UUIDFetcher.getUUID(p.getName()), "particles").equals("lava")) {
            item.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }
        MenuItem menuItem = new MenuItem(Data.dsp.get("particle.lava", p), item) {
            @Override
            public void onClick(Player player) {
                UserSettings.setString(UUIDFetcher.getUUID(player.getName()), "particles", "lava");
                Data.dsp.send(player, "particle.lava.text");

                ParticleMenu.openParticleMenu(p, last);
            }
        };
        menuItem.setLore(Data.dsp.get("particle.lava.lore", p));
        return menuItem;
    }

    public static MenuItem loveItem(Player p, PopupMenu last) {
        ItemStack item = new ItemStack(Material.POPPY);
        if (UserSettings.getString(UUIDFetcher.getUUID(p.getName()), "particles").equals("love")) {
            item.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }
        MenuItem menuItem = new MenuItem(Data.dsp.get("particle.love", p), item) {
            @Override
            public void onClick(Player player) {
                UserSettings.setString(UUIDFetcher.getUUID(player.getName()), "particles", "love");
                Data.dsp.send(player, "particle.love.text");
                ParticleMenu.openParticleMenu(p, last);
            }
        };
        menuItem.setLore(Data.dsp.get("particle.love.lore", p));
        return menuItem;
    }

    public static MenuItem musicItem(Player p, PopupMenu last) {
        ItemStack item = new ItemStack(Material.JUKEBOX);
        if (UserSettings.getString(UUIDFetcher.getUUID(p.getName()), "particles").equals("music")) {
            item.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }
        MenuItem menuItem = new MenuItem(Data.dsp.get("particle.music", p), item) {
            @Override
            public void onClick(Player player) {
                UserSettings.setString(UUIDFetcher.getUUID(player.getName()), "particles", "music");
                Data.dsp.send(player, "particle.music.text");
                ParticleMenu.openParticleMenu(p, last);
            }
        };
        menuItem.setLore(Data.dsp.get("particle.music.lore", p));
        return menuItem;
    }

    public static MenuItem boomItem(Player p, PopupMenu last) {
        ItemStack item = new ItemStack(Material.TNT);
        if (UserSettings.getString(UUIDFetcher.getUUID(p.getName()), "particles").equals("boom")) {
            item.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }
        MenuItem menuItem = new MenuItem(Data.dsp.get("particle.boom", p), item) {
            @Override
            public void onClick(Player player) {
                UserSettings.setString(UUIDFetcher.getUUID(player.getName()), "particles", "boom");
                Data.dsp.send(player, "particle.boom.text");
                ParticleMenu.openParticleMenu(p, last);
            }
        };
        menuItem.setLore(Data.dsp.get("particle.boom.lore", p));
        return menuItem;
    }

    public static MenuItem smokeItem(Player p, PopupMenu last) {
        ItemStack item = new ItemStack(Material.BONE_MEAL);
        if (UserSettings.getString(UUIDFetcher.getUUID(p.getName()), "particles").equals("smoke")) {
            item.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }
        MenuItem menuItem = new MenuItem(Data.dsp.get("particle.smoke", p), item) {
            @Override
            public void onClick(Player player) {
                UserSettings.setString(UUIDFetcher.getUUID(player.getName()), "particles", "smoke");
                Data.dsp.send(player, "particle.smoke.text");
                ParticleMenu.openParticleMenu(p, last);
            }
        };
        menuItem.setLore(Data.dsp.get("particle.smoke.lore", p));
        return menuItem;
    }

    public static MenuItem slimeItem(Player p, PopupMenu last) {
        ItemStack item = new ItemStack(Material.SLIME_BALL);
        if (UserSettings.getString(UUIDFetcher.getUUID(p.getName()), "particles").equals("slime")) {
            item.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }
        MenuItem menuItem = new MenuItem(Data.dsp.get("particle.slime", p), item) {
            @Override
            public void onClick(Player player) {
                UserSettings.setString(UUIDFetcher.getUUID(player.getName()), "particles", "slime");
                Data.dsp.send(player, "particle.slime.text");
                ParticleMenu.openParticleMenu(p, last);
            }
        };
        menuItem.setLore(Data.dsp.get("particle.slime.lore", p));
        return menuItem;
    }

    public static MenuItem offItem(Player p, PopupMenu last) {
        ItemStack item = new ItemStack(Material.BARRIER);
        if (UserSettings.getString(UUIDFetcher.getUUID(p.getName()), "particles").equals("off")) {
            item.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }
        MenuItem menuItem = new MenuItem(Data.dsp.get("particle.off", p), item) {
            @Override
            public void onClick(Player player) {
                UserSettings.setString(UUIDFetcher.getUUID(player.getName()), "particles", "off");
                Data.dsp.send(player, "particle.off.text");
                ParticleMenu.openParticleMenu(p, last);
            }
        };
        menuItem.setLore(Data.dsp.get("particle.off.lore", p));
        return menuItem;
    }
}
