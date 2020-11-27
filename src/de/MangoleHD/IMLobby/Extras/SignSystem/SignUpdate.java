package de.MangoleHD.IMLobby.Extras.SignSystem;

import de.Iclipse.IMAPI.Database.ServerManager;
import de.Iclipse.IMAPI.Database.Sign;
import de.Iclipse.IMAPI.Functions.Servers.State;
import org.bukkit.block.Block;

public class SignUpdate {
    public static void update() {
        if (Sign.getSigns().size() > 0) {
            Sign.getSigns().forEach(id -> {
                Block b = Sign.getLocation(id).getBlock();
                if (b.getType().name().contains("SIGN")) {
                    org.bukkit.block.Sign sign = (org.bukkit.block.Sign) b.getState();
                    String mode = Sign.getMode(id);
                    if (Sign.getServer(id) != null) {
                        if (!ServerManager.getState(Sign.getServer(id)).equals(State.Lobby)) {
                            Sign.setServer(id, "NONE");
                            for (String server : ServerManager.getServers(mode)) {
                                if (ServerManager.getState(server).equals(State.Lobby) && !Sign.hasOtherSignThisServer(server)) {
                                    Sign.setServer(id, server);
                                    break;
                                }
                            }
                        }
                    } else {
                        for (String server : ServerManager.getServers(mode)) {
                            if (ServerManager.getState(server).equals(State.Lobby) && !Sign.hasOtherSignThisServer(server)) {
                                Sign.setServer(id, server);
                                break;
                            }
                        }

                    }
                    if (Sign.getServer(id) == null) {
                        for (String server : ServerManager.getServers(mode)) {
                            if (ServerManager.getState(server).equals(State.Online) && !Sign.hasOtherSignThisServer(server)) {
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
    }

    public static void updateSign(int id, org.bukkit.block.Sign sign) {
        if (Sign.getServer(id) != null) {
            String server = Sign.getServer(id);
            sign.setLine(0, server);
            if (ServerManager.getState(server) == State.Lobby) {
                if (ServerManager.getPlayers(server) < ServerManager.getMaxPlayers(server)) {
                    sign.setLine(1, "§0[§2Lobby§0]");
                } else {
                    sign.setLine(1, "§0[§6Full§0]");
                }
            } else {
                sign.setLine(1, "§0[§4TeamOnly§0]");
            }
            if (ServerManager.getMap(server) != null) {
                sign.setLine(2, ServerManager.getMap(server));
            } else {
                sign.setLine(2, "");
            }
            sign.setLine(3, ServerManager.getPlayers(server) + "/" + ServerManager.getMaxPlayers(server));
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
