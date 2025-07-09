package org.setup.minecraft;

import org.bukkit.plugin.java.JavaPlugin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Main extends JavaPlugin  {

    private Database database;

    @Override
    public void onEnable() {
        database = new Database();
        try {
            database.connect();
            PreparedStatement ps = database.getConnection().prepareStatement("INSERT INTO table (C1,C2,C3) VALUES(?,?,?);");
            ps.setString(1,"banana");
            ps.setInt(2,12);
            ps.setString(3, "aasdf");
            ps.executeUpdate();

            PreparedStatement ps2 = database.getConnection().prepareStatement("UPDATE table SET column = ? WHERE column2 = ?;");
            ps2.setString(1, "banana");
            ps2.setInt(2, 12);
            ps2.executeUpdate();

            PreparedStatement ps3 = database.getConnection().prepareStatement("DELETE FROM table WHERE column = ?;");
            ps3.setInt(1, 12);
            ps3.executeUpdate();

            PreparedStatement ps4 = database.getConnection().prepareStatement("SELECT * FROM table WHERE column = ?");
            ResultSet rs = ps4.executeQuery();

            while(rs.next()) {
                System.out.println(rs.getString("UUID"));
            }


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
