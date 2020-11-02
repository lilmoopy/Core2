package com.geppi.command;

import com.geppi.other.ColorHandler;
import com.geppi.other.PlayerHandler;
import net.minecraft.server.v1_16_R2.EntityTypes;
import org.bukkit.*;
import org.bukkit.craftbukkit.v1_16_R2.CraftWorld;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandSetupMap implements Listener {


    PlayerHandler playerHandler = new PlayerHandler();
    ColorHandler colorHandler = new ColorHandler();


    @EventHandler
    public void hatCommand(PlayerCommandPreprocessEvent event) {

        String message = event.getMessage();
        String[] args = message.split(" ");

        Player player = event.getPlayer();

        if (args[0].equalsIgnoreCase("/setupmap")) {
            //0 = off || 1 = on
            event.setCancelled(true);
            if(playerHandler.getRank(player) < 10) {
                player.sendMessage(colorHandler.noPermission);
                return;
            }


            Location voteCrate = new Location(Bukkit.getWorld("world"), 4.5,127,-5.5);
            Villager c = (Villager) player.getWorld().spawnEntity(voteCrate, EntityType.VILLAGER);
            c.setInvulnerable(true);
            c.setCollidable(false);
            c.setAI(false);
            c.setProfession(Villager.Profession.LIBRARIAN);
            c.setCustomName(ChatColor.RED + ChatColor.BOLD.toString() + "Vote Crate");
            c.setCustomNameVisible(true);

            Location rewards = new Location(Bukkit.getWorld("world"), -5.5,127,-5.5);
            Villager villager = (Villager) player.getWorld().spawnEntity(rewards, EntityType.VILLAGER);
            villager.setInvulnerable(true);
            villager.setCollidable(false);
            villager.setAI(false);
            villager.setProfession(Villager.Profession.LIBRARIAN);
            villager.setCustomName(ChatColor.RED + ChatColor.BOLD.toString() + "Stats");
            villager.setCustomNameVisible(true);

            Location dailyReward = new Location(Bukkit.getWorld("world"), -5.5,127,4.5);
            Villager dailyr = (Villager) player.getWorld().spawnEntity(dailyReward, EntityType.VILLAGER);
            dailyr.setInvulnerable(true);
            dailyr.setCollidable(false);
            dailyr.setAI(false);
            dailyr.setProfession(Villager.Profession.LIBRARIAN);
            dailyr.setCustomName(ChatColor.RED + ChatColor.BOLD.toString() + "Daily Reward");
            dailyr.setCustomNameVisible(true);
        }
    }



}



