package de.MangoleHD.IMLobby.StartInventory;

import de.Iclipse.IMAPI.Util.SkullUtils;
import de.MangoleHD.IMLobby.Data;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;

public class StartInventoryItems {

    public static ItemStack getCompass(Player p) {
        ItemStack compass = new ItemStack(Material.COMPASS);
        ItemMeta comp = compass.getItemMeta();
        System.out.println("Wird ausgeführt!");
        String displayname = Data.dsp.get("startinventory.name.teleporter", p);
        comp.setDisplayName(displayname);
        comp.setLore(Arrays.asList(new String[]{Data.dsp.get("startinventory.lore.teleporter", p)}));
        compass.setItemMeta(comp);
        return compass;
    }

    public static ItemStack getProfile(Player p) {
        ItemStack profile = SkullUtils.getPlayerSkull(p);
        SkullMeta meta = (SkullMeta) profile.getItemMeta();
        meta.setDisplayName(Data.dsp.get("startinventory.name.profile", p));
        meta.setLore(Arrays.asList(new String[]{Data.dsp.get("startinventory.lore.profile", p)}));
        profile.setItemMeta(meta);
        return profile;
    }

    public static ItemStack getPearl(Player p) {
        ItemStack enderpearl = new ItemStack(Material.ENDER_PEARL);
        ItemMeta ender = enderpearl.getItemMeta();
        ender.setDisplayName(Data.dsp.get("startinventory.name.beam", p));
        ender.setLore(Arrays.asList(new String[]{Data.dsp.get("startinventory.lore.beam", p)}));
        enderpearl.setItemMeta(ender);
        return enderpearl;
    }

    public static ItemStack getVisibility(Player p) {
        ItemStack visibility = new ItemStack(Material.LIME_DYE);
        ItemMeta visimeta = visibility.getItemMeta();
        visimeta.setDisplayName(Data.dsp.get("startinventory.name.visibility", p));
        visimeta.setLore(Arrays.asList(new String[]{Data.dsp.get("startinventory.lore.visibility", p)}));
        visibility.setItemMeta(visimeta);
        return visibility;
    }
}
