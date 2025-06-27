package org.setup.minecraft;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("banner").setExecutor(new BannerCommand());
    }
}
