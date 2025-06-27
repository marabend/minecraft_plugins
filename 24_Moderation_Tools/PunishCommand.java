package org.setup.minecraft;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Calendar;

public class PunishCommand implements CommandExecutor {

    //punish <player name> <kick/ban/tempban>
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {

        if(commandSender instanceof Player) {
            Player player = (Player)commandSender;

            if(args.length == 2) {
                if(Bukkit.getPlayer(args[0]) != null) {
                    Player target = Bukkit.getPlayer(args[0]);
                    Calendar cal = Calendar.getInstance();
                    cal.add(Calendar.MINUTE, 1);

                    switch(args[1].toLowerCase()) {
                        case "kick":
                            target.kickPlayer(ChatColor.RED + "You have been kicked for being a bad player!");
                            break;
                        case "ban":
                            Bukkit.getBanList(BanList.Type.NAME).addBan(target.getName(), ChatColor.RED + "Being a bad player! \n Please appeal!", cal.getTime(), null);
                            target.kickPlayer(ChatColor.RED + "You have been banned!");
                            break;
                        case "tempban":
                            Bukkit.getBanList(BanList.Type.NAME).addBan(target.getName(), ChatColor.RED + "Being a bad player! \n Please appeal!", cal.getTime(), null);
                            target.kickPlayer(ChatColor.RED + "You have been temp banned!");
                            break;
                        default:
                            player.sendMessage(ChatColor.RED + "You did not specify whether to kick, ban, or tempban!");
                    }

                } else {
                    player.sendMessage(ChatColor.RED + "This player is not online");
                }
            } else {
                player.sendMessage(ChatColor.RED + "Invalid usage! Use /punish <player name> <kick/ban/tempban>");
            }
        }
        return false;
    }
}
