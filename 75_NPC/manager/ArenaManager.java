package org.setup.minecraft.manager;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.setup.minecraft.instance.Arena;
import org.setup.minecraft.Minigame;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ArenaManager {

    private List<Arena> arenas = new ArrayList<>();

    public ArenaManager(Minigame minigame) {
        FileConfiguration config = minigame.getConfig();

        for(String str : config.getConfigurationSection("arenas.").getKeys(false)) {
            arenas.add(new Arena(minigame, Integer.parseInt(str), new Location(
                    Bukkit.getWorld(config.getString("arenas."+str + ".player-spawn.world")),
                    config.getDouble("arenas."+str + ".player-spawn.x"),
                    config.getDouble("arenas."+str + ".player-spawn.y"),
                    config.getDouble("arenas."+str + ".player-spawn.z"),
                    (float)config.getDouble("arenas."+str + ".player-spawn.yaw"),
                    (float)config.getDouble("arenas."+str + ".player-spawn.pitch")
            ),
                    new Location(
                            Bukkit.getWorld(config.getString("arenas."+str + ".npc-spawn.world")),
                            config.getDouble("arenas."+str + ".npc-spawn.x"),
                            config.getDouble("arenas."+str + ".npc-spawn.y"),
                            config.getDouble("arenas."+str + ".npc-spawn.z"),
                            (float)config.getDouble("arenas."+str + ".npc-spawn.yaw"),
                            (float)config.getDouble("arenas."+str + ".npc-spawn.pitch")
                    )

            ));
        }
    }

    public List<Arena> getArenas() {
        return arenas;
    }

    public Arena getArena(Player player) {
        for(Arena arena: arenas) {
            if(arena.getPlayers().contains(player.getUniqueId())) {
                return arena;
            }
        }
        return null;
    }

    public Arena getArena(int id) {
        for(Arena arena: arenas) {
            if(arena.getId() == id) {
                return arena;
            }
        }
        return null;
    }

    public int getArena(UUID entityUUID) {
        for(Arena arena : arenas) {
            if(arena.getNPC().getUniqueId().equals(entityUUID)) {
                return arena.getId();
            }
        }
        return -1;
    }

}
