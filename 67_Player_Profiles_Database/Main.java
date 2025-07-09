package org.setup.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*

CREATE TABLE `test_plugin`.`players` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `UUID` VARCHAR(36) NULL,
  `RANK` VARCHAR(20) NULL,
  `COINS` INT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) VISIBLE,
  UNIQUE INDEX `UUID_UNIQUE` (`UUID` ASC) VISIBLE);

*/

public class Main extends JavaPlugin  {

    private Database database;
    private PlayerManager playerManager;

    @Override
    public void onEnable() {
        database = new Database();
        try {
            database.connect();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        playerManager = new PlayerManager();

        Bukkit.getPluginManager().registerEvents(new ConnectionListener(this), this);
    }

    @Override
    public void onDisable() {
        database.disconnect();
    }

    public Database getDatabase() {
        return database;
    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }
}
