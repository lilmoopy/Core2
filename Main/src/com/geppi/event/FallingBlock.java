package com.geppi.event;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;

import java.util.ArrayList;
import java.util.logging.Logger;

public class FallingBlock implements Listener {

   /* @EventHandler
    private void on(BlockPhysicsEvent event) {

        if (event.getBlock() instanceof FallingBlock) {
            if(event.getBlock().getWorld().getName().equals("world")) {
                event.setCancelled(true);
            }
        }
    }*/
   @EventHandler
   public void BlockPhysicsEvent(BlockPhysicsEvent event) {
       if (event.getBlock().getWorld() == Bukkit.getWorld("world")) {
           if (event.getBlock().getType() == Material.REDSTONE
                   || event.getBlock().getType() == Material.IRON_BARS
                   || event.getBlock().getType() == Material.DARK_OAK_DOOR
                   || event.getBlock().getType() == Material.ACACIA_DOOR
                   || event.getBlock().getType() == Material.BIRCH_DOOR
                   || event.getBlock().getType() == Material.CRIMSON_DOOR
                   || event.getBlock().getType() == Material.IRON_DOOR
                   || event.getBlock().getType() == Material.JUNGLE_DOOR
                   || event.getBlock().getType() == Material.OAK_DOOR
                   || event.getBlock().getType() == Material.SPRUCE_DOOR
                   || event.getBlock().getType() == Material.WARPED_DOOR
                   || event.getBlock().getType() == Material.LADDER


                   || event.getBlock().getType() == Material.CHEST) {

               return;
           }
           try {
               if (event.getBlock().getWorld().getName().equals("world")) {
                   event.setCancelled(true);
               }
           } catch (Exception e) {
               Logger logger = Logger.getLogger("Minecraft");

               logger.info(ChatColor.RED + "MCGSPACE -- ERROR" + e.toString());
           }
       }
   }
}
