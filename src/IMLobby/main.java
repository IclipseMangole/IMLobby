package IMLobby;


import IMLobby.Listener.SettingsInventory;
import IMLobby.Listener.TeleporterInventory;
import IMLobby.Listener.JoinListener;
import IMLobby.Listener.ParticleListener;
import IMLobby.LobbyExtras.SchadenListener;
import IMLobby.Commands.cmd_startInventory;

import IMLobby.MySQL.MySQL_LobbySettings;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import static de.Iclipse.IMAPI.IMAPI.register;

public class main extends JavaPlugin {

    @Override
    public void onEnable() {
        super.onEnable();
        registerListener();
        registerCommands();
        createTables();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    public void registerListener() {
        Bukkit.getPluginManager().registerEvents(new ParticleListener(),this);
        Bukkit.getPluginManager().registerEvents(new JoinListener(),this);
        Bukkit.getPluginManager().registerEvents(new SchadenListener(),this);
        Bukkit.getPluginManager().registerEvents(new TeleporterInventory(),this);
        Bukkit.getPluginManager().registerEvents(new SettingsInventory(),this);
    }

    public void registerCommands() {
        register(new cmd_startInventory(), this);
    }

    public void createTables() {
        MySQL_LobbySettings.createLobbyTable();
    }
}
