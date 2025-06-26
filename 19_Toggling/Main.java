package org.setup.minecraft;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ToggleListener implements Listener {

    // List<UUID> enabled = new ArrayList<>();
    private boolean enabled = true;

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {

        Player player = e.getPlayer();

        if(e.getHand().equals(EquipmentSlot.HAND)) {
            if(player.getInventory().getItemInMainHand() != null && player.getInventory().getItemInMainHand().getType().equals(Material.NETHER_STAR)) {
                if(enabled) {
                    enabled = false;
                    player.sendMessage("You have disabled the chat!");
                } else {
                    enabled = true;
                    player.sendMessage("You have enabled the chat!");
                }
            }
        }
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {

        if(!enabled) {
            e.setCancelled(true);
            e.getPlayer().sendMessage("Chat is disabled right now!");
        }
    }
}
