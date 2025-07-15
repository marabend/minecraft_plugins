package org.setup.minecraft.navigation;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.setup.minecraft.Cosmetics;

public class CosmeticsCommand implements CommandExecutor {

    private Cosmetics cosmetics;

    public CosmeticsCommand(Cosmetics cosmetics) {
        this.cosmetics = cosmetics;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            new CosmeticsUI((Player) sender);
        }

        return false;
    }
}
