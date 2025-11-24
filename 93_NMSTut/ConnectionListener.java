package org.setup.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ConnectionListener implements Listener {

    private Main main;

    public ConnectionListener(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        main.inject(e.getPlayer());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        main.stop(e.getPlayer());
    }


}
