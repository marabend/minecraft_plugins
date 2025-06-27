package org.setup.minecraft;

import org.bukkit.plugin.java.JavaPlugin;


public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("punish").setExecutor(new PunishCommand());
    }
}
