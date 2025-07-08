package org.setup.minecraft;

import org.bukkit.plugin.java.JavaPlugin;


public final class Main extends JavaPlugin{

    @Override
    public void onEnable() {
        if(this.getDataFolder().exists()) {
            this.getDataFolder().mkdir();
        }

        getCommand("playsong").setExecutor(new PlaySongCommand(this));
    }
}
