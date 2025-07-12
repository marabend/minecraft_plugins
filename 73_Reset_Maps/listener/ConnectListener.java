package org.setup.minecraft.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.setup.minecraft.Minigame;
import org.setup.minecraft.instance.Arena;
import org.setup.minecraft.manager.ConfigManager;

public class ConnectListener implements Listener {

    private Minigame minigame;

    public ConnectListener(Minigame minigame) {
        this.minigame = minigame;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.getPlayer().teleport(ConfigManager.getLobbySpawn());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Arena arena = minigame.getArenaManager().getArena(e.getPlayer());

        if(arena != null) {
            arena.removePlayer(e.getPlayer());
        }
    }
}
