package de.MangoleHD.IMLobby.Extras.Animations;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.ArrayList;

public class Flag {


    public static void createFlags() {
        ArrayList<Location> animations = new ArrayList<>();
        animations.add(new Location(Bukkit.getWorld("world"), 66, 2, -17));
        animations.add(new Location(Bukkit.getWorld("world"), 73, 2, -17));
        animations.add(new Location(Bukkit.getWorld("world"), 80, 2, -17));

        ArrayList<Location> flags = new ArrayList<>();
        flags.add(new Location(Bukkit.getWorld("world"), -23, 78, -108));
        flags.add(new Location(Bukkit.getWorld("world"), -23, 78, -125));
        flags.add(new Location(Bukkit.getWorld("world"), 28, 86, -72));


        new Animation(4, 3, 11, false, animations, flags);
    }
}
