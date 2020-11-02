package com.geppi.event;

import com.geppi.other.PlayerHandler;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class PickupItem implements Listener {

    PlayerHandler playerHandler = new PlayerHandler();

    @EventHandler
    public void onPickup(PlayerPickupItemEvent event) {
        Player player = event.getPlayer();

        if(playerHandler.getRank(player) < 6) {

            if(event.getItem().getItemStack().getType().equals(Material.CHAINMAIL_HELMET)
        || event.getItem().getItemStack().getType().equals(Material.CHAINMAIL_CHESTPLATE)
                    || event.getItem().getItemStack().getType().equals(Material.CHAINMAIL_LEGGINGS)
                    || event.getItem().getItemStack().getType().equals(Material.CHAINMAIL_BOOTS)
                    || event.getItem().getItemStack().getType().equals(Material.DIAMOND_SWORD)
            || event.getItem().getItemStack().getItemMeta().getDisplayName().contains("Guard")) {
                event.setCancelled(true);
                return;
            }


        }





    }



}
