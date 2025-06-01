package main.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import main.Alias;

import static main.database.AliasDB.*;

public class Command_DebugCommand extends AbstractCommand {
    public Command_DebugCommand() {
        super("debughelp");
    }

    @Override
    public void execute(CommandSender sender, String label, String[] args) {
        Player player = (Player) sender;
    }
}