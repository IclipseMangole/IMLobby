package de.MangoleHD.IMLobby.Extras.Broadcasts;

import de.Iclipse.IMAPI.Database.User;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class BossBar {
    private org.bukkit.boss.BossBar bossBarDE;
    HashMap<Integer, BossBarBroadcast> broadcastsDE;
    private int broadcastIDDE;
    private boolean growingDE;

    private org.bukkit.boss.BossBar bossBarEN;
    HashMap<Integer, BossBarBroadcast> broadcastsEN;
    private int broadcastIDEN;
    private boolean growingEN;

    public BossBar() {
        bossBarDE = Bukkit.createBossBar("BossBarDE", BarColor.BLUE, BarStyle.SOLID);
        broadcastsDE = new HashMap<>();
        broadcastsDE.put(0, new BossBarBroadcast(BarColor.BLUE, "§3Besuche den OutOfPosition-Discord: §5https://discord.gg/TqF8s3u"));
        broadcastsDE.put(1, new BossBarBroadcast(BarColor.PURPLE, "§fAlle lieben: §5Iclipse§7&§5Mangole"));
        broadcastsDE.put(2, new BossBarBroadcast(BarColor.RED, "§cWenn du Hilfe brauchst nutze §4/help"));
        broadcastsDE.put(3, new BossBarBroadcast(BarColor.BLUE, "§7Die §9Kompetenz§7 steht bei uns an erster Stelle"));
        broadcastIDDE = -1;


        bossBarEN = Bukkit.createBossBar("BossBarEN", BarColor.BLUE, BarStyle.SOLID);
        broadcastsEN = new HashMap<>();
        broadcastsEN.put(0, new BossBarBroadcast(BarColor.BLUE, "§3Visit the OutOfPosition-Discord: §5https://discord.gg/TqF8s3u"));
        broadcastsDE.put(1, new BossBarBroadcast(BarColor.PURPLE, "§fEverybody loves: §5Iclipse§7&§5Mangole"));
        broadcastsDE.put(2, new BossBarBroadcast(BarColor.RED, "§cIf you need help, use: §4/help"));
        broadcastIDEN = -1;
    }

    public void addPlayer(Player p) {
        if (bossBarDE.getPlayers().contains(p)) {
            bossBarDE.removePlayer(p);
        }
        if (bossBarEN.getPlayers().contains(p)) {
            bossBarEN.removePlayer(p);
        }

        if (User.getLanguage(UUIDFetcher.getUUID(p.getName())).equals("DE")) {
            bossBarDE.addPlayer(p);
        } else {
            bossBarEN.addPlayer(p);
        }
    }

    public void update() {
        //Update DE
        if (broadcastIDDE != -1) {
            String curTitle = bossBarDE.getTitle();
            if (growingDE) {
                if (curTitle.length() < broadcastsDE.get(broadcastIDDE).getTitle().length()) {
                    String newTitle = "";
                    for (int i = 0; i < curTitle.length() + 1; ) {
                        if (broadcastsDE.get(broadcastIDDE).getTitle().charAt(i) == '§') {
                            newTitle += broadcastsDE.get(broadcastIDDE).getTitle().charAt(i);
                            i++;
                            newTitle += broadcastsDE.get(broadcastIDDE).getTitle().charAt(i);
                            i++;
                        }
                        newTitle += broadcastsDE.get(broadcastIDDE).getTitle().charAt(i);
                        i++;
                    }
                    bossBarDE.setTitle(newTitle);
                } else if (curTitle.length() == broadcastsDE.get(broadcastIDDE).getTitle().length() + 5) {
                    bossBarDE.setTitle(curTitle + " ");
                } else {
                    growingDE = false;
                }
            } else {
                System.out.println("Remove");
                if (curTitle.length() > 2) {
                    System.out.println("<=2");
                    String newTitle = curTitle;
                    if (newTitle.charAt(2) == '§') {
                        newTitle = newTitle.substring(2);
                    }
                    newTitle = newTitle.substring(2);
                    for (char c : newTitle.toCharArray()) {
                        System.out.print(c);
                    }
                    System.out.println();
                    bossBarDE.setTitle(newTitle);
                } else {
                    broadcastIDDE = (broadcastIDDE + 1) % broadcastsDE.size();
                    bossBarDE.setColor(broadcastsDE.get(broadcastIDDE).getColor());
                    growingDE = true;
                }
            }
        } else {
            broadcastIDDE = 0;
            bossBarDE.setColor(broadcastsDE.get(broadcastIDDE).getColor());
            bossBarDE.setTitle("");
            growingDE = true;
        }


        //Update EN
        if (broadcastIDEN != -1) {
            String curTitle = bossBarEN.getTitle();
            if (growingEN) {
                if (curTitle.length() < broadcastsEN.get(broadcastIDEN).getTitle().length()) {
                    String newTitle = "";
                    for (int i = 0; i < curTitle.length() + 1; ) {
                        if (broadcastsEN.get(broadcastIDEN).getTitle().charAt(i) == '§') {
                            newTitle += broadcastsEN.get(broadcastIDEN).getTitle().charAt(i);
                            i++;
                            newTitle += broadcastsEN.get(broadcastIDEN).getTitle().charAt(i);
                            i++;
                        }
                        newTitle += broadcastsEN.get(broadcastIDEN).getTitle().charAt(i);
                        i++;
                    }
                    bossBarEN.setTitle(newTitle);
                } else if (curTitle.length() == broadcastsEN.get(broadcastIDEN).getTitle().length() + 5) {
                    bossBarEN.setTitle(curTitle + " ");
                } else {
                    growingEN = false;
                }
            } else {
                if (curTitle.length() > 2) {
                    String newTitle = curTitle;
                    if (newTitle.charAt(2) == '§') {
                        newTitle = newTitle.substring(2);
                    }
                    newTitle = newTitle.substring(2);
                    bossBarEN.setTitle(newTitle);
                } else {
                    broadcastIDEN = (broadcastIDEN + 1) % broadcastsEN.size();
                    bossBarEN.setColor(broadcastsEN.get(broadcastIDEN).getColor());
                    growingEN = true;
                }
            }
        } else {
            broadcastIDEN = 0;
            bossBarEN.setColor(broadcastsEN.get(broadcastIDEN).getColor());
            bossBarEN.setTitle("");
            growingEN = true;
        }
    }

}
