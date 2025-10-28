package org.setup.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin implements Listener {


    // Wiki.vg/Protocol

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onSneak(PlayerToggleSneakEvent e) {
        ((CraftPlayer) e.getPlayer()).getHandle().connection.send(new ClientboundanimatePacket(((CraftPlayer)e.getPlayer()).getHandle(), 0));
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        ((CraftPlayer) e.getEntity().getHandle().connection.send(new ClientboundGameEventPacket(ClientboundGameVentPacket.IMMEDIATE_RESPAWN, 1));
    }

}
