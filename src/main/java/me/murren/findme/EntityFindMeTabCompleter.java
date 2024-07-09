package me.murren.findme;

import me.murren.findme.util.EntityTypes;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EntityFindMeTabCompleter implements TabCompleter {

    private final List<String> empty = new ArrayList<>();
    private final List<String> options = Arrays.asList("compact", "default");

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        if(args.length == 1)
        {
            return EntityTypes.getAllEntityTypes();
        }
        if(args.length == 2)
        {
            return options;
        }
        return empty;
    }
}
