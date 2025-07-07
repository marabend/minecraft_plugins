package org.setup.minecraft;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

import java.util.HashMap;
import java.util.UUID;

public class PermsCommand implements CommandExecutor {

    private HashMap<UUID, PermissionAttachment> perms = new HashMap<>();

    private Main main;

    public PermsCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {

           Player player = ((Player) sender).getPlayer();

            PermissionAttachment attachment;

           if(!perms.containsKey(player.getUniqueId())) {
               attachment = player.addAttachment(main);
               perms.put(player.getUniqueId(), attachment);
           } else {
               attachment = perms.get(player.getUniqueId());
           }

           if(player.hasPermission("worldedit.help")) {
               attachment.unsetPermission("worldedit.help");
               player.sendMessage("Removed perms!");
           } else {
               attachment.setPermission("worldedit.help", true);
               player.sendMessage("Added perms!");
           }

        }

        return false;
    }
}
