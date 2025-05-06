package org.Economy;

import java.sql.*;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.DatabaseConnection;
import org.bukkit.entity.Player;
// import org.Commands.Commands.playername;

public class FuncMoney {

    public static boolean getMoney(CommandSender sender) {
        Player player = (Player) sender;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String sql = "SELECT * FROM user WHERE nickname = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, player.getName());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("nickname");
                int money = resultSet.getInt("money");
                player.sendMessage("На вашем счету: " + resultSet.getRow() + ". " + money + " " + name);
            } else {
                player.sendMessage("Пользователь не найден.");
            }
        } catch (SQLException e) {
            player.sendMessage("Ошибка при подключении к БД: " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
            } catch (SQLException e) {
                player.sendMessage("Ошибка при закрытии ресурсов: " + e.getMessage());
            }
        }
        return true;
    }

    public static void setMoney(CommandSender sender, String args1, String args0) {
        Player player = (Player) sender;
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            int resultSet = statement.executeUpdate("UPDATE User SET money  = " + args1 + "WHERE nickname = " + args0);


        } catch (SQLException e) {
            player.sendMessage("Ошибка при подключении к БД: " + e.getMessage());
        }
    }
    public static void hello(String playername) {
        Bukkit.getServer().broadcastMessage("Hello World2 " + playername);
    }
}