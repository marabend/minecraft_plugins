package org.setup.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    
    @Override
    public void onEnable() {
       Bukkit.getWorld("world").setStorm(true);
       Bukkit.getWorld("world").setThundering(true);
       Bukkit.getWorld("world").setThunderDuration(20);
       Bukkit.getWorld("world").setTime(6000);
    }

}
