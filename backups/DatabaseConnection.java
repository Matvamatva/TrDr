package org;

import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection  extends JavaPlugin {
    private static DatabaseConnection instance;
    private Connection connection;
    public static final String DATABASE_URL = "jdbc:sqlite:Users.db";
    private DatabaseConnection() {
        try {
            connection = DriverManager.getConnection(DATABASE_URL);
        } catch (SQLException e) {
            getLogger().info("[TrDr] Ошибка при подключении к БД: " + e.getMessage());
        }
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}