package org.setup.minecraft.navigation;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.setup.minecraft.Cosmetics;
import org.setup.minecraft.instance.Cosmetic;

public class CosmeticListener implements Listener {

    private Cosmetics cosmetics;

    public CosmeticListener(Cosmetics cosmetics) {
        this.cosmetics = cosmetics;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {

        if(e.getInventory() != null && e.getCurrentItem() != null) {
            if(e.getView().getTitle().endsWith("Cosmetics Menu!")) {

            }
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {

        Player player = e.getPlayer();

        if(cosmetics.getActiveCosmetics().containsKey(player.getUniqueId())) {
            for(Cosmetic cosmetic : cosmetics.getActiveCosmetics().get(player.getUniqueId())) {
                cosmetic.disable();
            }
            cosmetics.getActiveCosmetics().remove(player.getUniqueId());
        }
    }

}
