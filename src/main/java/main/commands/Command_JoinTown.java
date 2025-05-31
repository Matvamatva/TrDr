package main.commands;

import main.menus.Menu_JoinMenu;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Command_JoinTown extends AbstractCommand {
    public Command_JoinTown() {
        super("debugjoinmenu");
    }

    @Override
    public void execute(CommandSender sender, String label, String[] args) {
        Player player = (Player) sender;
        player.openInventory(Menu_JoinMenu.countryMenu);

       // join.onJoinTownHandler();


    }
}
