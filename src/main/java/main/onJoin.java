package main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import main.database.dbConnect;
import org.jetbrains.annotations.NotNull;

public class onJoin implements Listener {


    private static String query;
    @EventHandler
    public void JoinHandler (PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage("");
        player.sendMessage("DEBUG");
        String user = dbConnect.getUser("SELECT * FROM 'users' WHERE username = '" + player.getName() + "'", "username");
        if (!(user.equals(""))) {
            // код на добавление пользователя
        }

    }
}
