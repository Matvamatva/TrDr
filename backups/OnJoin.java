package org;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.*;
import java.util.UUID;

public class OnJoin {
    public void onPlayerJoin(PlayerJoinEvent event) {
        String playerName = event.getPlayer().getName();
        UUID playerUUID = event.getPlayer().getUniqueId();
        event.getPlayer().sendMessage("Привет, " + playerName + "! Добро пожаловать на сервер Шизофрения!");

    }
    public void DataBase(String PlayerName) throws SQLException {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();

        Boolean hasResults = statement.execute("SELECT * FROM users WHERE EXISTS " + PlayerName);

    }
}
