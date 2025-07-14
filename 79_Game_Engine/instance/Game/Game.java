package org.setup.minecraft.instance.Game;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.setup.minecraft.GameState;
import org.setup.minecraft.Minigame;
import org.setup.minecraft.instance.Arena;

public abstract class Game implements Listener {

    protected Arena arena;

    public Game(Minigame minigame, Arena arena) {
        this.arena = arena;
        Bukkit.getPluginManager().registerEvents(this, minigame);
    }

    public void start() {
        arena.setState(GameState.LIVE);
        arena.sendMessage(ChatColor.GREEN + "GAME HAS STARTED! Your objective is to break 20 blocks in the fastest time. Good luck!");

        onStart();
    }

    public abstract void onStart();

    public void unregister() {
        HandlerList.unregisterAll(this);
    }


}
