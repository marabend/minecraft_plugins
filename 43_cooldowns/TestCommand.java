package org.setup.minecraft;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class TestCommand implements CommandExecutor {

    private Cache<UUID, Long> cooldown = CacheBuilder.newBuilder().expireAfterWrite(5, TimeUnit.SECONDS).build();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(!cooldown.asMap().containsKey(player.getUniqueId())) {
                player.sendMessage(ChatColor.GREEN + "Test worked!");
                cooldown.put(player.getUniqueId(), System.currentTimeMillis() + 5000);
            } else {
                long distance = cooldown.asMap().get(player.getUniqueId()) - System.currentTimeMillis();
                player.sendMessage(ChatColor.RED + "You must wait!" + TimeUnit.MICROSECONDS.toSeconds(distance) + " seconds to use this again!");
            }
        }

        return false;
    }
}
