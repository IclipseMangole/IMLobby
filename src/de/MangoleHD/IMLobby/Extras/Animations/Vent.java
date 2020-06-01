package de.MangoleHD.IMLobby.Extras.Animations;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.ArrayList;

public class Vent {

    public static void createVents() {
        ArrayList<Location> animations = new ArrayList<>();
        animations.add(new Location(Bukkit.getWorld("world"), 95, 2, 14));
        animations.add(new Location(Bukkit.getWorld("world"), 104, 2, 14));
        animations.add(new Location(Bukkit.getWorld("world"), 111, 2, 14));


        ArrayList<Location> vents = new ArrayList<>();
        vents.add(new Location(Bukkit.getWorld("world"), -49, 80, -69));
        vents.add(new Location(Bukkit.getWorld("world"), -55, 73, -102));
        vents.add(new Location(Bukkit.getWorld("world"), -55, 79, -140));
        vents.add(new Location(Bukkit.getWorld("world"), -41, 68, -168));
        vents.add(new Location(Bukkit.getWorld("world"), -26, 79, -144));
        vents.add(new Location(Bukkit.getWorld("world"), 29, 76, -151));

        new Animation(6, 6, 8, true, animations, vents);
    }


}
