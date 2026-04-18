package me.pablo.teleportBow.Listeners;

import me.pablo.teleportBow.TeleportBow;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class OnJoinListener implements Listener {

    private final TeleportBow plugin;

    public OnJoinListener(TeleportBow plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void giveTBPOnJoin(PlayerJoinEvent e){

        //Creating the bow
        ItemStack bow = ItemStack.of(Material.BOW);
        ItemMeta bowMeta = bow.getItemMeta();

        //Getting name + lore
        String name = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("teleport-bow.name"));
        if(name == null) return;
        List<String> lore = plugin.getConfig().getStringList("teleport-bow.lore");
        lore.replaceAll(line -> ChatColor.translateAlternateColorCodes('&', line));

        //Setting name + lore
        bowMeta.setDisplayName(name);
        bowMeta.setLore(lore);

        //Making it unbreakable + infinite arrows.
        bowMeta.addEnchant(Enchantment.INFINITY, 1, true);
        bowMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        bowMeta.setUnbreakable(plugin.getConfig().getBoolean("teleport-bow.unbreakable"));

        bow.setItemMeta(bowMeta);

        //Adding it to the inventory
        e.getPlayer().getInventory().setItem(plugin.getConfig().getInt("teleport-bow.slot"), bow);
    }

    @EventHandler
    public void giveArrowOnJoin(PlayerJoinEvent e){
        if(e.getPlayer() instanceof Player p){

            //Creating arrow
            ItemStack arrow = ItemStack.of(Material.ARROW);
            ItemMeta arrowMeta = arrow.getItemMeta();
            if(arrowMeta == null) return;


            //Getting name
            String name = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("arrow.name"));
            if(name == null) return;

            //Setting name
            arrowMeta.setDisplayName(name);

            //Setting meta
            arrow.setItemMeta(arrowMeta);

            e.getPlayer().getInventory().setItem(plugin.getConfig().getInt("arrow.slot"), arrow);
        }
    }
}
