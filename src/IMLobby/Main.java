package IMLobby;


import IMLobby.Listener.StartInventoryListener;
import IMLobby.Listener.JoinListener;
import IMLobby.Listener.ParticleListener;
import IMLobby.Listener.SchadenListener;
import IMLobby.Commands.cmd_startInventory;
import IMLobby.Data;

import de.Iclipse.IMAPI.Functions.Listener.QuitListener;
import de.Iclipse.IMAPI.Util.Dispatching.Dispatcher;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import static IMLobby.Data.dsp;
import static de.Iclipse.IMAPI.IMAPI.register;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        super.onEnable();
        registerListener();
        registerCommands();
        createTables();
        Data.tablist = new Tablist();
        dsp = new Dispatcher(this);
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    public void registerListener() {
        Bukkit.getPluginManager().registerEvents(new ParticleListener(),this);
        Bukkit.getPluginManager().registerEvents(new JoinListener(),this);
        Bukkit.getPluginManager().registerEvents(new SchadenListener(),this);
        Bukkit.getPluginManager().registerEvents(new StartInventoryListener(),this);
        Bukkit.getPluginManager().registerEvents(new QuitListener(),this);
    }

    public void registerCommands() {
        register(new cmd_startInventory(), this);
    }

    public void createTables() {

    }
}
