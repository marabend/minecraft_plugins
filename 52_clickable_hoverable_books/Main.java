package org.setup.minecraft;

import org.bukkit.plugin.java.JavaPlugin;


public final class Main extends JavaPlugin  {
    
    @Override
    public void onEnable() {
        getCommand("book").setExecutor(new BookCommand());
    }
}
