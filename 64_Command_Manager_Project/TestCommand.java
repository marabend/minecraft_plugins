package org.setup.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import java.util.List;

public class TestCommand extends Command{

    public TestCommand() {
        super(
                "test",
                new String[] {"cake", "banana"},
                "A really cool command!",
                "test.test"
        );
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Bukkit.broadcastMessage("You command manager works!");
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {
        return List.of();
    }
}
