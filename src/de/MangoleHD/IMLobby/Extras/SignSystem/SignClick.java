package de.MangoleHD.IMLobby.Extras.SignSystem;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import de.Iclipse.IMAPI.Database.ServerManager;
import de.Iclipse.IMAPI.Database.Sign;
import de.Iclipse.IMAPI.Functions.Servers.State;
import de.MangoleHD.IMLobby.Data;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import static de.MangoleHD.IMLobby.Data.dsp;

public class SignClick implements Listener {
    @EventHandler
    public void onSignClick(PlayerInteractEvent e) {
        if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (e.getClickedBlock().getType().name().contains("SIGN")) {
                if (Sign.isSign(e.getClickedBlock().getLocation())) {
                    String server = Sign.getServer(Sign.getId(e.getClickedBlock().getLocation()));
                    State state = ServerManager.getState(server);
                    if (state == State.Online && e.getPlayer().hasPermission("im.team.join")) {
                        dsp.send(e.getPlayer(), "sign.allow");
                        SignUpdate.update();
                        ByteArrayDataOutput out = ByteStreams.newDataOutput();
                        out.writeUTF("Connect");
                        out.writeUTF(server);
                        e.getPlayer().sendPluginMessage(Data.instance, "BungeeCord", out.toByteArray());
                    } else if (state == State.Online) {
                        de.Iclipse.IMAPI.Data.dsp.send(e.getPlayer(), "cmd.noperm");
                    } else if (state == State.Lobby) {
                        if (ServerManager.getPlayers(server) < ServerManager.getMaxPlayers(server)) {
                            dsp.send(e.getPlayer(), "sign.allow");
                            SignUpdate.update();
                            ByteArrayDataOutput out = ByteStreams.newDataOutput();
                            out.writeUTF("Connect");
                            out.writeUTF(server);
                            e.getPlayer().sendPluginMessage(Data.instance, "BungeeCord", out.toByteArray());
                        } else {
                            dsp.send(e.getPlayer(), "sign.disallow");
                        }
                    } else {
                        dsp.send(e.getPlayer(), "sign.offline");
                    }
                }
            }
        }
    }
}
