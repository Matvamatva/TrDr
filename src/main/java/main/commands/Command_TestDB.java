package main.commands;

import main.database.AliasDB;
import main.database.AliasDB.*;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

import static main.database.AliasDB.setTowns;

public class Command_TestDB extends AbstractCommand {
    public Command_TestDB() {
        super("setdb");
    }

    @Override
    public void execute(CommandSender sender, String label, String[] args) {
        Player player = (Player) sender;
        AliasDB.setCountry("Germany", "newcountry", "Europa");
        AliasDB.setCountry("Russia", "newcountry", "Europa");
        AliasDB.setCountry("China", "newcountry", "Asia");
        AliasDB.setTown("Berlin","newtown", "Germany");
        AliasDB.setTown("Stavropol","newtown", "Russia");
        AliasDB.setTown("Moscow","newtown","Russia");

        ArrayList<String> town = new ArrayList<String>();
        town.add("Moscow");
        town.add("Stavropol");
        setTowns(town, "Russia");
        town.clear();
        town.add("Berlin");
        setTowns(town, "Germany");
        player.sendMessage("Дебаг-страны созданы.");
    }
}