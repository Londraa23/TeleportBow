package me.pablo.teleportBow;

import me.pablo.teleportBow.Commands.ReloadCommand;
import me.pablo.teleportBow.Listeners.ArrowHitListener;
import me.pablo.teleportBow.Listeners.MoveItemsListener;
import me.pablo.teleportBow.Listeners.OnJoinListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class TeleportBow extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Plugin has been enabled");
        getServer().getPluginManager().registerEvents(new OnJoinListener(this), this);
        getServer().getPluginManager().registerEvents(new MoveItemsListener(this), this);
        getServer().getPluginManager().registerEvents(new ArrowHitListener(), this);
        getCommand("teleportbow").setExecutor(new ReloadCommand(this));

        getConfig().options();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
