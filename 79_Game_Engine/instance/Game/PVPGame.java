package org.setup.minecraft.instance.Game;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.setup.minecraft.GameState;
import org.setup.minecraft.Minigame;
import org.setup.minecraft.instance.Arena;

import java.util.HashMap;
import java.util.UUID;

public class PVPGame extends Game{

    private HashMap<UUID, Integer> points;

    public PVPGame(Minigame minigame, Arena arena) {
        super(minigame, arena);
        points = new HashMap<>();
    }

    public void giveKill(Player player) {
        arena.sendMessage(ChatColor.RED + player.getName() + "HAS WON WITH 1 KILL! Thanks for playing :)");
        arena.reset(true);
    }

    @Override
    public void onStart() {
       for(UUID uuid : arena.getPlayers()) {
           Bukkit.getPlayer(uuid).getInventory().addItem(new ItemStack(Material.IRON_SWORD));
       }
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        if(arena.getPlayers().contains(e.getEntity()) && arena.getPlayers().contains(e.getEntity().getKiller()) && arena.getState() == GameState.LIVE) {
            giveKill(e.getEntity().getKiller());
        }
    }
}
