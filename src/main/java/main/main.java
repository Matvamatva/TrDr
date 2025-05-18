package main;


import main.commands.debugCommand;
import main.database.dbConnect;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import static java.lang.Thread.sleep;


public final class main extends JavaPlugin {

    private static main instance;
    public Player Player;

    @Override
    public void onEnable() {
        getLogger().info("------------------------------------------------------");
        instance = this;
        dbConnect.Conn();
//----------------COMMANDS---------------------------
        new debugCommand();
//----------------COMMANDS---------------------------



//----------------EVENT---------------------------
        Bukkit.getPluginManager().registerEvents(new onJoin(), this);
//----------------EVENT---------------------------
        getLogger().info("------------------------------------------------------");
    }

    @Override
    public void onDisable() {
        dbConnect.CloseDB();
    }

    public static main getInstance() {
        return instance;
    }
}
