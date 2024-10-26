package org.setup.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;


public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        ItemStack itemStack = new ItemStack(Material.CARROT,3);
        ItemMeta meta = itemStack.getItemMeta();
        itemStack.setItemMeta(meta);

        Block block = Bukkit.getWorld("world").getBlockAt(15,60,42);
        block.getType().equals(Material.CARROT);

        Bukkit.getWorld("world").getBlockAt(1,1,1).setType(Material.LAVA);
    }
}
