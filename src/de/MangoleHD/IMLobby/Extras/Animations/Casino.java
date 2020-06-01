package de.MangoleHD.IMLobby.Extras.Animations;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.ArrayList;

public class Casino {


    public static void createCasinos() {
        ArrayList<Location> animations = new ArrayList<>();
        animations.add(new Location(Bukkit.getWorld("world"), 147, 2, -28));
        animations.add(new Location(Bukkit.getWorld("world"), 142, 2, -28));
        animations.add(new Location(Bukkit.getWorld("world"), 137, 2, -28));
        animations.add(new Location(Bukkit.getWorld("world"), 132, 2, -28));
        animations.add(new Location(Bukkit.getWorld("world"), 127, 2, -28));
        animations.add(new Location(Bukkit.getWorld("world"), 122, 2, -28));
        animations.add(new Location(Bukkit.getWorld("world"), 117, 2, -28));
        animations.add(new Location(Bukkit.getWorld("world"), 112, 2, -28));
        animations.add(new Location(Bukkit.getWorld("world"), 107, 2, -28));
        animations.add(new Location(Bukkit.getWorld("world"), 102, 2, -28));
        animations.add(new Location(Bukkit.getWorld("world"), 97, 2, -28));
        animations.add(new Location(Bukkit.getWorld("world"), 92, 2, -28));


        ArrayList<Location> casinos = new ArrayList<>();
        casinos.add(new Location(Bukkit.getWorld("world"), -21, 64, -87));

        new Animation(3, 9, 25, true, animations, casinos);
    }
}
