package main.commands;

import main.menus.Menu_JoinMenu;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import main.Alias;
import static main.Alias.*;

import java.util.ArrayList;

import static main.database.AliasDB.*;

public class Command_DebugCommand extends AbstractCommand {
    public Command_DebugCommand() {
        super("debughelp");
    }

    @Override
    public void execute(CommandSender sender, String label, String[] args) {

        Double peso = Double.valueOf(args[1]);
        Player player = (Player) sender;
        player.sendMessage(String.valueOf(getCurrencyCoff("PESO")));
        player.sendMessage(String.valueOf(exchange("PESO", peso, "EURO")));

        player.sendMessage("yes");
    }
}