package de.MangoleHD.IMLobby;

//  ╔══════════════════════════════════════╗
//  ║      ___       ___                   ║
//  ║     /  /___   /  /(_)____ ____  __   ║
//  ║    /  // __/ /  // // ) // ___// )\  ║                                  
//  ║   /  // /__ /  // //  _/(__  )/ __/  ║                                                                         
//  ║  /__/ \___//__//_//_/  /____/ \___/  ║                                              
//  ╚══════════════════════════════════════╝


import de.Iclipse.IMAPI.IMAPI;
import de.Iclipse.IMAPI.Util.Dispatching.Dispatcher;
import de.Iclipse.IMAPI.Util.SkullUtils;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.MangoleHD.IMLobby.Functions.Extras.Animations.Animation;
import de.MangoleHD.IMLobby.Functions.Extras.Animations.Casino;
import de.MangoleHD.IMLobby.Functions.Extras.Animations.Flags;
import de.MangoleHD.IMLobby.Functions.Extras.Animations.Vents;
import de.MangoleHD.IMLobby.Functions.Extras.Bells;
import de.MangoleHD.IMLobby.Functions.Extras.Broadcasts.BossBar;
import de.MangoleHD.IMLobby.Functions.Extras.Minigames.MiniArena;
import de.MangoleHD.IMLobby.Functions.Extras.SignSystem.SignUpdate;
import de.MangoleHD.IMLobby.Functions.PopupMenus.ProfileMenu.ProfileItems;
import de.MangoleHD.IMLobby.Functions.PopupMenus.ProfileMenu.ProfileMenu;
import de.MangoleHD.IMLobby.Functions.PopupMenus.ProfileMenu.Settings.Design.DesignItems;
import de.MangoleHD.IMLobby.Functions.PopupMenus.ProfileMenu.Settings.Design.DesignMenu;
import de.MangoleHD.IMLobby.Functions.PopupMenus.ProfileMenu.Settings.Design.SubDesignMenu;
import de.MangoleHD.IMLobby.Functions.PopupMenus.ProfileMenu.Settings.Language.LanguageItems;
import de.MangoleHD.IMLobby.Functions.PopupMenus.ProfileMenu.Settings.SettingsItems;
import de.MangoleHD.IMLobby.Functions.PopupMenus.ProfileMenu.Settings.SettingsMenu;
import de.MangoleHD.IMLobby.Functions.PopupMenus.ProfileMenu.Settings.Status.StatusItems;
import de.MangoleHD.IMLobby.Functions.PopupMenus.ProfileMenu.Settings.Status.StatusMenu;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.MissingResourceException;
import java.util.ResourceBundle;


/**
 * Created by Iclipse on 28.11.2020
 */
public class Data {

    private final IMLobby imLobby;
    private final IMAPI imapi;
    private final Location spawn;
    private Dispatcher dispatcher;
    private ResourceBundle langDE;
    private ResourceBundle langEN;
    private final BossBar bossBar;
    private final SignUpdate signUpdate;
    private MiniArena miniArena;

    private boolean dispatching = true;
    private boolean killlag = true;

    //Lists
    private final HashMap<Player, Integer> sneakjumper = new HashMap<>();
    private ArrayList<Player> ghost = new ArrayList<>();
    private ArrayList<Animation> animations = new ArrayList<>();

    //Animations
    private Casino casino;
    private Flags flags;
    private Vents vents;
    private Bells bells;

    //MiniArena
    private final ArrayList<Player> waiting = new ArrayList<>();
    private final ArrayList<Player> fighting = new ArrayList<>();
    private int arenaCountdown = 0;
    private final ArrayList<Block> placed = new ArrayList<>();

    public Data(IMLobby imLobby){
        this.imLobby = imLobby;
        this.imapi = IMAPI.getInstance();
        this.spawn = new Location(Bukkit.getWorld("world"), 0.5, 55, 0.5, 180, 0);
        this.bossBar = new BossBar(imapi, false);
        this.signUpdate = new SignUpdate(imLobby);
        loadResourceBundles();
        loadCustomHeads();
    }


    public void loadResourceBundles() {
        HashMap<String, ResourceBundle> langs = new HashMap<>();
        try {
            langDE = ResourceBundle.getBundle("i18n.langDE");
            langEN = ResourceBundle.getBundle("i18n.langEN");
        } catch (MissingResourceException e) {
            dispatching = false;
        } catch (Exception e) {
            System.out.println("Reload oder Bundle not found!");
            dispatching = false;
        }
        langs.put("DE", langDE);
        langs.put("EN", langEN);
        dispatcher = new Dispatcher(imapi,
                langs);
    }

    public IMAPI getIMAPI() {
        return imapi;
    }

    public Dispatcher getDispatcher() {
        return dispatcher;
    }

    public boolean isDispatching() {
        return dispatching;
    }

    public Location getSpawn() {
        return spawn;
    }

    public BossBar getBossBar() {
        return bossBar;
    }

    public SignUpdate getSignUpdate() {
        return signUpdate;
    }

    public MiniArena getMiniArena() {
        return miniArena;
    }

    public MiniArena setMiniArena(MiniArena miniArena) {
        this.miniArena = miniArena;
        return miniArena;
    }

    public boolean isKilllag() {
        return killlag;
    }

    public void setKilllag(boolean killlag) {
        this.killlag = killlag;
    }

    public ArrayList<Animation> getAnimations() {
        return animations;
    }

    public ArrayList<Player> getGhost() {
        return ghost;
    }

    public HashMap<Player, Integer> getSneakjumper() {
        return sneakjumper;
    }

    public Casino getCasino() {
        return casino;
    }

    public void setCasino(Casino casino) {
        this.casino = casino;
    }

    public Flags getFlags() {
        return flags;
    }

    public void setFlags(Flags flags) {
        this.flags = flags;
    }

    public Vents getVents() {
        return vents;
    }

    public void setVents(Vents vents) {
        this.vents = vents;
    }

    public Bells getBells() {
        return bells;
    }

    public void setBells(Bells bells) {
        this.bells = bells;
    }

    public ArrayList<Player> getWaiting() {
        return waiting;
    }

    public ArrayList<Player> getFighting() {
        return fighting;
    }

    public void setArenaCountdown(int arenaCountdown) {
        this.arenaCountdown = arenaCountdown;
    }

    public int getArenaCountdown() {
        return arenaCountdown;
    }

    public ArrayList<Block> getPlaced() {
        return placed;
    }

    public void loadCustomHeads() {
        imapi.getData().getHeads().put("friendmenu", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzIzODYzOTgxODk1YjEwNGMxYjI5YzlmNWY0MjdhZTBhMGVkZTQ2NDU4NDU4NzA2OGZiMTU5M2EyN2QifX19"));
        imapi.getData().getHeads().put("news", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjZhMzA3ZDc0OTExZDJhZWE1ZWU0YjJlNmJmZGRjMGI2NGUyMTAyMGU3ZTdiMTllZWExNjBkNDE1MTYyMGFjYiJ9fX0=="));

        imapi.getData().getHeads().put("friend_favorite", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGNkOWRkZjRmYjllMjVlNjJkMmU5ODU5NWQ1MTY4ZGUyYjMzNjdiYTc4ZjM2OTdiZTFjNDc5ZjM1MTAyYWQ3NiJ9fX0="));
        imapi.getData().getHeads().put("friend_nonfavorite", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTNiZGMzZmU3MGFjMGYwNzI1YjgxYWQ5MTViNGQyODFhMWViM2JhYmIyOTBhYzdmMmFjMjUwZjMwMGFiODE4YyJ9fX0="));

        imapi.getData().getHeads().put("sort_A", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWE3NGQ5MjEyZTY0OTFiYzM3MGNhZjAyNWZkNDU5ZmU2MzJjYTdjNmJhNGRmN2ViZWZhZmQ0ODlhYjMyZmQifX19"));
        imapi.getData().getHeads().put("sort_Z", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2ZhNzMwYjVlYzczY2VhZjRhYWQ1MjRlMjA3ZmYzMWRmNzg1ZTdhYjZkYjFhZWIzZjFhYTRkMjQ1ZWQyZSJ9fX0="));
        imapi.getData().getHeads().put("sort_Online", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTllNGJkY2YxNzJkNWRjNzdjMmJkNGUzN2FkOTg1Mzk5YTlmMmNkZWJmNzI0NjM5MjllYTRiNjY2ZWY2ZjgwIn19fQ=="));
        imapi.getData().getHeads().put("sort_Offline", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWZkZTNiZmNlMmQ4Y2I3MjRkZTg1NTZlNWVjMjFiN2YxNWY1ODQ2ODRhYjc4NTIxNGFkZDE2NGJlNzYyNGIifX19"));
        imapi.getData().getHeads().put("sort_AgeDesc", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTAzZjllZTVkOTRkY2Q1ZmRhZjZiMjg4NTVhNGMzYzI1YzY3OGExZDRiZTMwYjQyOTM5NGJkOWFkMzNhNDcyIn19fQ=="));
        imapi.getData().getHeads().put("sort_AgeAsc", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWFjNDIzMDYwNjIwMTNlNTk0ODIyYzhiNjYzM2Q1YzA4Nzc1MWUzMmVkNmZhY2E1MmRhYWZkZDlkMWI3MWYifX19"));
        imapi.getData().getHeads().put("sort_OnlineTimeDesc", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODQ3N2RhZmM4YzllYTA3OTk2MzMzODE3OTM4NjZkMTQ2YzlhMzlmYWQ0YzY2ODRlNzExN2Q5N2U5YjZjMyJ9fX0="));
        imapi.getData().getHeads().put("sort_OnlineTimeAsc", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmVmNzc3N2RmOTAyZDQ1MWY0ZmY5ZDEzYjAwZDdkY2Y3ZjY4OWU5NmIwYWU0YTBkNWQ0ZGE4MWE3M2NkNDQyNiJ9fX0="));


        imapi.getData().getHeads().put("baro", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDU5M2Y5YjliZmMxYjIxMTA0MTFjN2FkN2RlMzYyY2JiZjM0OTY4MmMyNDQ5YmI1NDQ1MmFkOGM1ZjU1YzQyIn19fQ=="));
        imapi.getData().getHeads().put("baro_maxPlayerBars", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2E2ZGNmMjc1Y2Y1OGM2NGNhN2I0ZDFmYzRlYTAwOWEyYjU2OTk1ZjUxYjU0OTg3NGJhNzg5ODZjZGVhYjdkMyJ9fX0="));
        imapi.getData().getHeads().put("baro_barrier", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWZkMjQwMDAwMmFkOWZiYmJkMDA2Njk0MWViNWIxYTM4NGFiOWIwZTQ4YTE3OGVlOTZlNGQxMjlhNTIwODY1NCJ9fX0="));
        imapi.getData().getHeads().put("baro_events", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjE4MTJiNGUwZjAxYmIxOTM3ZGY5Mzg5ZmU2N2UyNWZhNWQ4NzYxMjQ4NTk4MzcwMTZjNDUxNTRiZWQzY2QxZSJ9fX0="));
        imapi.getData().getHeads().put("baro_zone", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTQ4Zjc3NzEwN2YzMDFjMjQwZjgxNTRmZDk0ZTcyZThiMjJkYTFlZTQ4NzA1YTYxZWZiZmNmOWVlMjA3ZjkyZCJ9fX0="));

        imapi.getData().getHeads().put("user", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjgxYTAxMzgzZDAzOWU1OGYyMDA1NDcwNzk0MjYyYmI3YTIxYzVlZTUzNzk0YzkyNTRiMmFmZGY0NTUzZGVmNyJ9fX0="));
        imapi.getData().getHeads().put("partymember", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTIxZDhkOWFlNTI3OGUyNmJjNDM5OTkyM2QyNWNjYjkxNzNlODM3NDhlOWJhZDZkZjc2MzE0YmE5NDM2OWUifX19"));
        imapi.getData().getHeads().put("teammember", SkullUtils.getPlayerSkull(UUIDFetcher.getUUID("5hunderter")));

        loadLanguages();
        loadArrows();
        loadLuckyBlocks();
        System.out.println(imapi.getData().getHeads().size());
    }

    public void loadLanguages() {
        imapi.getData().getHeads().put("EN", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGNhYzk3NzRkYTEyMTcyNDg1MzJjZTE0N2Y3ODMxZjY3YTEyZmRjY2ExY2YwY2I0YjM4NDhkZTZiYzk0YjQifX19"));
        imapi.getData().getHeads().put("DE", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWU3ODk5YjQ4MDY4NTg2OTdlMjgzZjA4NGQ5MTczZmU0ODc4ODY0NTM3NzQ2MjZiMjRiZDhjZmVjYzc3YjNmIn19fQ=="));

    }

    public void loadArrows() {
        imapi.getData().getHeads().put("arrowRightPINK", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTg2NjczZGMxZWFhNmFjMjc1YzhhZGQxZTRjNTQzZWY5NGQ5M2ZhZTcxZGJmNmMwNDZmMDU2ZTdmMzQ0YWFhZiJ9fX0="));
        imapi.getData().getHeads().put("arrowLeftPINK", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDJlZTU5N2FiNWJkZTk4YTc1Mzk2MjViNDE0Yzg3ZGIzODZmZjdmOWQ1MjZmZjk4MzllOTk2OTYzMDhiNGE5ZSJ9fX0="));
        imapi.getData().getHeads().put("arrowUpPINK", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWVjODhjNzZlM2Q5YTFlYmQ3ZjRhMmU1NWVjYmNjNDJhOGQyM2Y2OTY3ODRhYTQxMGYwOTUxMmEzYjUzYSJ9fX0="));
        imapi.getData().getHeads().put("arrowDownPINK", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjNjNjZjNDJjZGUxZGQxZjVmOTUxNDNlNDcyMjU0ZjdmYWU4ZWNjZmY0ZGM5NDNiMDg2YTk0NGIyN2JkZmIifX19"));

        imapi.getData().getHeads().put("arrowRightRED", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmNmZTg4NDVhOGQ1ZTYzNWZiODc3MjhjY2M5Mzg5NWQ0MmI0ZmMyZTZhNTNmMWJhNzhjODQ1MjI1ODIyIn19fQ=="));
        imapi.getData().getHeads().put("arrowLeftRED", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjg0ZjU5NzEzMWJiZTI1ZGMwNThhZjg4OGNiMjk4MzFmNzk1OTliYzY3Yzk1YzgwMjkyNWNlNGFmYmEzMzJmYyJ9fX0="));
        imapi.getData().getHeads().put("arrowUpRED", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmQ5Mjg3NjE2MzQzZDgzM2U5ZTczMTcxNTljYWEyY2IzZTU5NzQ1MTEzOTYyYzEzNzkwNTJjZTQ3ODg4NGZhIn19fQ=="));
        imapi.getData().getHeads().put("arrowDownRED", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTM4NTJiZjYxNmYzMWVkNjdjMzdkZTRiMGJhYTJjNWY4ZDhmY2E4MmU3MmRiY2FmY2JhNjY5NTZhODFjNCJ9fX0="));

        imapi.getData().getHeads().put("arrowRightORANGE", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmU4Y2Q1MzY2NGQ5MzA3YjY4NjliOWFiYmFlMmI3NzM3YWI3NjJiYjE4YmIzNGYzMWM1Y2E4ZjNlZGI2M2I2In19fQ=="));
        imapi.getData().getHeads().put("arrowLeftORANGE", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmU4YzNjZTJhZWU2Y2YyZmFhZGU3ZGIzN2JiYWU3M2EzNjYyN2FjMTQ3M2ZlZjc1YjQxMGEwYWY5NzY1OWYifX19"));
        imapi.getData().getHeads().put("arrowUpORANGE", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODgxYmRjZDU2MmZiNjFlZjY2YjhmZTk3NWE4NTRlZDE5ZjY1N2QxN2RhZGM2NDdkYTc5ODg4NTY2YThiMiJ9fX0="));
        imapi.getData().getHeads().put("arrowDownORANGE", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzQxOTQxZTdlN2U5MTRhMTE1YzM0MmQ2ZDM4YTIyOTMxZTEzOGIzZGExZWViNGU5OTg1NzFlOTBmODcxNTE3In19fQ=="));

        imapi.getData().getHeads().put("arrowRightYELLOW", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTQxZmY2YmM2N2E0ODEyMzJkMmU2NjllNDNjNGYwODdmOWQyMzA2NjY1YjRmODI5ZmI4Njg5MmQxM2I3MGNhIn19fQ=="));
        imapi.getData().getHeads().put("arrowLeftYELLOW", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDliMmJlZTM5YjZlZjQ3ZTE4MmQ2ZjFkY2E5ZGVhODQyZmNkNjhiZGE5YmFjYzZhNmQ2NmE4ZGNkZjNlYyJ9fX0="));
        imapi.getData().getHeads().put("arrowUpYELLOW", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2U0ZjJmOTY5OGMzZjE4NmZlNDRjYzYzZDJmM2M0ZjlhMjQxMjIzYWNmMDU4MTc3NWQ5Y2VjZDcwNzUifX19"));
        imapi.getData().getHeads().put("arrowDownYELLOW", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmIyOWVjZWVmM2RkYjE0ZjkwNmRiZDRmYTQxZDYzZjNkN2Q0NTM3ODcxY2VlNDMxNWM1OWU3NmViYzVmODUifX19"));

        imapi.getData().getHeads().put("arrowRightGREEN", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTYzMzlmZjJlNTM0MmJhMThiZGM0OGE5OWNjYTY1ZDEyM2NlNzgxZDg3ODI3MmY5ZDk2NGVhZDNiOGFkMzcwIn19fQ=="));
        imapi.getData().getHeads().put("arrowLeftGREEN", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODU1MGI3Zjc0ZTllZDc2MzNhYTI3NGVhMzBjYzNkMmU4N2FiYjM2ZDRkMWY0Y2E2MDhjZDQ0NTkwY2NlMGIifX19"));
        imapi.getData().getHeads().put("arrowUpGREEN", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWRhMDI3NDc3MTk3YzZmZDdhZDMzMDE0NTQ2ZGUzOTJiNGE1MWM2MzRlYTY4YzhiN2JjYzAxMzFjODNlM2YifX19"));
        imapi.getData().getHeads().put("arrowDownGREEN", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmY3NDE2Y2U5ZTgyNmU0ODk5YjI4NGJiMGFiOTQ4NDNhOGY3NTg2ZTUyYjcxZmMzMTI1ZTAyODZmOTI2YSJ9fX0="));

        imapi.getData().getHeads().put("arrowRightBLACK", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjgyYWQxYjljYjRkZDIxMjU5YzBkNzVhYTMxNWZmMzg5YzNjZWY3NTJiZTM5NDkzMzgxNjRiYWM4NGE5NmUifX19"));
        imapi.getData().getHeads().put("arrowLeftBLACK", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzdhZWU5YTc1YmYwZGY3ODk3MTgzMDE1Y2NhMGIyYTdkNzU1YzYzMzg4ZmYwMTc1MmQ1ZjQ0MTlmYzY0NSJ9fX0="));
        imapi.getData().getHeads().put("arrowUpBLACK", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmNjYmY5ODgzZGQzNTlmZGYyMzg1YzkwYTQ1OWQ3Mzc3NjUzODJlYzQxMTdiMDQ4OTVhYzRkYzRiNjBmYyJ9fX0="));
        imapi.getData().getHeads().put("arrowDownBLACK", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzI0MzE5MTFmNDE3OGI0ZDJiNDEzYWE3ZjVjNzhhZTQ0NDdmZTkyNDY5NDNjMzFkZjMxMTYzYzBlMDQzZTBkNiJ9fX0="));

        imapi.getData().getHeads().put("arrowRightGRAY", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjMyY2E2NjA1NmI3Mjg2M2U5OGY3ZjMyYmQ3ZDk0YzdhMGQ3OTZhZjY5MWM5YWMzYTkxMzYzMzEzNTIyODhmOSJ9fX0="));
        imapi.getData().getHeads().put("arrowLeftGRAY", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODY5NzFkZDg4MWRiYWY0ZmQ2YmNhYTkzNjE0NDkzYzYxMmY4Njk2NDFlZDU5ZDFjOTM2M2EzNjY2YTVmYTYifX19"));
        imapi.getData().getHeads().put("arrowUpGRAY", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2Y0NmFiYWQ5MjRiMjIzNzJiYzk2NmE2ZDUxN2QyZjFiOGI1N2ZkZDI2MmI0ZTA0ZjQ4MzUyZTY4M2ZmZjkyIn19fQ=="));
        imapi.getData().getHeads().put("arrowDownGRAY", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmU5YWU3YTRiZTY1ZmNiYWVlNjUxODEzODlhMmY3ZDQ3ZTJlMzI2ZGI1OWVhM2ViNzg5YTkyYzg1ZWE0NiJ9fX0="));

        imapi.getData().getHeads().put("arrowRightPURPLE", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjcyNmQyODhhNzRlOGFjOTI0YzU4YzkzZjViMzVjYWNkNjk0NmE2Y2NmZGJkYTg1ZmU4YWNiOWUzZWVjZWJkYiJ9fX0="));
        imapi.getData().getHeads().put("arrowLeftPURPLE", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmVmZjc1NTkxMDJhYThmZjk3MTI5NzZiNjIyOTJlZTQ1ZTA3OTNjNDZmNjY4OTE2ODY4MjA3ZjM5OWVmZmFiIn19fQ=="));
        imapi.getData().getHeads().put("arrowUpPURPLE", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTRhMDRiMzJkMmI3NTk4ZjlkZDhlMjNmYjQwMTVjNjljM2NkOTQyYTM3YTllYTg0ZDA2ODY5ZjQ1OWYxIn19fQ=="));
        imapi.getData().getHeads().put("arrowDownPURPLE", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWU1NzNlOTliOGE1YWY4YTdkNzQ1Yjc3NjU2NGRjNzI3ZGVmZGVmMDcwMjU3NjMwYWEzNmNkYjQ5YjdjZjhiIn19fQ=="));

        imapi.getData().getHeads().put("arrowRightMAGENTA", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODA3OGUxNjg5MmEyYzljMDIzMDUyMTNjY2U2MDQ4M2FiN2FkYTQ3ZjEzYWY5YjhkYTg3Y2U2M2RkODM0NyJ9fX0="));
        imapi.getData().getHeads().put("arrowLeftMAGENTA", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWRiZDhlYzQ2MTkyYTk1NWM2YmQ2NTFhYjRkODZmOTg2N2U0ZDRiZDk5YWYyMWNhOTJlYzlkMjZmODZkYTkxIn19fQ=="));
        imapi.getData().getHeads().put("arrowUpMAGENTA", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2YxMTRiZWM2YTZmZGRlYTM3ZDJiODc2N2FjZTI2YjBkMTgyODMwNzVmZmQ4NWQ1Njg3YzU1YTdiNGYxZThjIn19fQ=="));
        imapi.getData().getHeads().put("arrowDownMAGENTA", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2RiOTYyOWNhYjcyZTAyMWM4YjU2MTY1MGM1ODZiOTliZmRiM2Y2YTlhOTYyY2M2ZTU2MTEyMjJkMzU1OGVmIn19fQ=="));

        imapi.getData().getHeads().put("arrowRightBLUE", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTE3ZjM2NjZkM2NlZGZhZTU3Nzc4Yzc4MjMwZDQ4MGM3MTlmZDVmNjVmZmEyYWQzMjU1Mzg1ZTQzM2I4NmUifX19"));
        imapi.getData().getHeads().put("arrowLeftBLUE", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWFlNzg0NTFiZjI2Y2Y0OWZkNWY1NGNkOGYyYjM3Y2QyNWM5MmU1Y2E3NjI5OGIzNjM0Y2I1NDFlOWFkODkifX19"));
        imapi.getData().getHeads().put("arrowUpBLUE", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjJmYzIzODY2NTIzY2FhYThhOTUzNDU2NjEyN2E2ZjgzODlhZjNlNzZiOGUzYzMzYzI0NzNjYmE2ODg5YzQifX19"));
        imapi.getData().getHeads().put("arrowDownBLUE", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjBkMWRmODA0NmYwYjVkOTM0YzNlMDU3OThlYWNmZWVhNmQ3YjU5NWRiZTI2ZGViZjdkYjlhY2M4YzRmYTc5OCJ9fX0="));

        imapi.getData().getHeads().put("arrowRightLIGHT_BLUE", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjY3MWM0YzA0MzM3YzM4YTVjN2YzMWE1Yzc1MWY5OTFlOTZjMDNkZjczMGNkYmVlOTkzMjA2NTVjMTlkIn19fQ=="));
        imapi.getData().getHeads().put("arrowLeftLIGHT_BLUE", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTM5NzExMjRiZTg5YWM3ZGM5YzkyOWZlOWI2ZWZhN2EwN2NlMzdjZTFkYTJkZjY5MWJmODY2MzQ2NzQ3N2M3In19fQ=="));
        imapi.getData().getHeads().put("arrowUpLIGHT_BLUE", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjQ2MjhhY2U3YzNhZmM2MWE0NzZkYzE0NDg5M2FhYTY0MmJhOTc2ZDk1MmI1MWVjZTI2YWJhZmI4OTZiOCJ9fX0="));
        imapi.getData().getHeads().put("arrowDownLIGHT_BLUE", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmFlNDI1YzViYTlmM2MyOTYyYjM4MTc4Y2JjMjMxNzJhNmM2MjE1YTExYWNjYjkyNzc0YTQ3MTZlOTZjYWRhIn19fQ=="));

        imapi.getData().getHeads().put("arrowRightCYAN", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmZmNTVmMWIzMmMzNDM1YWMxYWIzZTVlNTM1YzUwYjUyNzI4NWRhNzE2ZTU0ZmU3MDFjOWI1OTM1MmFmYzFjIn19fQ=="));
        imapi.getData().getHeads().put("arrowLeftCYAN", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjc2OGVkYzI4ODUzYzQyNDRkYmM2ZWViNjNiZDQ5ZWQ1NjhjYTIyYTg1MmEwYTU3OGIyZjJmOWZhYmU3MCJ9fX0="));
        imapi.getData().getHeads().put("arrowUpCYAN", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGIyMjFjYjk2MDdjOGE5YmYwMmZlZjVkNzYxNGUzZWIxNjljYzIxOWJmNDI1MGZkNTcxNWQ1ZDJkNjA0NWY3In19fQ=="));
        imapi.getData().getHeads().put("arrowDownCYAN", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDhhYWI2ZDlhMGJkYjA3YzEzNWM5Nzg2MmU0ZWRmMzYzMTk0Mzg1MWVmYzU0NTQ2M2Q2OGU3OTNhYjQ1YTNkMyJ9fX0="));

        imapi.getData().getHeads().put("arrowRightLIME", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGVmMzU2YWQyYWE3YjE2NzhhZWNiODgyOTBlNWZhNWEzNDI3ZTVlNDU2ZmY0MmZiNTE1NjkwYzY3NTE3YjgifX19"));
        imapi.getData().getHeads().put("arrowLeftLIME", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjUzNDc0MjNlZTU1ZGFhNzkyMzY2OGZjYTg1ODE5ODVmZjUzODlhNDU0MzUzMjFlZmFkNTM3YWYyM2QifX19"));
        imapi.getData().getHeads().put("arrowUpLIME", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjIyMWRhNDQxOGJkM2JmYjQyZWI2NGQyYWI0MjljNjFkZWNiOGY0YmY3ZDRjZmI3N2ExNjJiZTNkY2IwYjkyNyJ9fX0="));
        imapi.getData().getHeads().put("arrowDownLIME", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2I4M2JiY2NmNGYwYzg2YjEyZjZmNzk5ODlkMTU5NDU0YmY5MjgxOTU1ZDdlMjQxMWNlOThjMWI4YWEzOGQ4In19fQ=="));

        imapi.getData().getHeads().put("arrowRightBROWN", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjI4MjViY2EzOGU5YTIyZWRmNWVjOWUwOTZhM2Y2OGY1OWVjZThlNGVjNDcxZjdjZGNhMzM3MDk2ZmVmYTgzIn19fQ=="));
        imapi.getData().getHeads().put("arrowLeftBROWN", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWQ0YjMzNGRjNTExNTZhOGQ4YWJjNDJjODRiMzJjOWNlODc2M2M0MjA0Y2E1NzNiYmQwOWZkMDM3MTQ3YiJ9fX0="));
        imapi.getData().getHeads().put("arrowUpBROWN", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTQyNDEzY2IyOGNkY2I3ZWRkMGRlY2E2NTRiMjZkNTg0ZDgxNjQ2ZDk0YjgyNWU4NTI5ZGIyZjJkZjMwZTAifX19"));
        imapi.getData().getHeads().put("arrowDownBROWN", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTNjMWE0Y2Y0OTUxNGI1N2E3OGMxNWQ0ODRmYzBlYWE4N2YyZmM2NDg3Y2Q1NGFjM2I1ODA3ZjY0YzZhNzJkIn19fQ=="));

        imapi.getData().getHeads().put("arrowRightLIGHT_GRAY", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDA2MjYyYWYxZDVmNDE0YzU5NzA1NWMyMmUzOWNjZTE0OGU1ZWRiZWM0NTU1OWEyZDZiODhjOGQ2N2I5MmVhNiJ9fX0="));
        imapi.getData().getHeads().put("arrowLeftLIGHT_GRAY", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTQyZmRlOGI4MmU4YzFiOGMyMmIyMjY3OTk4M2ZlMzVjYjc2YTc5Nzc4NDI5YmRhZGFiYzM5N2ZkMTUwNjEifX19"));
        imapi.getData().getHeads().put("arrowUpLIGHT_GRAY", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2Y0NmFiYWQ5MjRiMjIzNzJiYzk2NmE2ZDUxN2QyZjFiOGI1N2ZkZDI2MmI0ZTA0ZjQ4MzUyZTY4M2ZmZjkyIn19fQ=="));
        imapi.getData().getHeads().put("arrowDownLIGHT_GRAY", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmU5YWU3YTRiZTY1ZmNiYWVlNjUxODEzODlhMmY3ZDQ3ZTJlMzI2ZGI1OWVhM2ViNzg5YTkyYzg1ZWE0NiJ9fX0="));

        imapi.getData().getHeads().put("arrowRightWHITE", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTU2YTM2MTg0NTllNDNiMjg3YjIyYjdlMjM1ZWM2OTk1OTQ1NDZjNmZjZDZkYzg0YmZjYTRjZjMwYWI5MzExIn19fQ=="));
        imapi.getData().getHeads().put("arrowLeftWHITE", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2RjOWU0ZGNmYTQyMjFhMWZhZGMxYjViMmIxMWQ4YmVlYjU3ODc5YWYxYzQyMzYyMTQyYmFlMWVkZDUifX19"));
        imapi.getData().getHeads().put("arrowUpWHITE", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWFkNmM4MWY4OTlhNzg1ZWNmMjZiZTFkYzQ4ZWFlMmJjZmU3NzdhODYyMzkwZjU3ODVlOTViZDgzYmQxNGQifX19"));
        imapi.getData().getHeads().put("arrowDownWHITE", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODgyZmFmOWE1ODRjNGQ2NzZkNzMwYjIzZjg5NDJiYjk5N2ZhM2RhZDQ2ZDRmNjVlMjg4YzM5ZWI0NzFjZTcifX19"));

    }

    public void loadLuckyBlocks() {
        imapi.getData().getHeads().put("luckyBlockPINK", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2ViZjQzZWNkOGQ4ZmYwZTJhNTMzYjE1ZWE5YTkxZTQxMmFkYTI2OTZhZjVmNGE5MzY4ZGEyNDMwOWIyMjdkZSJ9fX0="));
        imapi.getData().getHeads().put("luckyBlockRED", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzEyNjExNjU2M2U5MDRjZGU3ZjUyYWUwZmI1ZTA3NjZlNjBhYmY0NzU3OTU3ZGU5ZGQzYjA2ZWRmMWY4YmQ4ZSJ9fX0="));
        imapi.getData().getHeads().put("luckyBlockORANGE", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmZkY2ZiNDAwOTc2YmY3M2VjMzJjMWI5OTYyYzgzMGZjM2Q3MDA2ZDc0OWY4ZjNkYTNiNmUwZmI4MjkwOWIyOCJ9fX0="));
        imapi.getData().getHeads().put("luckyBlockYELLOW", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzlkMWVmNGMxNTNiZGU4YTdiMDhmOTJjMGM0Yjc5ZmRjMmZjYjU3ZjgzYTMxYTgyMjljNjJhYzc1ZjFmMGEzMSJ9fX0="));
        imapi.getData().getHeads().put("luckyBlockGREEN", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjExODU2MTVkNWNjN2M3MDBlYWJjYjdkYjA5N2VkNzIxZDU4OWZkZmVlZjlmMDMzMzM2YzI2Yzk4OGU0YmU0NiJ9fX0="));
        imapi.getData().getHeads().put("luckyBlockBLACK", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzNmMmNkOWY4MWEyNzcyYmRjNDg2NDQ3MmU4MzMzNjIzMTA0ODVjOGE2YmMwYjc2YjgxNzAzMzkwYTliMDMyZSJ9fX0="));
        imapi.getData().getHeads().put("luckyBlockGRAY", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzcxOTMwMjc4ZjAyOWM1Nzc4Yzg1YzA0NzVhMzdmYWM4YWNkMzg1MDc0MmFhZTZhMzU0MmFjZGU0NDg3ZDYzIn19fQ=="));
        imapi.getData().getHeads().put("luckyBlockPURPLE", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODk1NDFhZWI1YjQwMmRjMjUzMzcyZWI0MGRjYWRhZjMyZWY5MmNjYTgzMWJkMzVkMzJiNDE5OTcxMzBjYjJlZSJ9fX0="));
        imapi.getData().getHeads().put("luckyBlockMAGENTA", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTA2ZWExMDRjYjliZTcwM2NjZWQxYjFmNTY1Mjg2NzUyZTI3MTc1MmM1YWM4NWU4MTEzYjNlMmRjNDM1MmMyMCJ9fX0="));
        imapi.getData().getHeads().put("luckyBlockBLUE", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzY2ZDZjMTllNGY1MDUxODgyODUxYTRhZWFkNzlmMGYxZjM4YWE2ODk3MTliNmIzMzAzMTdlYTJiOGIwZTUwMCJ9fX0="));
        imapi.getData().getHeads().put("luckyBlockLIGHT_BLUE", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzgyYWZhOGYyOTYwOGE5NWE0YmFlNTJmYjJkMTZjMjQzYWUzNTU4YjlmMjMxN2RmMDkwYjQyNjdjYjViNWYzOSJ9fX0="));
        imapi.getData().getHeads().put("luckyBlockCYAN", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmMxYTliNjY2MTJlYTBmOWVhMzVjMzNjMjZhMTY4YjY1M2U1ODIwMDVlYTA5Y2NjMTc5N2Y1MzI5ZTJiZDJjIn19fQ=="));
        imapi.getData().getHeads().put("luckyBlockLIME", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjYxOWY5NDdlZjIzNTM5MDNhZTliZTA2ZWUzNzViMzBmYTE2ZjI2NzlmZGMzYWIwMTg4ZmJiZTQ1MDBmZWY0In19fQ=="));
        imapi.getData().getHeads().put("luckyBlockBROWN", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjM0ZjM2ZDJkZmQwNjBkOTVmODk1MzA1NDA2ZjFiODQ1YmFlMDAyNzY0NjVhNDU0MjhkM2NmZDg2MzBkNGU2MSJ9fX0="));
        imapi.getData().getHeads().put("luckyBlockLIGHT_GRAY", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjJmMjYxNDMwNWYzMjIyNWU3YmZlZTRkM2Y4MGRhNzQyNmUyODNmMDJlOTY0ZGJjMTI1NGFmZjY0N2EwZTgzIn19fQ=="));
        imapi.getData().getHeads().put("luckyBlockWHITE", SkullUtils.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzgyYWZhOGYyOTYwOGE5NWE0YmFlNTJmYjJkMTZjMjQzYWUzNTU4YjlmMjMxN2RmMDkwYjQyNjdjYjViNWYzOSJ9fX0="));
    }

}
