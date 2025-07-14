package org.setup.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.setup.minecraft.command.ArenaCommand;
import org.setup.minecraft.listener.ConnectListener;
import org.setup.minecraft.manager.ArenaManager;
import org.setup.minecraft.manager.ConfigManager;


public class Minigame extends JavaPlugin  {

    private ArenaManager arenaManager;

    @Override
    public void onEnable() {
        ConfigManager.setupConfig(this);
        arenaManager = new ArenaManager(this);

        Bukkit.getPluginManager().registerEvents(new ConnectListener(this), this);

        getCommand("arena").setExecutor(new ArenaCommand(this));


    }

    public ArenaManager getArenaManager() {
        return arenaManager;
    }

}
