package org.setup.minecraft.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
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
    public void onPlayerInteractAtEntity(PlayerInteractAtEntityEvent e) {
        if(e.getHand() == EquipmentSlot.HAND && e.getRightClicked().getType().equals(EntityType.VILLAGER) ) {
            int id = minigame.getArenaManager().getArena(e.getRightClicked().getUniqueId());
            if(id != -1) {
                Bukkit.dispatchCommand(e.getPlayer(), "arena join " + id);
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
