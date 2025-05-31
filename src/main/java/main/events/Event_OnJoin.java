package main.events;

import main.database.AliasDB;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import main.database.DbConnect;

public class Event_OnJoin implements Listener {

    @EventHandler
    public void joinHandler (PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage("");

        String user = AliasDB.getUser(DbConnect.escapeSql(event.getPlayer()), "username");
        if (user == null) {
            player.sendMessage("Добро пожаловать на TrDr! Для начала обучения пропиши /newbie. Если ты уже знаком с сервером пропиши /inonewbie");
            AliasDB.setUser(DbConnect.escapeSql(event.getPlayer()),"newuser", String.valueOf(player.getUniqueId()));
        }
    }
}