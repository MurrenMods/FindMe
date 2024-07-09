package me.murren.findme;

import me.murren.findme.config.Config;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class FindMe extends JavaPlugin {

    private static Config config;
    public static Config config() {
        return config;
    }

    public static ArrayList<Player> hiddenPlayers = new ArrayList<>();

    @Override
    public void onEnable() {
        saveDefaultConfig();
        config = new Config(getConfig());
        this.getCommand("find").setExecutor(new FindMeCommand());
        this.getCommand("hideme").setExecutor(new HideMeCommand());
        this.getCommand("findentity").setExecutor(new EntityFindMeCommand());
        this.getCommand("findentity").setTabCompleter(new EntityFindMeTabCompleter());
        getLogger().info("[FINDME] Plugin successfully enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("[FINDME] Plugin successfully disabled!");
    }



}
