package main.commands;

import main.database.AliasDB;
import main.database.AliasDB.*;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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

        player.sendMessage("Дебаг-страны созданы.");
    }
}