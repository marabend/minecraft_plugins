package org.setup.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;


public final class Main extends JavaPlugin implements Listener {
    
    private static final String PLAYER_NAME = "Enter your PLAYERNAME";

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this,this);
    }

    @EventHandler
    public void onSneak(PlayerToggleSneakEvent e) {
       List<Player> players =  Bukkit.getWorld("world").getPlayers();

       Player self = null;
       for(Player player : players) {
           if(player.getName().equals(PLAYER_NAME)) {
               self = player;
           }
       }

       List<Entity> entities = null;
       if(self != null) {
            entities = self.getNearbyEntities(self.getLocation().getX(), self.getLocation().getY(), self.getLocation().getZ());
       }

       if(entities != null) {
           for(Entity entity : entities) {
               entity.setVisibleByDefault(true);
               entity.setVisualFire(true);
           }
       }
    }
}
