package org.setup.minecraft.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.setup.minecraft.GameState;
import org.setup.minecraft.Minigame;
import org.setup.minecraft.instance.Arena;
import org.setup.minecraft.kit.KitType;

public class GameListener implements Listener {

    private Minigame minigame;

    public GameListener(Minigame minigame) {
        this.minigame = minigame;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();

        if(e.getView().getTitle().contains("Kit Selection") && e.getInventory() != null &&  e.getCurrentItem() != null) {
            e.setCancelled(true);
            KitType type = KitType.valueOf(e.getCurrentItem().getItemMeta().getLocalizedName());
            Arena arena = minigame.getArenaManager().getArena(player);

            if(arena != null) {
                KitType activated = arena.getKitType(player);
                if(activated != null && activated == type ) {
                    player.sendMessage(ChatColor.RED + "You already have this kit equipped.");
                } else {
                    player.sendMessage(ChatColor.RED + "You have equipped the " + type.getDisplay() + ChatColor.GREEN + "kit!");
                    arena.setKit(player.getUniqueId(), type);
                }

                player.closeInventory();
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
