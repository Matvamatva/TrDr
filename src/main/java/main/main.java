package main;



import main.commands.Command_DebugCommand;
import main.commands.Command_JoinTown;
import main.commands.Command_TestDB;
import main.commands.Command_TestJoin;
import main.database.DbConnect;
import main.events.Event_InventoryInteract;
import main.events.Event_OnJoin;
import main.menus.Menu_JoinMenu;
import main.Alias;
import main.placeholders.Papi_main;
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
        DbConnect.conn();



//----------------Placeholders---------------------------
        // new Papi_main(this).register();
//----------------/Placeholders---------------------------



//----------------COMMANDS---------------------------
        new Command_DebugCommand();
        new Command_JoinTown();
        new Command_TestDB();
        new Command_TestJoin();

//----------------/COMMANDS---------------------------



//----------------EVENT---------------------------
        Bukkit.getPluginManager().registerEvents(new Event_OnJoin(), this);
        Bukkit.getPluginManager().registerEvents(new Event_InventoryInteract(), this);
//----------------/EVENT---------------------------



//----------------OTHERS---------------------------
        new Alias(); Alias.initLanguage();
//----------------/OTHERS---------------------------



//----------------MENUS---------------------------
        Menu_JoinMenu menuJoinMenu = new Menu_JoinMenu(); menuJoinMenu.initCountries(); menuJoinMenu.createMenu();
//----------------/MENUS---------------------------



        getLogger().info("------------------------------------------------------");
    }

    @Override
    public void onDisable() {
        DbConnect.closeDB();
    }

    public static main getInstance() { return instance;}
}
