package me.pablo.teleportBow.Listeners;

import me.pablo.teleportBow.TeleportBow;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class MoveItemsListener implements Listener {

    private final TeleportBow plugin;

    public MoveItemsListener(TeleportBow plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        int bowSlot = plugin.getConfig().getInt("teleport-bow.slot");
        int arrowSlot = plugin.getConfig().getInt("arrow.slot");

        if(e.getSlot() == bowSlot || e.getSlot() == arrowSlot){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent e){
        ItemStack item = e.getItemDrop().getItemStack();
        String bowName = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("teleport-bow.name"));
        String arrowName = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("arrow.name"));

        if(item.getItemMeta() != null && (item.getItemMeta().getDisplayName().equals(bowName) || item.getItemMeta().getDisplayName().equals(arrowName))){
            e.setCancelled(true);
        }
    }
}
