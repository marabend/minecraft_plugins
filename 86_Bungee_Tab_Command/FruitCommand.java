package org.examples.network;

import java.util.ArrayList;
import java.util.List;

public class FruitCommand extends Command implements TabExecutor{

    public FruitCommand() {
        super("fruit");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

    }

    @Override
    public Iterable<String> onTAbComplete(CommandSender sender, String[] args) {
        List<String> results = new ArrayList<>();

        if(args.length == 1) {
            results.add("Grape");
            results.add("Apple");
            results.add("Pear");
            results.add("Kiwi");
            return results.stream().filter(val -> val.toLowerCase().startsWith(args[0].toLowerCase()]).collect(Collectors.toList()));
        } else if(args.length == 2) {
            for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()) {
                results.add(player.getName());
            }
            return results.stream().filter(val -> val.toLowerCase().startsWith(args[1].toLowerCase()]).collect(Collectors.toList()));
        }

        return results;
    }
}
