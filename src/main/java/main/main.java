package main;


import main.database.dbConnect;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collection;


public final class main extends JavaPlugin implements Listener {

    private static main instance;

    @Override
    public void onEnable() {
        instance = this;
        dbConnect dbConnect = new dbConnect();
    }

    @Override
    public void onDisable() {

    }

    public static main getInstance() {
        return instance;
    }
}
