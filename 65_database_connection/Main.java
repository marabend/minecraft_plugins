package org.setup.minecraft;

import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;


public class Main extends JavaPlugin  {

    private Database database;

    @Override
    public void onEnable() {
        database = new Database();
        try {
            database.connect();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println(database.isConnected());
    }

    @Override
    public void onDisable() {
        database.disconnect();
    }
}
