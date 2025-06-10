package main;

import main.commands.Command_DebugCommand;
import main.commands.Command_JoinTown;
import main.commands.Command_TestDB;
import main.commands.Command_TestJoin;
import main.database.AliasDB;
import main.database.DbConnect;
import main.events.Event_InventoryInteract;
import main.events.Event_OnJoin;
import main.menus.Menu_JoinMenu;
import main.Alias;
import main.placeholders.Papi_main;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;


import java.util.function.Supplier;

import static java.lang.Thread.sleep;


public final class main extends JavaPlugin {

    private static main instance;
    public Player Player;
    private static Economy econ = null;
    private String e;

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
        DbConnect.getInstance.initCurrency();
//----------------/OTHERS---------------------------



//----------------MENUS---------------------------
        Menu_JoinMenu menuJoinMenu = new Menu_JoinMenu(); menuJoinMenu.createMenuCountry();
//----------------/MENUS---------------------------



//----------------ECONOMY--------------------------
        if (!setupEconomy()) {getLogger().severe(String.format("Не удалось инициализировать Vault. Error: " + e + ". Плагин %s отключён", getDescription().getName()));getServer().getPluginManager().disablePlugin(this);return;}
//----------------/ECONOMY--------------------------

        getLogger().info("------------------------------------------------------");
    }

    @Override
    public void onDisable() {
        DbConnect.closeDB();
    }
    public static main getInstance() {return instance;}
    private boolean setupEconomy() {
        if (String.valueOf(getServer().getPluginManager().getPlugin("Vault")) == "null") {
            e = "Vault has not been detected";
            return false;
        }

        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            e = "RegisteredServiceProvider is null";
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    public static Economy getEconomy() {
        return econ;
    }
}

