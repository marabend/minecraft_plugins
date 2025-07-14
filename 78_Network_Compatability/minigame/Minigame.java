package org.setup.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.setup.minecraft.instance.Arena;
import org.setup.minecraft.listener.ConnectListener;
import org.setup.minecraft.listener.GameListener;
import org.setup.minecraft.manager.ConfigManager;

public class Minigame extends JavaPlugin  {

    private Arena arena;

    @Override
    public void onEnable() {
        ConfigManager.setupConfig(this);
        arena = new Arena(this);

        Bukkit.getPluginManager().registerEvents(new ConnectListener(this), this);
        Bukkit.getPluginManager().registerEvents(new GameListener(this), this);
    }

    public Arena getArena() {
        return arena;
    }

}
