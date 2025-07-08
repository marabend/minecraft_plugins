package org.setup.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;


public final class Main extends JavaPlugin implements Listener {
    
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        ItemStack is = new ItemStack(Material.PAPER);
        ItemMeta meta = is.getItemMeta();
        meta.setCustomModelData(1234567);
        is.setItemMeta(meta);

        e.getPlayer().getInventory().addItem(is);

    }
}
