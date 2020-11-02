package com.geppi.event;

import com.geppi.other.ColorHandler;
import com.geppi.other.PlayerHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityAttackEntity implements Listener {

    PlayerHandler playerHandler = new PlayerHandler();
    ColorHandler colorHandler = new ColorHandler();

    @EventHandler
    public void playerAttack(EntityDamageByEntityEvent event) {
        if(event.getEntity() instanceof Player) {
            if(event.getDamager() instanceof Player) {

                Player damaged = (Player) event.getEntity();
                Player damager = (Player) event.getDamager();

                if(playerHandler.getPvpStatus(damaged) == 1) {
                    event.setCancelled(true);
                    damager.sendMessage(colorHandler.error + "This player has their pvp disabled!");
                    return;
                }
                if(playerHandler.getPvpStatus(damager) == 1) {
                    event.setCancelled(true);
                    damager.sendMessage(colorHandler.error + "You have your pvp disabled!");
                    return;
                }

                playerHandler.setCombatLog(damaged, 100);
                playerHandler.setCombatLog(damager, 100);

            }
        }


    }


}
