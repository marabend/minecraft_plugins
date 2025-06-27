package org.setup.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;
import org.bukkit.plugin.java.JavaPlugin;


public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.getPlayer().setResourcePack("https://Enter-URL-for-Resourcepack");
    }

    @EventHandler
    public void onResourceStatus(PlayerResourcePackStatusEvent e) {
        // if(e.getStatus().equals(PlayerResourcePackStatusEvent.Status.ACCEPTED)) {bla}
    }
}
