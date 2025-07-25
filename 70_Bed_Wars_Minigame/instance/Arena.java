package org.setup.minecraft.instance;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.setup.minecraft.GameState;
import org.setup.minecraft.Minigame;
import org.setup.minecraft.manager.ConfigManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Arena {

    private Minigame minigame;

    private int id;
    private int yRespawn;

    private HashMap<Team, Location> spawns;
    private HashMap<Team, BedLocation> beds;

    private GameState state;
    private List<UUID> players;
    private Countdown countdown;
    private Game game;

    public Arena(Minigame minigame, int id, int yRespawn, HashMap<Team, Location> spawns, HashMap<Team, BedLocation> beds ) {
        this.minigame = minigame;
        this.id = id;
        this.yRespawn = yRespawn;
        this.id = yRespawn;
        this.spawns = spawns;
        this.beds = beds;

        this.state = GameState.RECRUITING;
        this.players = new ArrayList<>();
        this.countdown = new Countdown(minigame, this);
        this.game = new Game(this);
    }

    /* GAME */

    public void start() {
        game.start();
    }

    public void reset(boolean kickPlayers) {

        if(kickPlayers) {
            Location loc = ConfigManager.getLobbySpawn();
            for(UUID uuid : players) {
                Bukkit.getPlayer(uuid).teleport(loc);
            }
            players.clear();
        }
        sendTitle("", "");
        state = GameState.RECRUITING;
        countdown.cancel();
        countdown = new Countdown(minigame, this);
        game.cancelTasks();
        game = new Game(this);
    }

    /* TOOLS */

    public void sendMessage(String message) {
        for(UUID uuid : players) {
            Bukkit.getPlayer(uuid).sendMessage(message);
        }
    }

    public void sendTitle(String title, String subtitle) {
        for(UUID uuid : players) {
            Bukkit.getPlayer(uuid).sendTitle(title, subtitle);
        }
    }

    /* PLAYERS */

    public void addPlayer(Player player) {
        players.add(player.getUniqueId());

        if(state.equals(GameState.RECRUITING) && players.size() >= ConfigManager.getRequiredPlayers()) {
            countdown.start();
        }

    }

    public void removePlayer(Player player) {
        players.remove(player.getUniqueId());
        player.teleport(ConfigManager.getLobbySpawn());
        player.sendTitle("", "");


        if(state == GameState.COUNTDOWN && players.size() < ConfigManager.getRequiredPlayers()) {
            sendMessage(ChatColor.RED + "There is not enough players. Countdown stopped.");
            reset(false);
            return;
        }

        if(state == GameState.LIVE && players.size() < ConfigManager.getRequiredPlayers()) {
            sendMessage(ChatColor.RED + "The game has ended as too many players have left.");
            reset(false);
        }
    }

    /* INFO */

    public Minigame getMinigame() {
        return minigame;
    }

    public int getId() {
        return id;
    }

    public int getyRespawn() {
        return yRespawn;
    }

    public HashMap<Team, Location> getSpawns() {
        return spawns;
    }

    public HashMap<Team, BedLocation> getBeds() {
        return beds;
    }

    public GameState getState() {
        return state;
    }

    public List<UUID> getPlayers() {
        return players;
    }

    public Game getGame() {
        return game;
    }

    public void setState(GameState state) {
        this.state = state;
    }
}
