package main.commands;

import main.menus.Menu_JoinMenu;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import main.Alias;

import java.util.ArrayList;

import static main.database.AliasDB.*;

public class Command_DebugCommand extends AbstractCommand {
    public Command_DebugCommand() {
        super("debughelp");
    }

    @Override
    public void execute(CommandSender sender, String label, String[] args) {
        Player player = (Player) sender;

        ArrayList<String> town = new ArrayList<String>();
        town.add("Moscow");
        town.add("Stavropol");

        setTowns(town, "Russia");
        player.sendMessage("yes");
    }
}