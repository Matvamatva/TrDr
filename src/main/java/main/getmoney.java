package main;
import main.commands.abstractCommand;
import org.bukkit.command.*;
import org.bukkit.entity.Player;


public class getmoney extends abstractCommand {

    public getmoney(String command) {
        super("getmoney");
    }

    @Override
    public void execute(CommandSender sender, String label, String[] args) {
        Player player = (Player) sender;
        player.sendMessage("Команда работает");
    }
}
