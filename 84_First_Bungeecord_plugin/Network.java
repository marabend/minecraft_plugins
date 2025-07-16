package org.examples.network;

import net.md_5.bungee.api.plugin.Plugin;

public final class Network extends Plugin {

    @Override
    public void onEnable() {
        System.out.println("My plugin has loaded!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
