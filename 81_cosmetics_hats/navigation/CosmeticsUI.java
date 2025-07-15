package org.setup.minecraft.navigation;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class CosmeticsUI {

    public CosmeticsUI(Player player) {
        Inventory inv = Bukkit.createInventory(null, 27, ChatColor.GOLD.toString() + ChatColor.BOLD + "Cosmetics Menu");

        ItemStack hats = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta hatsMeta = hats.getItemMeta();
        hatsMeta.setDisplayName(ChatColor.AQUA.toString() + ChatColor.BOLD + "Hats");
        hatsMeta.setLore(Arrays.asList(ChatColor.GRAY + "Puts custom skull on your head!"));
        hats.setItemMeta(hatsMeta);

        inv.addItem(hats);
        player.openInventory(inv);
    }
}
