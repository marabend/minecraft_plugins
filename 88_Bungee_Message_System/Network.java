package org.examples.network;

import net.md_5.bungee.api.plugin.Plugin;
import org.examples.network.command.MessageCommand;
import org.examples.network.command.ReplyCommand;
import org.examples.network.listener.MessageListener;

import java.util.HashMap;
import java.util.UUID;


public final class Network extends Plugin implements Listener{

    private HashMap<UUID, UUID> recentMessages;
    @Override
    public void onEnable() {
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new MessageCommand(this));
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new ReplyCommand(this));
        ProxyServer.getInstance().getPluginManager().registerListener(this, new MessageListener(this));
        recentMessages = new HashMap<>();
    }

    public HashMap<UUID, UUID> getRecentMessages() {
        return recentMessages;
    }

}
