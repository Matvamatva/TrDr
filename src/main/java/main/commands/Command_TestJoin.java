package main.commands;

import main.database.AliasDB;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_TestJoin extends AbstractCommand {
    public Command_TestJoin() {
        super("join_test");
    }

    @Override
    public void execute(CommandSender sender, String label, String[] args) {
        Player player = (Player) sender;
        AliasDB.setUser(player.getName(),"town", args[0]);
        player.sendMessage("Успешно. Вы житель " + AliasDB.getTown(AliasDB.getUser(player.getName(),"town"), "country"), args[0]);
    }
}
