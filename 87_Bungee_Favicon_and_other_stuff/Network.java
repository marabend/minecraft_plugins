package org.examples.network;

import net.md_5.bungee.api.plugin.Plugin;


public final class Network extends Plugin implements Listener{

    private Favicon favicon;

    @Override
    public void onEnable() {

        try {
            favicon = Favicon.create(ImageIO.read(new File("favicon.png")));
        } catch(IOException e) {

        }


        getProxy().getPluginManager().registerListener(this, this);
    }

    @EventHandler
    public void onProxyPing(ProxyPingEvent e) {
        ServerPing ping = e.getResponse();
        ping.setDescription(ChatColor.BLUE + "Line1\n" + ChatColor.GREEN + "Line twoooo!");
        ping.setPlayers(new ServerPing.Players(1000, 5, ping.getPlayers().getSample()));
        ping.setVersion(new ServerPing.Protocol("Connect with 1.16.5", 754));
        ping.setFacicon();

        e.setResponse(ping);

    }

}
