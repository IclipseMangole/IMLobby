package de.MangoleHD.IMLobby.Commands;

import de.Iclipse.IMAPI.Data;
import de.Iclipse.IMAPI.Functions.MySQL.MySQL_User;
import de.Iclipse.IMAPI.Util.Command.IMCommand;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import org.bukkit.entity.Player;

import static de.Iclipse.IMAPI.Data.dsp;
import static de.Iclipse.IMAPI.Data.prefix;

public class cmd_friend {
    StringBuilder builder;

    @IMCommand(
            name = "friend",
            usage = "friend.usage",
            description = "friend.description",
            minArgs = 0,
            maxArgs = 0,
            noConsole = true,
            permissions = "im.cmd.friend"
    )
    public void friend(Player p){
        p.sendMessage("§7Gib §e/friend help §7ein, um mehr zu erfahren.");
    }

    @IMCommand(
            name = "help",
            usage = "friend.help.usage",
            description = "friend.help.description",
            minArgs = 1,
            maxArgs = 1,
            noConsole = true,
            permissions = "im.cmd.friend.help"
    )
    public void help(Player p){
        if(p.hasPermission("im.cmd.friend.help*")) {
            builder = new StringBuilder();
            builder.append(prefix + "§7§lHilfsübersicht:§r\n");
            add(p, "list");
            add(p, "add");
            add(p, "remove");
            add(p, "help");
            p.sendMessage(builder.toString());
        }
    }

    @IMCommand(
            name = "list",
            usage = "friend.list.usage",
            description = "friend.list.description",
            minArgs = 1,
            maxArgs = 1,
            noConsole = true,
            permissions = "im.cmd.friend.list"
    )
    public void list(Player p){

    }

    @IMCommand(
            name = "add",
            usage = "friend.add.usage",
            description = "friend.add.description",
            minArgs = 1,
            maxArgs = 1,
            noConsole = true,
            permissions = "im.cmd.friend.add"
    )
    public void add(Player p){

    }

    @IMCommand(
            name = "remove",
            usage = "friend.remove.usage",
            description = "friend.remove.description",
            minArgs = 1,
            maxArgs = 1,
            noConsole = true,
            permissions = "im.cmd.friend.remove"
    )
    public void remove(Player p){

    }
}
