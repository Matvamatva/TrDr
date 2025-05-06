package org;

import org.Commands.Commands;
import org.bukkit.plugin.java.JavaPlugin;
import java.sql.*;


public class main extends JavaPlugin {
    private static main instance;
    public static main getInstance() {
        return instance;
    }
    public void onEnable() {
        instance = this;
        this.getCommand("set").setExecutor(new Commands());
        this.getCommand("get").setExecutor(new Commands());
        this.getCommand("hello").setExecutor(new Commands());
        getLogger().info("TrDr включен!");
    }
    @Override
    public void onDisable() {
        getLogger().info("TrDr выключен!");
    }
    public ResultSet ConnectDB(String connect) {
        try (
                Connection connection = DatabaseConnection.getInstance().getConnection();
                Statement statement = connection.createStatement();
        ) {
            getLogger().info("Соединение с БД успешно");
        } catch (SQLException e) {
            getLogger().info("Ошибка при подключении к БД: " + e.getMessage());
        }
        return null;
    }
}
