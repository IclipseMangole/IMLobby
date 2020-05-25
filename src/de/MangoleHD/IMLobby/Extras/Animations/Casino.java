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


        ArrayList<Location> casinos = new ArrayList<>();
        casinos.add(new Location(Bukkit.getWorld("world"), -21, 64, -87));

        new Animation(3, 9, 25, false, animations, casinos);
    }
}
