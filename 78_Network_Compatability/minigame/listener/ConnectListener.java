package org.setup.minecraft.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.setup.minecraft.GameState;
import org.setup.minecraft.Minigame;

public class ConnectListener implements Listener {

    private Minigame minigame;

    public ConnectListener(Minigame minigame) {
        this.minigame = minigame;
    }

    @EventHandler
    public void onLogin(PlayerLoginEvent e) {
        if(minigame.getArena().getState() == GameState.LIVE) {
            e.disallow(PlayerLoginEvent.Result.KICK_OTHER, "You cannot join this game right now as it is currently playing.");
            return;
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        minigame.getArena().addPlayer(e.getPlayer());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        minigame.getArena().removePlayer();
    }
}
