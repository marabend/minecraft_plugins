package org.setup.minecraft;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GUICommand implements CommandExecutor {



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command instanceof Player) {
            new GUI((Player) command, 1);
        }

        return false;
    }
}
