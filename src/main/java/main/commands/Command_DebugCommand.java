package main.commands;

import main.menus.Menu_JoinMenu;
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
        Menu_JoinMenu menuJoinMenu = new Menu_JoinMenu(); menuJoinMenu.initCountries(); menuJoinMenu.createMenu();
        player.sendMessage("ok");
    }
}