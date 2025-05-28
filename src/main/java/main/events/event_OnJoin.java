package main.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import main.database.dbConnect;

public class event_OnJoin implements Listener {

    @EventHandler
    public void JoinHandler (PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage("");

        String user = dbConnect.getUser(dbConnect.escapeSql(event.getPlayer()), "username");
        if (user == null) {
            player.sendMessage("Добро пожаловать на TrDr! Для начала обучения пропиши /newbie. Если ты уже знаком с сервером пропиши /inonewbie");
            dbConnect.setUser(dbConnect.escapeSql(event.getPlayer()),"newuser", String.valueOf(player.getUniqueId()));
        }
    }
}