package org.setup.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;


public final class Main extends JavaPlugin implements Listener {

    // Diamond Hoe = SNOWBALL LAUNCHER
    // Iron Hoe = EGG LAUNCHER

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {

        if(e.hasItem()) {
            Player player = e.getPlayer();
            if(e.getItem().getType().equals(Material.DIAMOND_HOE)) {
                player.launchProjectile(Snowball.class);
                player.sendMessage(ChatColor.GREEN + "You have shot the snowball");
            } else if(e.getItem().getType().equals(Material.IRON_HOE)) {
                player.launchProjectile(Egg.class);
                player.sendMessage(ChatColor.GREEN + "You have shot the egg!");
            }
        }

    }
}
