package IMLobby;


import de.Iclipse.IMAPI.Util.Dispatching.Dispatcher;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;

public class Data {
    public static Plugin instance;
    public static HashMap <String, Long> enderCooldown = new HashMap<>();
    public static Tablist tablist;
    public static String symbol = "§8 » §7";
    public static String prefix = "§5IM" + symbol;
    public static Dispatcher dsp;
}
