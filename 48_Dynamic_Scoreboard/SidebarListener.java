package org.setup.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.*;

import java.util.HashMap;
import java.util.UUID;

public class SidebarListener implements Listener {

    private HashMap<UUID, Integer> blocksBrokenMap = new HashMap<>();

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = board.registerNewObjective("testboard","dummy");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName(ChatColor.GREEN.toString() + ChatColor.BOLD + "Test Board!");

        Score website = obj.getScore(ChatColor.YELLOW + "www.testwebsite.com");

        website.setScore(1);

        Score space = obj.getScore("");
        space.setScore(2);

        Team blocksBroken = board.registerNewTeam("blocksbroken");
        blocksBroken.addEntry(ChatColor.BOLD. toString());
        blocksBroken.setPrefix(ChatColor.BLUE + "Blocks broken: ");
        blocksBroken.setSuffix(ChatColor.YELLOW +  "0");
        obj.getScore(ChatColor.BOLD. toString()).setScore(3);
        // Blocks broken: 5
        // Blocks broken:
        // 5

        player.setScoreboard(board);

        blocksBrokenMap.put(player.getUniqueId(), 0);
    }

    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent e) {
        Player player = e.getPlayer();
        int amount = blocksBrokenMap.get(player.getUniqueId());
        amount ++;

        blocksBrokenMap.put(player.getUniqueId(), amount);
        player.getScoreboard().getTeam("blocksbroken").setSuffix(ChatColor.YELLOW.toString() + amount);
    }
}
