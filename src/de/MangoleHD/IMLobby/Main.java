package de.MangoleHD.IMLobby;

import de.Iclipse.IMAPI.Database.Server;
import de.Iclipse.IMAPI.Functions.Servers.State;
import de.Iclipse.IMAPI.IMAPI;
import de.Iclipse.IMAPI.Util.Dispatching.Dispatcher;
import de.MangoleHD.IMLobby.Commands.cmd_killlag;
import de.MangoleHD.IMLobby.Commands.cmd_miniArena;
import de.MangoleHD.IMLobby.Commands.cmd_startInventory;
import de.MangoleHD.IMLobby.Extras.Animations.Flag;
import de.MangoleHD.IMLobby.Extras.Animations.Grave;
import de.MangoleHD.IMLobby.Extras.Animations.Vent;
import de.MangoleHD.IMLobby.Extras.Animations.Windmill;
import de.MangoleHD.IMLobby.Extras.Bell;
import de.MangoleHD.IMLobby.Extras.GroßesDorfhaus;
import de.MangoleHD.IMLobby.Extras.Minigames.MiniArena;
import de.MangoleHD.IMLobby.Extras.SignSystem.SignClick;
import de.MangoleHD.IMLobby.Extras.Treppe;
import de.MangoleHD.IMLobby.Listener.*;
import de.MangoleHD.IMLobby.Scheduler.Scheduler;
import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import static de.Iclipse.IMAPI.IMAPI.copyFilesInDirectory;
import static de.Iclipse.IMAPI.IMAPI.getServerName;
import static de.MangoleHD.IMLobby.Data.*;


public class Main extends JavaPlugin {

    @Override
    public void onLoad() {
        Data.instance = this;
        loadWorld();
    }

    @Override
    public void onEnable() {
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        loadResourceBundles();
        registerListener();
        registerCommands();
        createTables();
        Data.tablist = new Tablist();
        createExtras();
        Bukkit.getWorlds().forEach(world -> world.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false));
        spawn = new Location(Bukkit.getWorld("world"), 0.5, 55, 0.5, 180, 0);
        Scheduler.startScheduler();
        Bukkit.getWorld("world").setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, false);
        Server.setState(getServerName(), State.Lobby);
    }

    @Override
    public void onDisable() {
        super.onDisable();
        Scheduler.stopScheduler();
    }

    public void registerListener() {
        Bukkit.getPluginManager().registerEvents(new ParticleListener(), this);
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new LobbyListener(), this);
        Bukkit.getPluginManager().registerEvents(new StartInventoryListener(), this);
        Bukkit.getPluginManager().registerEvents(new QuitListener(), this);
        Bukkit.getPluginManager().registerEvents(new ClothingListener(), this);
        Bukkit.getPluginManager().registerEvents(new ExtrasListener(), this);
        Bukkit.getPluginManager().registerEvents(new LangListener(), this);
        Bukkit.getPluginManager().registerEvents(new Treppe(), this);
        Bukkit.getPluginManager().registerEvents(new GroßesDorfhaus(), this);
        Bukkit.getPluginManager().registerEvents(new MiniArena(), this);
        Bukkit.getPluginManager().registerEvents(new SignClick(), this);
    }

    public void registerCommands() {
        IMAPI.register(new cmd_startInventory(), this);
        IMAPI.register(new cmd_killlag(), this);
        IMAPI.register(new cmd_miniArena(), this);
    }

    public void createTables() {
    }

    public void loadResourceBundles() {
        try {
            HashMap<String, ResourceBundle> langs = new HashMap<>();
            langDE = ResourceBundle.getBundle("i18n.langDE");
            langEN = ResourceBundle.getBundle("i18n.langEN");
            langs.put("DE", langDE);
            langs.put("EN", langEN);
            Data.dsp = new Dispatcher(this,
                    langs);
        } catch (MissingResourceException e) {
            e.printStackTrace();
            de.Iclipse.IMAPI.Data.dispatching = false;
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Reload oder Bundle not found!");
            de.Iclipse.IMAPI.Data.dispatching = false;
        }
    }

    public void loadWorld() {
        //if (mapUpdate) {
        File from = new File("/home/IMNetzwerk/BuildServer/IMLobby_world/region");
        File to = new File(Data.instance.getDataFolder().getAbsoluteFile().getParentFile().getParentFile().getAbsolutePath() + "/world/region");

        if (to.exists()) {
            IMAPI.deleteFile(new File(Data.instance.getDataFolder().getAbsoluteFile().getParentFile().getParentFile().getAbsolutePath() + "/world"));
        }
        //if (to.getTotalSpace() != from.getTotalSpace()) {

        try {
            copyFilesInDirectory(from, to);
            Files.copy(new File("/home/IMNetzwerk/BuildServer/IMLobby_world/level.dat").toPath(), new File(Data.instance.getDataFolder().getAbsoluteFile().getParentFile().getParentFile().getAbsolutePath() + "/world/level.dat").toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //}
        /*
            } else {
                try {
                    copyFilesInDirectory(from, to);
                    Files.copy(new File("/home/IMNetzwerk/BuildServer/IMLobby_world/level.dat").toPath(), new File(Data.instance.getDataFolder().getAbsoluteFile().getParentFile().getParentFile().getAbsolutePath() + "/world/level.dat").toPath(), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

         */
    }

    public static void createExtras() {
        Vent.createVents();
        Windmill.createWindmills();
        Flag.createFlags();
        Grave.createGraves();
        Bell.createBells();
    }

}
