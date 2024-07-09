package me.murren.findme;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

public class FindMeCommand implements CommandExecutor {

    private static Random random = new Random();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if(!FindMe.config().FIND)
        {
            commandSender.sendMessage("§cFinding is disabled!");
            return true;
        }
        if(args.length < 1)
        {
            commandSender.sendMessage("§cUsage: /find <player>");
            return true;
        }

        Player p = Bukkit.getPlayer(args[0]);
        if (p == null || !commandSender.getServer().getOnlinePlayers().contains(Bukkit.getPlayer(args[0]))) {
            commandSender.sendMessage("§cPlayer not found");
            return true;
        }

        Block loc = p.getLocation().getBlock();
        int x = loc.getX();
        int y = loc.getY();
        int z = loc.getZ();
        String world = p.getWorld().getName();

        if (FindMe.hiddenPlayers.contains(p) && commandSender instanceof Player) {
            x = random.nextInt(3000);
            y = random.nextInt(154) - 50;
            z = random.nextInt(3000);
            int worldi = random.nextInt(3);
            switch (worldi) {
                case 0:
                    world = "world";
                    break;
                case 1:
                    world = "world_nether";
                    break;
                case 2:
                    world = "world_the_end";
                    break;
            }
        }

        String position = "X=" + x + ", Y=" + y + ", Z=" + z;
        if (world.equals("world")) { world = "overworld"; }
        commandSender.sendMessage("§ePlayer is at " + position + " in world " + world);
        p.sendMessage("§6" + commandSender.getName() + " §eused /find on you!");
        Player player = (Player) commandSender;
        float distance = (float) Math.sqrt(Math.pow(player.getLocation().getBlock().getX() - x, 2) + Math.pow(player.getLocation().getBlock().getY() - y, 2) + Math.pow(player.getLocation().getBlock().getZ() - z, 2));
        commandSender.sendMessage("§eDistance: " + distance + (distance < 128 ? " §r(§cspawnable§r)" : " §r(§6Not spawnable§r)"));
        return true;
    }
}
