package org.setup.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

/*
TODO: Compiles fine, but does GUI does not show up

 */

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getCommand("gui").setExecutor(new GUICommand());
        Bukkit.getPluginManager().registerEvents(new GUIListener(), this);
    }
}
