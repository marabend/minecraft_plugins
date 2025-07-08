package org.setup.minecraft;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

public class FillCommand implements CommandExecutor {

    private Cuboid cuboid;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            cuboid = new Cuboid(
                    new Location(Bukkit.getWorld("world"), 28 , 71 , 14),
                    new Location(Bukkit.getWorld("world"), 36 , 73, 18)
            );

            for(Block block : cuboid.getBlocks()) {
                block.setType(Material.DIAMOND_BLOCK);
            }
        }
        return false;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        if(cuboid.contains(e.getPlayer().getLocation())) {
            e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("In the region!"));
        }
    }
}
