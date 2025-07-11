package org.setup.minecraft.listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.setup.minecraft.GameState;
import org.setup.minecraft.Minigame;
import org.setup.minecraft.instance.Arena;
import org.setup.minecraft.instance.Game;
import org.setup.minecraft.instance.Team;

public class GameListener implements Listener {

    private Minigame minigame;

    public GameListener(Minigame minigame) {
        this.minigame = minigame;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Arena arena = minigame.getArenaManager().getArena(e.getPlayer());

        if (arena != null && arena.getState().equals(GameState.LIVE)) {
            Game game = arena.getGame();
            if (e.getBlock().getType() == Material.RED_BED && e.getBlock().hasMetadata("team")) {
                e.setCancelled(game.destroyBed(Team.valueOf(e.getBlock().getMetadata("team").get(0).asString()), e.getPlayer()));
            }

        }
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        Arena arena = minigame.getArenaManager().getArena(e.getEntity());
        if (arena != null && arena.getState().equals(GameState.LIVE)) {
            Game game = arena.getGame();
            game.death(e.getEntity());
        }
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e) {
        Arena arena = minigame.getArenaManager().getArena(e.getPlayer());
        if (arena != null && arena.getState().equals(GameState.LIVE)) {
            e.setRespawnLocation(arena.getGame().respawn(e.getPlayer()));
        }
    }
}
