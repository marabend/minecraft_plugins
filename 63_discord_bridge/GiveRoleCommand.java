package org.setup.minecraft;

import net.dv8tion.jda.api.entities.Guild;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GiveRoleCommand implements CommandExecutor {

    private Main main;

    public GiveRoleCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player) {
            Guild guild = main.getJda().getGuildById("2342342343");
            guild.addRoleToMember("234234234234324", guild.getRoleById("23424234")).queue();
            guild.getTextChannelById("23423412341234").sendMessage("Successfully given :) ").queue();
            ((Player) command).sendMessage("All sorted!");
        }

        return false;
    }
}
