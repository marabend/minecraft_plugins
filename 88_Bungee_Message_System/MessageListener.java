package org.examples.network.listener;

import org.examples.network.Network;

public class MessageListener implements Listener{

    private Network network;

    public MessageListener(Network network) {
        this.network = network;
    }

    @EventHandler
    public void onQuit(PlayerDisconnectEvent e) {
        if(network.getRecentMessages().containsKey(e.getPlayer().getUniqueId())) {
            network.getRecentMessages().remove(e.getPlayer().getUniqueId());
        }
    }
}
