package org.setup.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class SpawnMonsterCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            sender.sendMessage("A polar bear has been spawned");
            Bukkit.getWorld("world").spawnEntity(((Player) sender).getLocation(), EntityType.POLAR_BEAR);
        }

        return false;
    }
}
