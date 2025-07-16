package org.examples.network;

import net.md_5.bungee.api.plugin.Plugin;


public final class Network extends Plugin implements Listener{

    @Override
    public void onEnable() {
        getProxy().getPluginManager().registerCommand(this, new FruitCommand());
    }

}
