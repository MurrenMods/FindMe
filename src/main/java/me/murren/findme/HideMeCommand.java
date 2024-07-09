package me.murren.findme;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HideMeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!FindMe.config().HIDE)
        {
            commandSender.sendMessage("§cHiding is disabled!");
            return true;
        }

        if(!(commandSender instanceof Player))
        {
            commandSender.sendMessage("§cOnly players can use this command");
            return true;
        }
        Player p = (Player) commandSender;
        if(FindMe.hiddenPlayers.contains(p))
        {
            FindMe.hiddenPlayers.remove(p);
            commandSender.sendMessage("§eYou are now findable.");
            return true;
        }
        else {
            FindMe.hiddenPlayers.add(p);
            commandSender.sendMessage("§eYou are now hidden.");
        }
        return true;
    }
}
