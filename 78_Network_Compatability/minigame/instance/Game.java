package org.setup.minecraft.instance;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.setup.minecraft.GameState;

import java.util.HashMap;
import java.util.UUID;

public class Game {

    private Arena arena;
    private HashMap<UUID, Integer> points;

    public Game(Arena arena) {
        this.arena = arena;
        points = new HashMap<>();
    }

    public void start() {
        arena.setState(GameState.LIVE);
        arena.sendMessage(ChatColor.GREEN + "GAME HAS STARTED! Your objective is to break 20 blocks in the fastest time. Good luck!");

        for(Player player : Bukkit.getOnlinePlayers()) {
            points.put(player.getUniqueId(), 0);
        }
    }

    public void addPoint(Player player) {
        int playerPoints = points.get(player.getUniqueId()) + 1;

        if(playerPoints == 20) {
            arena.sendMessage(ChatColor.GOLD + player.getName() + "HAS WON! Thanks for playing :)");
            arena.reset();
            return;
        }

        player.sendMessage(ChatColor.GREEN + "+1 POINT!");
        points.replace(player.getUniqueId(), playerPoints);
    }

}
