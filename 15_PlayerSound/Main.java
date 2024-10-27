package org.setup.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.java.JavaPlugin;


public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this,this);
    }

    @EventHandler
    public void onSneak(PlayerToggleSneakEvent e) {
        e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENTITY_ARMOR_STAND_FALL, 1.0F, 1.0F);
      //  Bukkit.getWorld("world").playSound(); // Will be heared by any player on the map
    }

}
