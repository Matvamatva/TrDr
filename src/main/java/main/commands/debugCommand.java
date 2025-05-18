package main.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import net.milkbowl.vault.permission.Permission;

public class debugCommand extends abstractCommand {
    public debugCommand() {
        super("debughelp");
    }

    @Override
    public void execute(CommandSender sender, String label, String[] args) {
    }
}