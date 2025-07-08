package org.examples.untitled;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class APITest extends JavaPlugin {

    TestPlugin api;

    @Override
    public void onEnable() {
        api = (TestPlugin) Bukkit.getPluginManager().getPlugin("TestPlugin");
        System.out.println(api.getWord());
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        api.sendMessage(e.getPlayer());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
