package main.commands;

import main.main;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public abstract class abstractCommand implements CommandExecutor, TabCompleter {

    public abstractCommand(String command) {
        PluginCommand commands = main.getInstance().getCommand(command);
        if (commands != null) {
            commands.setExecutor(this);
            commands.setTabCompleter(this);
        }
    }

    public List<String> complete(CommandSender sender, String label, String[] args) {
        return null;
    }

    public List<String> complete(CommandSender sender, String[] args) {
        return null;
    }

    public abstract void execute(CommandSender sender, String label, String[] args);

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            execute(sender, label, args);
        } else {
            sender.sendMessage("Команды может отправлять только игрок");
        }

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return filter(complete(sender, args), args);
    }

    private List<String> filter(List<String> list, String[] args) {
        if(list == null) return null;
        String last = args[args.length - 1];
        List<String> result = new ArrayList<>();
        for(String arg : list) {
            if(arg.toLowerCase().startsWith(last.toLowerCase())) result.add(arg);
        }
        return result;
    }

}
