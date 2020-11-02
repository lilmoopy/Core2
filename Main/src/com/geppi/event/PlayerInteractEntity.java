package com.geppi.event;

import com.geppi.other.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PlayerInteractEntity implements Listener {
    PlayerHandler playerHandler = new PlayerHandler();
    ColorHandler colorHandler = new ColorHandler();
    CrateHandler crateHandler = new CrateHandler();
    Inventories inventories = new Inventories();
    TimeFormatHandler timeFormatHandler = new TimeFormatHandler();


    @EventHandler
    public void playerInteractCrate(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();

        if(event.getRightClicked().getCustomName().contains(player.getName() + "'s Pet")) {
            event.getRightClicked().remove();
            player.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), 0);
        }

        if (event.getRightClicked().getName().equalsIgnoreCase(ChatColor.RED + ChatColor.BOLD.toString() + "Vote Crate")) {
            if (event.getHand().equals(EquipmentSlot.HAND)) {
                event.setCancelled(true);

                if(playerHandler.getVoteReward(player) == 0) {
                    event.getPlayer().sendMessage(colorHandler.vote + "You do not have enough vote rewards available!");
                    return;
                }

                playerHandler.setVoteReward(player, playerHandler.getVoteReward(player) - 1);
                crateHandler.activateCrate(player);
            }
        }

        if (event.getRightClicked().getName().equalsIgnoreCase(ChatColor.RED + ChatColor.BOLD.toString() + "Stats")) {
            if (event.getHand().equals(EquipmentSlot.HAND)) {
                event.setCancelled(true);

                inventories.statsInv(player);

            }
        }

        if (event.getRightClicked().getName().equalsIgnoreCase(ChatColor.RED + ChatColor.BOLD.toString() + "Daily Reward")) {
            if (event.getHand().equals(EquipmentSlot.HAND)) {
                event.setCancelled(true);

                File f = new File("plugins/GameCore/PlayerData/" + player.getUniqueId() + ".yml");
                YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
                long elapsedTime = System.currentTimeMillis() - playerHandler.getDailyRewardDate(player);
                long timeUntilReuse = ((24*60*60*1000) - elapsedTime);
                if(timeUntilReuse > 0) {
                    player.sendMessage(colorHandler.coolDown + timeFormatHandler.formatTime(timeUntilReuse));
                    player.closeInventory();
                    return;
                }

                player.sendMessage("Daily Reward!");
                playerHandler.setDailyRewardDate(player);


            }
        }


        return;

    }



}
