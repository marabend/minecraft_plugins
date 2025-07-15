package org.setup.minecraft.navigation;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class CosmeticsUI {

    public CosmeticsUI(Player player) {
        Inventory inv = Bukkit.createInventory(null, 27, ChatColor.GOLD.toString() + ChatColor.BOLD + "Cosmetics Menu");
        player.openInventory(inv);
    }
}
