package org.setup.minecraft;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Player player;
        player.spawnParticle(Particle.DRIPPING_LAVA, player.getLocation(), 5);
    }
}
