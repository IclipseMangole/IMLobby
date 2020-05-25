package de.MangoleHD.IMLobby;


import de.Iclipse.IMAPI.Util.Dispatching.Dispatcher;
import de.MangoleHD.IMLobby.Extras.Animations.Animation;
import de.MangoleHD.IMLobby.Extras.Broadcasts.BossBar;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class Data {
    public static Plugin instance;
    public static BossBar bossBar;
    public static String symbol = "§8 » §7";
    public static String prefix = "§5IMLobby" + symbol;
    public static HashMap<Player, Integer> doublejump = new HashMap<>();
    public static ArrayList<Player> ghost = new ArrayList<>();
    public static HashMap<Player, Integer> sneakjumper = new HashMap<>();
    public static ArrayList<Animation> animations = new ArrayList<>();
    public static Dispatcher dsp;
    public static ResourceBundle langDE;
    public static ResourceBundle langEN;
    public static Location spawn;
    public static boolean killlag = false;

    //MiniArena
    public static ArrayList<Player> waiting = new ArrayList<>();
    public static ArrayList<Player> fighting = new ArrayList<>();
    public static int arenaCountdown = 0;
    public static ArrayList<Block> placed = new ArrayList<>();
}
