package org.setup.minecraft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {


    private Connection connection;

    public void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_plugin?useSSL=false", "user", "password");
    }

    public boolean isConnected() {
        return connection != null;
    }

    public void disconnect() {
        if(isConnected()) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
