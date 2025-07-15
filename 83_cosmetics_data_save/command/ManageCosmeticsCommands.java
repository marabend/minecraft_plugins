package org.setup.minecraft.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.setup.minecraft.Cosmetics;
import org.setup.minecraft.instance.hats.HatType;

import java.util.ArrayList;
import java.util.List;

public class ManageCosmeticsCommands implements CommandExecutor {
    private Cosmetics cosmetics;

    public ManageCosmeticsCommands(Cosmetics cosmetics) {
        this.cosmetics = cosmetics;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 2) {
                if(Bukkit.getOfflinePlayer(args[0]) != null) {
                    try {
                        Enum.valueOf(HatType.class, args[1].toUpperCase());
                    } catch(IllegalArgumentException x) {
                        player.sendMessage(ChatColor.RED + "You specified an invalid cosmetic!");
                        return false;
                    }

                    OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);

                    HatType type = HatType.valueOf(args[1].toUpperCase());

                    List<String> owned = cosmetics.getConfig().getStringList(target.getUniqueId().toString()) != null ? cosmetics.getConfig().getStringList(target.getUniqueId().toString()) : new ArrayList<>();

                    if(owned.contains(type.name())) {
                        owned.remove(type.name());
                    }else {
                        owned.add(type.name());
                    }

                    cosmetics.getConfig().set(target.getUniqueId().toString(), owned);
                    player.sendMessage(ChatColor.GREEN + "You updated " + target.getName() + "'s cosmetics!");
                    cosmetics.saveConfig();

                } else {
                    player.sendMessage(ChatColor.RED + "Invalid user given!");
                }
            } else {
                player.sendMessage(ChatColor.RED + "Invalid usage! Use /managecosmetics <user> <cosmetic type>.");
            }
        }

        return false;
    }
}
