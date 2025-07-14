package org.setup.minecraft.instance;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.setup.minecraft.GameState;
import org.setup.minecraft.Minigame;
import org.setup.minecraft.manager.ConfigManager;

public class Arena {

    private Minigame minigame;

    private Location spawn;

    private GameState state;
    private Countdown countdown;
    private Game game;

    public Arena(Minigame minigame) {
        FileConfiguration config = minigame.getConfig();

        spawn =new Location(
                Bukkit.getWorld(config.getString("arena.world")),
                config.getDouble("arenas.x"),
                config.getDouble("arenas.y"),
                config.getDouble("arenas.z"),
                (float) config.getDouble("arena.yaw"),
                (float) config.getDouble("arena.pitch")
        );

        this.minigame = minigame;
        this.state = GameState.RECRUITING;
        this.countdown = new Countdown(minigame, this);
        this.game = new Game(this);
    }

    /* GAME */

    public void start() {
        game.start();
    }

    public void reset() {

        sendTitle("", "");
        state = GameState.RECRUITING;
        countdown.cancel();
        countdown = new Countdown(minigame, this);
        game = new Game(this);
        if(Bukkit.getOnlinePlayers().size() >= ConfigManager.getRequiredPlayers()) {
            countdown.start();
        }
    }

    /* TOOLS */

    public void sendMessage(String message) {
        for(Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage(message);
        }
    }

    public void sendTitle(String title, String subtitle) {
        for(Player player : Bukkit.getOnlinePlayers()) {
            player.sendTitle(title, subtitle);
        }
    }

    /* PLAYERS */

    public void addPlayer(Player player) {
        player.teleport(spawn);

        if(state.equals(GameState.RECRUITING) && Bukkit.getOnlinePlayers().size() >= ConfigManager.getRequiredPlayers()) {
            countdown.start();
        }

    }

    public void removePlayer() {

        if(state == GameState.COUNTDOWN && Bukkit.getOnlinePlayers().size()  -1 < ConfigManager.getRequiredPlayers()) {
            sendMessage(ChatColor.RED + "There is not enough players. Countdown stopped.");
            reset();
            return;
        }

        if(state == GameState.LIVE && Bukkit.getOnlinePlayers().size() - 1 < ConfigManager.getRequiredPlayers()) {
            sendMessage(ChatColor.RED + "The game has ended as too many players have left.");
            reset();
        }
    }

    /* INFO */

    public GameState getState() {
        return state;
    }

    public Game getGame() {
        return game;
    }

    public void setState(GameState state) {
        this.state = state;
    }
}
