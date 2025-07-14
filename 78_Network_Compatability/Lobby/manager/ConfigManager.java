package org.examples.lobby.manager;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.examples.lobby.Lobby;

public class ConfigManager {

    private static FileConfiguration config;

    public static void setupConfig(Lobby minigame) {
        ConfigManager.config = minigame.getConfig();
        minigame.saveConfig();
    }

    public static Location getLobbySpawn() {
        return new Location(
                Bukkit.getWorld(config.getString("lobby-spawn.world")),
                config.getDouble("lobby-spawn.x"),
                config.getDouble("lobby-spawn.y"),
                config.getDouble("lobby-spawn.z"),
                (float)config.getDouble("lobby-spawn.yaw"),
                (float)config.getDouble("lobby-spawn.pitch")
        );
    }

}
