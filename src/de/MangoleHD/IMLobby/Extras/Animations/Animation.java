package de.MangoleHD.IMLobby.Extras.Animations;


import de.MangoleHD.IMLobby.Data;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

import java.util.*;

public class Animation {

    private int length;
    private int height;
    private int width;
    private boolean circle;
    private boolean forward;
    private ArrayList<ArrayList<Material>> animationBlocks;
    private HashMap<Location, Integer> projections;

    public Animation(int length, int height, int width, boolean circle, ArrayList<Location> animations, ArrayList<Location> projections) {
        Random random = new Random();
        this.height = height;
        this.width = width;
        this.length = length;
        this.circle = circle;
        forward = true;
        animationBlocks = new ArrayList<>();
        this.projections = new HashMap<>();

        animations.forEach(location -> {
            ArrayList<Material> blocks = new ArrayList<>();

            for (int x = 0; x < length; x++) {
                for (int y = 0; y < height; y++) {
                    for (int z = 0; z < width; z++) {
                        Block change = location.getWorld().getBlockAt(location.getBlockX() + x, location.getBlockY() + y, location.getBlockZ() + z);
                        blocks.add(change.getType());
                    }
                }
            }
            animationBlocks.add(blocks);
        });

        projections.forEach(loc -> {
            this.projections.put(loc, random.nextInt(animations.size()));
        });


        Data.animations.add(this);
    }

    public void update() {
        Iterator it = projections.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry item = (Map.Entry) it.next();
            Location location = (Location) item.getKey();
            int animation = (int) item.getValue();

            ArrayList<Material> blocks = animationBlocks.get(animation);

            for (int z = 0; z < width; z++) {
                for (int x = 0; x < length; x++) {
                    for (int y = 0; y < height; y++) {
                        Block block = location.getWorld().getBlockAt(location.getBlockX() + x, location.getBlockY() + y, location.getBlockZ() + z);
                        block.setType(blocks.get((x * (height * width)) + (y * width) + z));
                    }
                }
            }

            if (circle) {
                projections.replace(location, (animation + 1) % animationBlocks.size());
            } else {
                if (forward) {
                    if (animation >= animationBlocks.size() - 1) {
                        forward = false;
                        projections.replace(location, animation - 1);
                    } else {
                        projections.replace(location, animation + 1);
                    }
                } else {
                    if (animation <= 0) {
                        forward = true;
                        projections.replace(location, animation + 1);
                    } else {
                        projections.replace(location, animation - 1);
                    }
                }
            }
        }
    }
}
