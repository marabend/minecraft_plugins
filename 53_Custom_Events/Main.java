package org.setup.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getCommand("broadcast").setExecutor(new BroadcastCommand());
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onBroadcast(ServerBroadcastEvent e) {
        System.out.println("Event run: " + e.getMessage());
    }
}
