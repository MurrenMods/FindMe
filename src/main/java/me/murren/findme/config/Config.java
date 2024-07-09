package me.murren.findme.config;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {

    public boolean FIND;
    public boolean HIDE;
    public boolean EFIND;

    public Config(FileConfiguration config)
    {
        FIND = config.getBoolean("find");
        HIDE = config.getBoolean("hide");
        EFIND = config.getBoolean("entityfind");
    }
}
