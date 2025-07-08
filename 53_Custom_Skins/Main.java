package org.setup.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

// Skin website: https://mineskin.org/

/*
    This example only works if you use the spigot package, instead of the spigot-api
 */


public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        setSkin(e.getPlayer());
    }

    private void setSkin(Player player) {
        EntityPlayer ep = ((CraftPlayer) player).getHandle();
        GameProfile gp = new ep.getPRofile();
        PropertyMap pm = gp.getPRoperties();
        Property property = pm.get("textures").iterator().next();
        pm.remove("textures", property);
        pm.put("textures", new Property("textures", "hash", ""));
    }
}
