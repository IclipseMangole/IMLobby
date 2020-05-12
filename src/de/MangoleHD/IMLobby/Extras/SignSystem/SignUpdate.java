package de.MangoleHD.IMLobby.Extras.SignSystem;

import de.Iclipse.IMAPI.Database.Server;
import de.Iclipse.IMAPI.Database.Sign;
import org.bukkit.block.Block;

public class SignUpdate {
    public static void update() {
        Sign.getSigns().forEach(id -> {
            Block b = Sign.getLocation(id).getBlock();
            if (b.getType().name().contains("SIGN")) {
                org.bukkit.block.Sign sign = (org.bukkit.block.Sign) b.getState();
                String mode = Sign.getMode(id);
                if (Sign.getServer(id) != null) {
                    if (!Server.getState(Sign.getServer(id)).equals("Lobby")) {
                        for (String server : Server.getServers(mode)) {
                            if (Server.getState(server).equals("Lobby") && !Sign.hasOtherSignThisServer(server)) {
                                Sign.setServer(id, server);
                                break;
                            }
                        }
                    }
                } else {
                    for (String server : Server.getServers(mode)) {
                        if (Server.getState(server).equals("Lobby") && !Sign.hasOtherSignThisServer(server)) {
                            Sign.setServer(id, server);
                            break;
                        }
                    }
                }

                updateSign(id, sign);
            } else {
                System.out.println("No sign at (" + b.getLocation().getBlockX() + "|" + b.getLocation().getBlockY() + "|" + b.getLocation().getBlockZ() + ")");
            }
        });
    }

    public static void updateSign(int id, org.bukkit.block.Sign sign) {
        if (Sign.getServer(id) != null) {
            String server = Sign.getServer(id);
            sign.setLine(0, server);
            if (Server.getPlayers(server) < Server.getMaxPlayers(server)) {
                sign.setLine(1, "§0[§2Lobby§0]");
            } else {
                sign.setLine(1, "§0[§6Full§0]");
            }
            sign.setLine(2, "");
            sign.setLine(3, Server.getPlayers(server) + "/" + Server.getMaxPlayers(server));
        } else {
            sign.setLine(0, Sign.getMode(id));
            sign.setLine(1, "§0[§4Offline§0]");
            sign.setLine(2, "");
            sign.setLine(3, "");
            sign.update(true, false);
        }
        sign.update(true, false);
    }
}
