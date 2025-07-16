package org.examples.network;

import net.md_5.bungee.api.plugin.Plugin;

import java.util.concurrent.TimeUnit;

public final class Network extends Plugin implements Listener{

    @Override
    public void onEnable() {
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new PingCommand());
        ProxyServer.getIntance().getPluginManager().registerListener(this, this);

        ProxyServer.getInstance().getScheduler().schedule(this, () -> {
            System.out.println("Scheduler RAN!");
        }, 10, 5, TimeUnit.SECONDS);
    }

    @EventHandler
    public void onPostLogin(LoginEvent e) {
        e.getPlayer().sendMessage("Post login event worked!");
    }

}
