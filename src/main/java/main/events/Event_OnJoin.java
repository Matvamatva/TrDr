package main.events;

import main.database.AliasDB;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import main.database.DbConnect;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Event_OnJoin implements Listener {

    @EventHandler
    public void joinHandler (PlayerJoinEvent event) {
        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date();
        Player player = event.getPlayer();
        event.setJoinMessage("");

        String user = AliasDB.getUser(DbConnect.escapeSql(event.getPlayer()), "username");
        if (user == null) {
            player.sendMessage("Добро пожаловать на TrDr! Для начала обучения пропиши /newbie. Если ты уже знаком с сервером пропиши /inonewbie");
            AliasDB.setUser(DbConnect.escapeSql(event.getPlayer()),"newuser", String.valueOf(player.getUniqueId()));
            AliasDB.setUser(player.getName(),"lastJoin", formater.format(date));
        } else {
            AliasDB.setUser(player.getName(),"lastJoin", formater.format(date));
        }
    }
}