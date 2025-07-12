package org.setup.minecraft.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.setup.minecraft.GameState;
import org.setup.minecraft.Minigame;
import org.setup.minecraft.instance.Arena;

public class GameListener implements Listener {

    private Minigame minigame;

    public GameListener(Minigame minigame) {
        this.minigame = minigame;
    }

    @EventHandler
    public void onSignClick(PlayerInteractEvent e) {
        if(e.getHand().equals(EquipmentSlot.HAND) && e.hasBlock() && e.getClickedBlock().getType().equals(Material.OAK_WALL_SIGN)) {
            Arena arena = minigame.getArenaManager().getArena(e.getClickedBlock().getLocation());
            if(arena != null) {
                Bukkit.dispatchCommand(e.getPlayer(), "arena join " + arena.getId());
            }
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Arena arena = minigame.getArenaManager().getArena(e.getPlayer());

        if(arena != null && arena.getState().equals(GameState.LIVE)) {
            arena.getGame().addPoint(e.getPlayer());
        }
    }
}
