package org.setup.minecraft;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class NameTagListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        NameTagManager.setNametags(e.getPlayer());
        NameTagManager.newTag(e.getPlayer());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        NameTagManager.removeTag(e.getPlayer());
    }
}
