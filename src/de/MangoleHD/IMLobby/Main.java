package de.MangoleHD.IMLobby;


import de.MangoleHD.IMLobby.Commands.cmd_startInventory;

import de.Iclipse.IMAPI.Functions.Listener.QuitListener;
import de.Iclipse.IMAPI.IMAPI;
import de.Iclipse.IMAPI.Util.Dispatching.Dispatcher;
import de.Iclipse.IMAPI.Util.Dispatching.Language;
import de.MangoleHD.IMLobby.Listener.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import static de.Iclipse.IMAPI.Util.Dispatching.ResourceBundle.*;
import static de.Iclipse.IMAPI.Util.Dispatching.ResourceBundle.msgEN;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        super.onEnable();
        registerListener();
        registerCommands();
        createTables();
        Data.tablist = new Tablist();
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
        Bukkit.getPluginManager().registerEvents(new ClothingListener(),this);
    }

    public void registerCommands() {
        IMAPI.register(new cmd_startInventory(), this);
    }

    public void createTables() {

    }

}
