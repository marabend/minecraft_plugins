package org.setup.minecraft;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin  {

    @Override
    public void onEnable() {
        new TestCommand();
    }
}
