package org.setup.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;


public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPinkt(ServerListPingEvent e) throws Exception {
        e.setMaxPlayers(42000);
        e.setMotd(ChatColor.AQUA + "Welcome to the server!\n" + ChatColor.WHITE + "We hope you have a good time!");
        // 64 x 64
        e.setServerIcon(Bukkit.loadServerIcon(new File("icon.png")));
    }
}
