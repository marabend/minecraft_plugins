package org.setup.minecraft;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            ((Player)sender).sendMessage("No, this is console only!");
        } else {
            System.out.println("Hello, you have messaged the console!");
        }

        return false;
    }
}
