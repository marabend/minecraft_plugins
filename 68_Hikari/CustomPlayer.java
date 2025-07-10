package org.setup.minecraft;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class CustomPlayer {

    private  Main main;

    private UUID uuid;
    private String rank;
    private int coins;

    public CustomPlayer(Main main, UUID uuid) throws SQLException {
        this.main = main;
        this.uuid = uuid;

        try (Connection connection = main.getDatabase().getHikari().getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT RANK, COINS FROM players WHERE UUID = ?")) {
            statement.setString(1, uuid.toString());

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                rank = rs.getString("RANK");
                coins = rs.getInt("COINS");
            } else {
                rank = "GUEST";
                coins = 0;

                try (Connection connection1 = main.getDatabase().getHikari().getConnection();
                     PreparedStatement statement1 = connection.prepareStatement("INSERT INTO players (ID, UUID, RANK, COINS) VALUES (" +
                             "default," +
                             "'" + this.uuid + "'," +
                             "'" + rank + "'," +
                             coins + ");")) {

                    statement1.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void setRank(String rank) {
        /*
        this.rank = rank;

        try {
            PreparedStatement statement = main.getDatabase().getHikari().getConnection().prepareStatement("UPDATE players SET RANK = '" + rank + "' WHERE UUID = " + uuid + "'");
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

         */
    }



    public void setCoins(int coins) {
        /*
        this.coins = coins;
        try {
            PreparedStatement statement = main.getDatabase().getHikari().getConnection().prepareStatement("UPDATE players SET COINS = '" + coins + "' WHERE UUID = " + uuid + "'");
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

         */
    }



    public String getRank() {
        return rank;
    }

    public int getCoins() {
        return coins;
    }
}
