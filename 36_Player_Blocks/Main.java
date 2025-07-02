package org.setup.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Rail;
import org.bukkit.block.data.type.Cake;
import org.bukkit.block.data.type.GlassPane;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {


    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onSneak(PlayerToggleSneakEvent e) {

        Player player = e.getPlayer();

        if(player.isSneaking() && player.getTargetBlockExact(5) != null && player.getTargetBlockExact(5).getType().equals(Material.OAK_SIGN)) {
            // player.sendBlockChange(player.getTargetBlockExact(5).getLocation(), Material.REDSTONE_BLOCK.createBlockData());
            player.sendSignChange(player.getTargetBlockExact(5).getLocation(), new String[]{
                    "This is",
                    "a",
                    "test",
                    " "
            });
        }

    }
}
