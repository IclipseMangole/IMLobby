package de.MangoleHD.IMLobby.Extras.SignSystem;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import de.Iclipse.IMAPI.Database.Server;
import de.Iclipse.IMAPI.Database.Sign;
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
                    if (Server.getPlayers(server) < Server.getMaxPlayers(server)) {
                        dsp.send(e.getPlayer(), "sign.allow");
                        ByteArrayDataOutput out = ByteStreams.newDataOutput();
                        out.writeUTF("Connect");
                        out.writeUTF(server);
                        e.getPlayer().sendPluginMessage(Data.instance, "BungeeCord", out.toByteArray());
                    } else {
                        dsp.send(e.getPlayer(), "sign.disallow");
                    }
                }
            }
        }
    }
}
