package org.setup.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;


public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onEntityInteract(PlayerJoinEvent e) {
        System.out.println(e.getPlayer().getStatistic(Statistic.DROP_COUNT));
        System.out.println(e.getPlayer().getStatistic(Statistic.CRAFT_ITEM, Material.LEATHER_LEGGINGS));
        e.getPlayer().incrementStatistic(Statistic.DROP_COUNT, 1);
        System.out.println(e.getPlayer().getStatistic(Statistic.DROP_COUNT));
    }
}
