package main.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static main.database.AliasDB.*;

public class Command_DebugCommand extends AbstractCommand {
    public Command_DebugCommand() {
        super("debughelp");
    }

    @Override
    public void execute(CommandSender sender, String label, String[] args) {
        Player player = (Player) sender;
        player.sendMessage(getCountry(getTown(getUser(player.getName(), "town"),"country"), "region"));
        player.sendMessage(getUser(player.getName(), getRegionVault(player.getName())));
    }
}