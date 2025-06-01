package main.placeholders;

import main.main;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

import static main.database.AliasDB.getRegionVault;
import static main.database.AliasDB.getUser;

public class Papi_main extends PlaceholderExpansion {

    private final main plugin; //

    public Papi_main(main plugin) {
        this.plugin = plugin;
    }

    @Override
    @NotNull
    public String getAuthor() {
        return String.join(", ", plugin.getDescription().getAuthors()); //
    }

    @Override
    @NotNull
    public String getIdentifier() {
        return "trdr";
    }

    @Override
    @NotNull
    public String getVersion() {
        return plugin.getDescription().getVersion(); //
    }

    @Override
    public boolean persist() {
        return true; //
    }

    @Override
    public String onRequest(OfflinePlayer player, @NotNull String params) {
        if (params.equalsIgnoreCase("main_vault")) {
            return getUser(player.getName(), getRegionVault(player.getName())); //
        }
        if (params.equalsIgnoreCase("player_peso")) {
            return getUser(player.getName(),"PESO"); //
        } else if (params.equalsIgnoreCase("player_real")) {
            return getUser(player.getName(),"REAL"); //
        } else if (params.equalsIgnoreCase("player_euro")) {
            return getUser(player.getName(),"EURO"); //
        } else if (params.equalsIgnoreCase("player_yuan")) {
            return getUser(player.getName(),"YUAN"); //
        } else if (params.equalsIgnoreCase("player_frank")) {
            return getUser(player.getName(),"FRANK"); //
        } else if (params.equalsIgnoreCase("player_rupee")) {
            return getUser(player.getName(),"RUPEE"); //
        }


        return null; //
    }
}
