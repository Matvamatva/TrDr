package main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import main.database.dbConnect;
import org.jetbrains.annotations.NotNull;

public class onJoin implements Listener {

    @EventHandler
    public void JoinHandler (PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage("");
        String user = dbConnect.getUser("SELECT * FROM 'users' WHERE username = '" + dbConnect.escapeSql(player.getName(), event.getPlayer()) + "'", "username");
        if (user == null) {
            dbConnect.setUser(String.format("INSERT INTO 'users' ('username', 'UUID') VALUES ('%s', '%s')", dbConnect.escapeSql(player.getName(), event.getPlayer()), String.valueOf(player.getUniqueId())));
        }
    }
}