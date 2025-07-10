package org.setup.minecraft;

import org.bukkit.plugin.java.JavaPlugin;
import org.setup.minecraft.manager.ArenaManager;
import org.setup.minecraft.manager.ConfigManager;


public class Minigame extends JavaPlugin  {

    private ArenaManager arenaManager;

    @Override
    public void onEnable() {
        ConfigManager.setupConfig(this);
        arenaManager = new ArenaManager(this);
    }

    public ArenaManager getArenaManager() {
        return arenaManager;
    }

}
