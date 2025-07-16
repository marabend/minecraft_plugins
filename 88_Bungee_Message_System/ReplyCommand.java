package org.examples.network.command;

import org.examples.network.Network;

public class ReplyCommand extends Command {

    private Network network;

    public ReplyCommand(Network network) {
        super("reply");
        this.network = network;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) sender;

            if(args.length >= 1) {
                if(network.getRecentMessages().containsKey(player.getUniqueId())) {
                    ProxiedPlayer target = ProxyServer.getInstance().getPlayer(network.getRecentMessages().get(player.getUniqueId()));
                    if(target != null) {
                        StringBuilder builder = new StringBuilder();

                        for(int i = 0; i< args.length; i++) {
                            builder.append(args[i] + " ");
                        }

                        player.sendMessage("You -> " + target.getName() + ": " + builder);
                        target.sendMessage(player.getName() + " -> You: " + builder);
                    } else {
                        player.sendMessage(ChatColor.RED + "This player has gone offline since you last messaged.");
                        netework.getRecentMessages().remove(player.getUniqueId());
                    }
                } else {
                    player.sendMessage(ChatColot.RED + "You have not messaged anyone recently");
                }
            } else {
                player.sendMessage(ChatColor.RED + "Invalid usage! Please use /reply <message>");
            }
        }
    }


}
