package org.setup.minecraft;

import org.bukkit.plugin.java.JavaPlugin;


public final class Main extends JavaPlugin{

    @Override
    public void onEnable() {
        getCommand("broadcast").setExecutor(new BroadCastCommand(this));
    }
}
