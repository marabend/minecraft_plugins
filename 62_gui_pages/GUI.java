package org.setup.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GUI {

    public GUI(Player player, int page) {
        Inventory gui = Bukkit.createInventory(null, 54, "Page Text - " + page);

        List<ItemStack> allItems = new ArrayList<>();

        for(int i=0; i<135; i++) {
            allItems.add(new ItemStack(Material.ENDER_PEARL));
        }

        ItemStack left;
        ItemMeta leftMeta;

        if(PageUtil.isPageValid(allItems, page - 1, 52)) {
            left = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
            leftMeta = left.getItemMeta();
            leftMeta.setDisplayName(ChatColor.GREEN + "GO PAGE LEFT!");
        } else {
            left = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            leftMeta = left.getItemMeta();
            leftMeta.setDisplayName(ChatColor.RED + "GO PAGE LEFT!");
        }

        leftMeta.setLocalizedName(page + "");
        left.setItemMeta(leftMeta);
        gui.setItem(0,left);

        ItemStack right;
        ItemMeta rightMeta;

        if(PageUtil.isPageValid(allItems, page + 1, 52)) {
            right = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
            rightMeta = right.getItemMeta();
            rightMeta.setDisplayName(ChatColor.GREEN + "GO PAGE RIGHT!");
        } else {
            right = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            rightMeta = right.getItemMeta();
            rightMeta.setDisplayName(ChatColor.RED + "GO PAGE RIGHT!");
        }

        right.setItemMeta(rightMeta);
        gui.setItem(8, right);

        for(ItemStack is : PageUtil.getPageItems(allItems, page, 52)) {
            gui.setItem(gui.firstEmpty(), is);
        }

        player.openInventory(gui);
    }

}
