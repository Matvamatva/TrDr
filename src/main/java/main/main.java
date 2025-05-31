package main;



import main.commands.command_DebugCommand;
import main.commands.command_JoinTown;
import main.database.dbConnect;
import main.events.event_InventoryInteract;
import main.events.event_OnJoin;
import main.menus.menu_JoinMenu;
import main.placeholders.papi_main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import static java.lang.Thread.sleep;


public final class main extends JavaPlugin {

    private static main instance;
    public Player Player;

    @Override
    public void onEnable() {
        getLogger().info("--------------------------TRDR----------------------------");
        instance = this;
        dbConnect.Conn();
//----------------Placeholders---------------------------
        new papi_main(this).register();
//----------------/Placeholders---------------------------
//----------------COMMANDS---------------------------
        new command_DebugCommand();
        new command_JoinTown();
//----------------/COMMANDS---------------------------


//----------------EVENT---------------------------
        Bukkit.getPluginManager().registerEvents(new event_OnJoin(), this);
        Bukkit.getPluginManager().registerEvents(new event_InventoryInteract(), this);
//----------------/EVENT---------------------------


//----------------MENUS---------------------------
        menu_JoinMenu menuJoinMenu = new menu_JoinMenu(); menuJoinMenu.InitCountries(); menuJoinMenu.CreateMenu();



//----------------/MENUS---------------------------
        getLogger().info("------------------------------------------------------");
    }

    @Override
    public void onDisable() {
        dbConnect.CloseDB();
    }

    public static main getInstance() { return instance;}
}
