package org.setup.minecraft.instance.Game;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.setup.minecraft.GameState;
import org.setup.minecraft.Minigame;
import org.setup.minecraft.instance.Arena;

import java.util.HashMap;
import java.util.UUID;

public class BlockGame extends Game{

    private HashMap<UUID, Integer> points;

    public BlockGame(Minigame minigame, Arena arena) {
        super(minigame, arena);
        points = new HashMap<>();
    }

    public void addPoint(Player player) {
        int playerPoints = points.get(player.getUniqueId()) + 1;

        if(playerPoints == 20) {
            arena.sendMessage(ChatColor.GOLD + player.getName() + "HAS WON! Thanks for playing :)");
            arena.reset(true);
            return;
        }

        player.sendMessage(ChatColor.GREEN + "+1 POINT!");
        points.replace(player.getUniqueId(), playerPoints);
    }

    @Override
    public void onStart() {
        for(UUID uuid : arena.getPlayers()) {
            points.put(uuid, 0);
            Bukkit.getPlayer(uuid).closeInventory();
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        if(arena.getPlayers().contains(e.getPlayer().getUniqueId()) && arena.getState() == GameState.LIVE) {
            addPoint(e.getPlayer());
        }
    }
}
