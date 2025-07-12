package org.setup.minecraft.instance;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.setup.minecraft.GameState;
import org.setup.minecraft.Minigame;
import org.setup.minecraft.manager.ConfigManager;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Arena {

    private Minigame minigame;

    private int id;
    private Location spawn;
    private Location sign;

    private GameState state;
    private List<UUID> players;
    private Countdown countdown;
    private Game game;

    public Arena(Minigame minigame, int id, Location spawn, Location sign) {
        this.minigame = minigame;
        this.id = id;
        this.spawn = spawn;
        this.sign = sign;

        setState(GameState.RECRUITING);
        this.players = new ArrayList<>();
        this.countdown = new Countdown(minigame, this);
        this.game = new Game(this);
    }

    /* GAME */

    public void start() {
        game.start();
    }

    public void reset(boolean kickPlayers) {
        setState(GameState.RECRUITING);
        if(kickPlayers) {
            Location loc = ConfigManager.getLobbySpawn();
            for(UUID uuid : players) {
                Bukkit.getPlayer(uuid).teleport(loc);
            }
            players.clear();
        }
        sendTitle("", "");
        countdown.cancel();
        countdown = new Countdown(minigame, this);
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

    public void updateSign(String line1, String line2, String line3, String line4) {
        Sign signBlock = (Sign) sign.getBlock().getState();

        signBlock.setLine(0, line1);
        signBlock.setLine(0, line2);
        signBlock.setLine(0, line3);
        signBlock.setLine(0, line4);
        signBlock.update();
    }

    /* PLAYERS */

    public void addPlayer(Player player) {
        players.add(player.getUniqueId());
        player.teleport(spawn);

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
            return;
        }

        if(state == GameState.LIVE) {
            updateSign("Arena" + id, state.name(), "", "Players: " + players.size());
        }
    }

    /* INFO */

    public int getId() {
        return id;
    }

    public Location getSignLocation() {
        return sign;
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
        updateSign("Arena" + id, state.name(), "", state == GameState.LIVE ? "Players: " + players.size() :  "");
    }
}
