package main.commands;

import main.menus.menu_JoinMenu;
import main.towny.object_OnJoinTown;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class command_JoinTown extends abstractCommand {
    public command_JoinTown() {
        super("debugjoinmenu");
    }

    @Override
    public void execute(CommandSender sender, String label, String[] args) {
        Player player = (Player) sender;
        player.sendMessage("DEBUG");
        player.openInventory(menu_JoinMenu.countryMenu);

       // join.onJoinTownHandler();


    }
}
