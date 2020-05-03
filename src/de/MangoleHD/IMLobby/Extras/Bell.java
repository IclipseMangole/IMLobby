package de.MangoleHD.IMLobby.Extras;

import de.MangoleHD.IMLobby.Data;
import net.minecraft.server.v1_15_R1.BlockPosition;
import net.minecraft.server.v1_15_R1.Blocks;
import net.minecraft.server.v1_15_R1.PacketPlayOutBlockAction;
import net.minecraft.server.v1_15_R1.PlayerConnection;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Directional;
import org.bukkit.craftbukkit.v1_15_R1.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Bell {
    private static int minutesdiv15 = 0;
    private static ArrayList<Location> bells;

    public static void bell() {
        int minutes = LocalDateTime.now().getMinute();
        if (minutes / 15 != minutesdiv15) {
            minutesdiv15 = minutes / 15;
            int gongs;
            switch (minutesdiv15) {
                case 0:
                    gongs = 8;
                    break;
                case 2:
                    gongs = 4;
                    break;
                default:
                    gongs = 2;
            }

            for (int i = 0; i < gongs; i++) {
                Bukkit.getScheduler().runTaskLater(Data.instance, () -> {
                    bells.forEach(b -> playBellEffect(b));
                }, i * 40);
            }
        }
    }

    public static void createBells() {
        bells = new ArrayList<>();
        bells.add(new Location(Bukkit.getWorld("world"), -13, 68, -127));
    }

    private static void playBellEffect(Location loc) {
        Block block = loc.getBlock();
        World world = block.getWorld();
        world.playSound(block.getLocation(), Sound.BLOCK_BELL_USE, 10.0f, 0.5f);
        byte face = 2;
        BlockFace facing = ((Directional) block.getBlockData()).getFacing();
        if (facing == BlockFace.NORTH) {
            face = 2;
        } else if (facing == BlockFace.SOUTH) {
            face = 3;
        } else if (facing == BlockFace.WEST) {
            face = 4;
        } else if (facing == BlockFace.EAST) {
            face = 5;
        }
        BlockPosition position = new BlockPosition(block.getX(), block.getY(), block.getZ());
        for (Entity entity : world.getNearbyEntities(block.getLocation(), 32, 32, 32)) {
            if (entity instanceof Player) {
                PlayerConnection connection = ((CraftPlayer) entity).getHandle().playerConnection;
                connection.sendPacket(new PacketPlayOutBlockAction(position, Blocks.BELL, 1, face));
            }
        }
    }
}
