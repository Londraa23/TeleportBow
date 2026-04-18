package me.pablo.teleportBow.Listeners;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ArrowHitListener implements Listener {

    @EventHandler
    public void onHit(ProjectileHitEvent event){
        if(event.getEntityType() == EntityType.ARROW){
            Arrow arrow = (Arrow) event.getEntity();
            Player p = (Player) arrow.getShooter();

            Location hitLocation = event.getHitBlock().getLocation().add(0, 1, 0);

            if(p != null && arrow != null){
                p.teleport(hitLocation);
                p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
                p.spawnParticle(Particle.END_ROD, p.getLocation().add(0, 1, 0), 30);
            }

        }
    }
}
