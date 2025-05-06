package org.Commands;

import org.Economy.FuncMoney;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

    public void player(CommandSender sender) {
        Player player = (Player) sender;

    }
    //  String arg0 = "";
    //  String arg1 = "";
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            // int argcount = args.length;
            // arg0 = args[0];
            // arg1 = args[1];
            if (command.getName().equalsIgnoreCase("set")) {
                player.sendMessage("set принята");
                //   FuncMoney.setMoney(player, arg0, arg1);
            } else if (command.getName().equalsIgnoreCase("get")) {
                player.sendMessage("get принята");
                FuncMoney.getMoney(sender);
            } else if (command.getName().equalsIgnoreCase("hello")) {
                Bukkit.getServer().broadcastMessage("Hello World1");
                FuncMoney.hello(player.getName());
            }

        } else {
            sender.sendMessage("Команды может отправлять только игрок");
        }
        return false;
    }
}
