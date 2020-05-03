package de.MangoleHD.IMLobby.Commands;

import de.Iclipse.IMAPI.Util.Command.IMCommand;
import de.MangoleHD.IMLobby.Data;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

public class cmd_killlag {
    @IMCommand(
            name = "killlag",
            aliases = {"kl"},
            permissions = "im.cmd.killlag",
            description = "killlag.description",
            usage = "killlag.usage",
            maxArgs = 0
    )
    public void killlag(CommandSender sender) {
        Data.killlag = !Data.killlag;
        if (Data.killlag) {
            Bukkit.getOnlinePlayers().forEach(entry -> {
                Data.dsp.send(entry, "killlag.enabled");
            });
            Data.dsp.send(Bukkit.getConsoleSender(), "killlag.enabled");
        } else {
            Bukkit.getOnlinePlayers().forEach(entry -> {
                Data.dsp.send(entry, "killlag.disabled");
            });
            Data.dsp.send(Bukkit.getConsoleSender(), "killlag.disabled");
        }
    }
}
