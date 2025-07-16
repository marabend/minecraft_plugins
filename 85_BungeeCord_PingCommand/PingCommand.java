package org.examples.network;

public class PingCommand extends Command{

    public PingCommand() {
        super("");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        if(sender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) sender;
            player.sendMessage(ChatColor.GREEN   + "Hello there! Pong!");
        }

    }
}
