package IMLobby;

import IMLobby.Druckplatten.Druckplatten_Bonus;
import IMLobby.Druckplatten.Druckplatten_Tp;
import IMLobby.LobbyExtras.Partikel;
import IMLobby.Schilder.Schilder_LobbyTp;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {

    @Override
    public void onEnable() {
        super.onEnable();
        registerListener();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    public void registerListener() {
        Bukkit.getPluginManager().registerEvents(new Druckplatten_Bonus(),this);
        Bukkit.getPluginManager().registerEvents(new Partikel(),this);
        Bukkit.getPluginManager().registerEvents(new Druckplatten_Tp(),this);
        Bukkit.getPluginManager().registerEvents(new Schilder_LobbyTp(),this);
    }
}
