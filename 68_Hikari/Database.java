package org.setup.minecraft;

import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {


    private HikariDataSource hikari;

    public void connect() throws SQLException {
        hikari = new HikariDataSource();
        hikari.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
        Properties props = new Properties();
        props.setProperty("serverName", "localhost");
        props.setProperty("port", "3306");
        props.setProperty("databaseName", "test_plugin");
        props.setProperty("user", "user");
        props.setProperty("password", "secret");
        hikari.setDataSourceProperties(props);


        // connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_plugin?useSSL=false", "user", "pass!");
    }

    public boolean isConnected() {
        return hikari != null;
    }

    public HikariDataSource getHikari() {
        return hikari;
    }

    public void disconnect() {
        if(isConnected()) {
            hikari.close();
        }
    }

}
