package de.MangoleHD.IMLobby.Commands;

import de.Iclipse.IMAPI.Util.Command.IMCommand;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.MangoleHD.IMLobby.Data;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static de.MangoleHD.IMLobby.Data.dsp;

public class cmd_miniArena {
    @IMCommand(
            name = "miniArena",
            permissions = "im.cmd.miniArena",
            description = "miniArena.description",
            usage = "miniArena.usage",
            minArgs = 1,
            maxArgs = 1
    )
    public void execute(CommandSender sender, Player player){
        if(!Data.waiting.contains(player)) {
            if (Data.waiting.size() < 2) {
                Data.waiting.add(player);
                dsp.send(player, "miniArena.join");
            } else {
                dsp.send(player, "miniArena.full");
                dsp.send(sender, "miniArena.full");
            }
        }
    }
}
