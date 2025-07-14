package org.examples.lobby;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.examples.lobby.listener.ConnectListener;
import org.examples.lobby.manager.ConfigManager;

public final class Lobby extends JavaPlugin {

    @Override
    public void onEnable() {
        ConfigManager.setupConfig(this);
        Bukkit.getPluginManager().registerEvents(new ConnectListener(), this);

    }

}
