package org.setup.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;


public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onEntityInteract(PlayerInteractEntityEvent e) {

        if(e.getPlayer().isSneaking()) {
            e.getPlayer().addPassenger(e.getRightClicked());
            } else {
                e.getRightClicked().addPassenger(e.getPlayer());
            }
        }
    }
