package me.murren.findme;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import java.util.ArrayList;
import java.util.List;

public class EntityFindMeCommand implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(!FindMe.config().EFIND)
        {
            commandSender.sendMessage("§cEntity finding is disabled!");
            return true;
        }

        if(args.length < 1)
        {
            commandSender.sendMessage("§cUsage: /find <entitytype> [compact|default]");
            return true;
        }
        boolean compact = args.length == 2 && args[1].equalsIgnoreCase("compact");
        EntityType type;
        try {
             type = EntityType.valueOf(args[0].toUpperCase());
        }
        catch(IllegalArgumentException e)
        {
            commandSender.sendMessage("§cInvalid entity type");
            return true;
        }

        int count = 0;
        List<World> worlds = Bukkit.getServer().getWorlds();
        List<Entity> found = new ArrayList<>();
        for(World world : worlds)
        {
            for(Entity entity : world.getEntities())
            {
                if(entity.getType().equals(type))
                {
                    count++;
                    if(compact) {continue;}
                    found.add(entity);
                }
            }
        }

        if(count == 0)
        {
            commandSender.sendMessage("§cNo entities found");
            return true;
        }
        commandSender.sendMessage("§eFound " + count + " " + args[0].toLowerCase() + "s:");
        if(compact){return true;}
        found.forEach(entity -> {
            commandSender.sendMessage("§e" + entity.getName() +
                                         " at X=" + entity.getLocation().getBlock().getX() +
                                         ", Y=" + entity.getLocation().getBlock().getY() +
                                         ", Z=" + entity.getLocation().getBlock().getZ() +
                                         " in world " + entity.getWorld().getName());
        });
        return true;
    }
}
