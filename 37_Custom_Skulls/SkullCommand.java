package org.setup.minecraft;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.UUID;

public class SkullCommand implements CommandExecutor {

    // TODO: For this check out freshcoal.com

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {


        if(commandSender instanceof Player) {
            Player player = (Player) commandSender;

            ItemStack is = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta meta = (SkullMeta) is.getItemMeta();
            // Might only work if you use dependency spigot instead of spigot-api
            GameProfile profile = new GameProfile(UUID.randomUUID(), null);
            profile.getProperties().put("textures", new Property("textures", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDQzZDRiN2FjMjRhMWQ2NTBkZGY3M2JkMTQwZjQ5ZmMxMmQyNzM2ZmMxNGE4ZGMyNWMwZjNmMjlkODVmOGYifX19"));
            Field field;

            try {
                field = meta.getClass().getDeclaredField("profile");
                field.setAccessible(true);
                field.set(meta, profile);
            } catch(NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
                return false;
            }

            is.setItemMeta(meta);

            player.getInventory().addItem(is);
        }
        return false;
    }

    // Doesn't seem to work
    /*
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {


        if(commandSender instanceof Player) {
            Player player = (Player) commandSender;

            ItemStack is = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta meta = (SkullMeta) is.getItemMeta();
            meta.setOwningPlayer(player);
            is.setItemMeta(meta);

            player.getInventory().addItem(is);
        }
        return false;
    }
     */
}
