package org.setup.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {


    @Override
    public void onEnable() {
         getCommand("menu").setExecutor(new MenuCommand());
        Bukkit.getPluginManager().registerEvents(new MenuListener(), this);
    }
}
