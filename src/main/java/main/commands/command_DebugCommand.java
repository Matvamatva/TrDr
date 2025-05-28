package main.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class command_DebugCommand extends abstractCommand {
    public command_DebugCommand() {
        super("debughelp");
    }

    @Override
    public void execute(CommandSender sender, String label, String[] args) {
        Player player = (Player) sender;
        player.sendMessage("Команда работает?");
    }
}