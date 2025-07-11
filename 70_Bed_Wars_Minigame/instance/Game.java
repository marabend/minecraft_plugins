package org.setup.minecraft.instance;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Bed;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitTask;
import org.setup.minecraft.GameState;
import org.setup.minecraft.manager.ConfigManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Game {

    private Arena arena;
    private HashMap<UUID, Team> teams;

    private List<BukkitTask> tasks;

    private HashMap<Team, Boolean> bedsAlive;
    private List<UUID> alive;

    public Game(Arena arena) {
        this.arena = arena;
        teams = new HashMap<>();
        tasks = new ArrayList<>();
        alive = new ArrayList<>();
        bedsAlive = new HashMap<>();
    }

    public void start() {
        arena.setState(GameState.LIVE);
        arena.sendMessage(ChatColor.GREEN + "GAME STARTING!");

        for(int i=0; i<arena.getPlayers().size(); i++) {
            UUID uuid = arena.getPlayers().get(i);
            Team team = Team.values()[i];
            teams.put(uuid, team);
            bedsAlive.put(team, true);

            BedLocation location = arena.getBeds().get(team);
            Block block = location.getBlock();

            for(Bed.Part part : Bed.Part.values()) {
                block.setBlockData(Bukkit.createBlockData(Material.RED_BED, (data) -> {
                    ((Bed) data).setPart(part);
                    ((Bed) data).setFacing(location.getFacing());
                }));
                block.setMetadata("team", new FixedMetadataValue(arena.getMinigame(), team.name()));
                block = block.getRelative(location.getFacing().getOppositeFace());
            }

            Player player = Bukkit.getPlayer(uuid);
            player.setGameMode(GameMode.SURVIVAL);
            player.getInventory().addItem(new ItemStack(Material.WOODEN_SWORD));
            player.teleport(arena.getSpawns().get(team));
            alive.add(uuid);
        }

        tasks.add(Bukkit.getScheduler().runTaskTimer(arena.getMinigame(), () -> {
            for(UUID uuid : alive) {
                if(Bukkit.getPlayer(uuid).getLocation().getY() <= arena.getyRespawn()) {
                    death(Bukkit.getPlayer(uuid));
                }
            }
        }, 4,4));
    }

    public Location respawn(Player player) {
        Team team = teams.get(player.getUniqueId());

        if(bedsAlive.get(team)) {
            return arena.getSpawns().get(team);
        } else {
            return ConfigManager.getLobbySpawn();
        }
    }

    public boolean destroyBed(Team team, Player player) {
        if(teams.get(player.getUniqueId()) == team) {
            return true;
        }

        arena.sendMessage(player.getName() + " has broken " + team.getName() + "'s bed!");
        bedsAlive.put(team, false);
        return false;
    }

    public void death(Player player) {
        Team team = teams.get(player.getUniqueId());
        if(bedsAlive.get(team)) {
           player.teleport(arena.getSpawns().get(team));
           arena.sendMessage(player.getName() + " died and is respawning");
        } else {
            player.teleport(ConfigManager.getLobbySpawn());
            arena.sendMessage(player.getName() + " died and will no longer respawn");
            alive.remove(player.getUniqueId());

            if(alive.size() == 1) {
                arena.sendMessage(Bukkit.getPlayer(alive.get(0)).getName() + " has won!");
                arena.reset(true);

            }
        }

    }

    public void cancelTasks() {
        for(BukkitTask task : tasks) {
            task.cancel();
        }
    }

}
