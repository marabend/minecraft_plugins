package org.setup.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.MapInitializeEvent;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {


    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onMapInitialize(MapInitializeEvent e) {
        MapView view = e.getMap();

        for(MapRenderer renderer: view.getRenderers()) {
            view.removeRenderer(renderer);
        }

        view.addRenderer(new Renderer());
    }

}
