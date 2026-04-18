package me.pablo.teleportBow.Commands;

import me.pablo.teleportBow.TeleportBow;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class ReloadCommand implements CommandExecutor {
    private final TeleportBow plugin;

    public ReloadCommand(TeleportBow plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {

        if (strings.length == 0) {
            commandSender.sendMessage("Usage: /teleportbow reload");
            return true;
        }

        if(strings[0].equalsIgnoreCase("reload")){
            commandSender.sendMessage(ChatColor.GREEN + "Configuration reloaded.");
            plugin.reloadConfig();
            return true;
        }

        return false;
    }
}
