package com.geppi.event;

import com.geppi.other.ColorHandler;
import com.geppi.other.PlayerHandler;
import com.geppi.other.Inventories;
import com.geppi.other.TimeFormatHandler;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;

public class InventoryClick implements Listener {

    PlayerHandler playerHandler = new PlayerHandler();
    ColorHandler colorHandler = new ColorHandler();
    Inventories inventories = new Inventories();
    TimeFormatHandler timeFormatHandler = new TimeFormatHandler();


      @EventHandler
    private void inventoryClick(InventoryClickEvent event) {
   Player player = (Player) event.getWhoClicked();
      /*  if (event.getView().getTitle().equalsIgnoreCase(ChatColor.GREEN + "Rewards")) {
            event.setCancelled(true);
            if ((event.getCurrentItem() == null) || (event.getCurrentItem().getType().equals(Material.AIR))) {
                return;
            }


            if (event.getCurrentItem().getItemMeta().getDisplayName().contains("Entity Kill")) {
                player.closeInventory();
                if(playerHandler.getEntitiesKilledReward(player) < 500) {
                    player.sendMessage(colorHandler.reward + "Not enough Entity Kill points!");
                    return;
                }
                playerHandler.setEntitiesKilledReward(player, playerHandler.getEntitiesKilledReward(player)-500);
                playerHandler.addMoney(player, playerHandler.getMoney(player) + 5000);
                player.sendMessage(colorHandler.reward +"You has redeemed 500 Entity Kill points for $5000");
            }

            if (event.getCurrentItem().getItemMeta().getDisplayName().contains("Player Kill")) {
                player.sendMessage("Player!");
                player.closeInventory();

            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().contains("Daily Rewards")) {

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
                player.closeInventory();

            }


        } */

        if (event.getView().getTitle().contains("Stats")) {
            event.setCancelled(true);
            if ((event.getCurrentItem() == null) || (event.getCurrentItem().getType().equals(Material.AIR))) {
                return;
            }
            if (event.getCurrentItem().getType().equals(Material.IRON_SWORD)) {
                player.closeInventory();
                inventories.killStreakInv(player);
            }
            if (event.getCurrentItem().getType().equals(Material.PAPER)) {
                player.closeInventory();
                inventories.rewardsInv(player);
            }
            if (event.getCurrentItem().getType().equals(Material.BOOK)) {
                player.closeInventory();
                inventories.totalsInv(player);
            }
        }
          if (event.getView().getTitle().contains("KillStreak")) {
              event.setCancelled(true);
              if ((event.getCurrentItem() == null) || (event.getCurrentItem().getType().equals(Material.AIR))) {
                  return;
              }
          }
          if (event.getView().getTitle().contains("Donation Shop")) {
              event.setCancelled(true);
              if ((event.getCurrentItem() == null) || (event.getCurrentItem().getType().equals(Material.AIR))) {
                  return;
              }
          }

        if(event.getView().getTitle().contains("Rewards")) {
            event.setCancelled(true);
            if ((event.getCurrentItem() == null) || (event.getCurrentItem().getType().equals(Material.AIR))) {
                return;
            }

            if (event.getCurrentItem().getType().equals(Material.PLAYER_HEAD)) {
                player.closeInventory();
                if(playerHandler.getPlayersKilledReward(player) < 5) {
                    player.sendMessage(colorHandler.reward + "Not enough Player Kill points!");
                    return;
                } //FIX THE ONLY COST 5
                playerHandler.setPlayersKilledReward(player, playerHandler.getPlayersKilledReward(player)-5);
                playerHandler.addMoney(player,  5000);
                player.sendMessage(colorHandler.reward +"You has redeemed 500 Player Kill points for $5000");
            }

            if (event.getCurrentItem().getType().equals(Material.ZOMBIE_HEAD)) {
                player.closeInventory();
                if(playerHandler.getEntitiesKilledReward(player) < 5) {
                    player.sendMessage(colorHandler.reward + "Not enough Entity Kill points!");
                    return;
                } //FIX THE ONLY COST 5
                playerHandler.setEntitiesKilledReward(player, playerHandler.getEntitiesKilledReward(player)-5);
                playerHandler.addMoney(player,  5000);
                player.sendMessage(colorHandler.reward +"You has redeemed 500 Player Kill points for $5000");
            }

            if (event.getCurrentItem().getType().equals(Material.DIAMOND_PICKAXE)) {
                player.closeInventory();
                if(playerHandler.getBlocksBroken(player) < 5) {
                    player.sendMessage(colorHandler.reward + "Not enough Broken Block points!");
                    return;
                } //FIX THE ONLY COST 5
                playerHandler.setBlocksBroken(player, playerHandler.getBlocksBroken(player)-5);
                playerHandler.addMoney(player, 5000);
                player.sendMessage(colorHandler.reward +"You has redeemed 500 Break Blocks points for $5000");
            }

            if (event.getCurrentItem().getType().equals(Material.BRICK)) {
                player.closeInventory();
                if(playerHandler.getBlocksPlaced(player) < 5) {
                    player.sendMessage(colorHandler.reward + "Not enough Blocks Placed points!");
                    return;
                } //FIX THE ONLY COST 5
                playerHandler.setBlocksPlaced(player, playerHandler.getBlocksPlaced(player)-5);
                playerHandler.addMoney(player,  5000);
                player.sendMessage(colorHandler.reward +"You has redeemed 500 Blocks placed points for $5000");
            }

        }

          if(event.getView().getTitle().contains("Token Shop")) {
              event.setCancelled(true);
              if ((event.getCurrentItem() == null) || (event.getCurrentItem().getType().equals(Material.AIR))) {
                  return;
              }





              if (event.getCurrentItem().getType().equals(Material.DIAMOND_HELMET)) {
                  player.closeInventory();
                  if(playerHandler.getToken(player) < 500) {
                      player.sendMessage(colorHandler.token + "Not enough tokens to purchase this!");
                      return;
                  }
                  playerHandler.removeToken(player,  500);
                  player.sendMessage(colorHandler.token +"You have purchased " + event.getCurrentItem().getType().toString());
                  player.getInventory().addItem(new ItemStack(event.getCurrentItem().getType()));
              }
              if (event.getCurrentItem().getType().equals(Material.DIAMOND_CHESTPLATE)) {
                  player.closeInventory();
                  if(playerHandler.getToken(player) < 800) {
                      player.sendMessage(colorHandler.token + "Not enough tokens to purchase this!");
                      return;
                  }
                  playerHandler.removeToken(player,  800);
                  player.sendMessage(colorHandler.token +"You have purchased " + event.getCurrentItem().toString());
                  player.getInventory().addItem(new ItemStack(Material.DIAMOND_HELMET));
              }
              if (event.getCurrentItem().getType().equals(Material.DIAMOND_LEGGINGS)) {
                  player.closeInventory();
                  if(playerHandler.getToken(player) < 700) {
                      player.sendMessage(colorHandler.token + "Not enough tokens to purchase this!");
                      return;
                  }
                  playerHandler.removeToken(player,  700);
                  player.sendMessage(colorHandler.token +"You have purchased " + event.getCurrentItem().getType().toString());
                  player.getInventory().addItem(new ItemStack(event.getCurrentItem().getType()));
              }
              if (event.getCurrentItem().getType().equals(Material.DIAMOND_BOOTS)) {
                  player.closeInventory();
                  if(playerHandler.getToken(player) < 400) {
                      player.sendMessage(colorHandler.token + "Not enough tokens to purchase this!");
                      return;
                  }
                  playerHandler.removeToken(player,  400);
                  player.sendMessage(colorHandler.token +"You have purchased " + event.getCurrentItem().getType().toString());
                  player.getInventory().addItem(new ItemStack(event.getCurrentItem().getType()));
              }
              if (event.getCurrentItem().getType().equals(Material.DIAMOND_AXE)) {
                  player.closeInventory();
                  if(playerHandler.getToken(player) < 40) {
                      player.sendMessage(colorHandler.token + "Not enough tokens to purchase this!");
                      return;
                  }
                  playerHandler.removeToken(player,  40);
                  player.sendMessage(colorHandler.token +"You have purchased " + event.getCurrentItem().getType().toString());
                  player.getInventory().addItem(new ItemStack(event.getCurrentItem().getType()));
              }
              if (event.getCurrentItem().getType().equals(Material.DIAMOND_SWORD)) {
                  player.closeInventory();
                  if(playerHandler.getToken(player) < 100) {
                      player.sendMessage(colorHandler.token + "Not enough tokens to purchase this!");
                      return;
                  }
                  playerHandler.removeToken(player,  100);
                  player.sendMessage(colorHandler.token +"You have purchased " + event.getCurrentItem().getType().toString());
                  player.getInventory().addItem(new ItemStack(event.getCurrentItem().getType()));
              }
              if (event.getCurrentItem().getType().equals(Material.DIAMOND_PICKAXE)) {
                  player.closeInventory();
                  if(playerHandler.getToken(player) < 50) {
                      player.sendMessage(colorHandler.token + "Not enough tokens to purchase this!");
                      return;
                  }
                  playerHandler.removeToken(player,  50);
                  player.sendMessage(colorHandler.token +"You have purchased " + event.getCurrentItem().getType().toString());
                  player.getInventory().addItem(new ItemStack(event.getCurrentItem().getType()));
              }
              if (event.getCurrentItem().getType().equals(Material.DIAMOND_SHOVEL)) {
                  player.closeInventory();
                  if(playerHandler.getToken(player) < 25) {
                      player.sendMessage(colorHandler.token + "Not enough tokens to purchase this!");
                      return;
                  }
                  playerHandler.removeToken(player,  25);
                  player.sendMessage(colorHandler.token +"You have purchased " + event.getCurrentItem().getType().toString());
                  player.getInventory().addItem(new ItemStack(event.getCurrentItem().getType()));
              }
              if (event.getCurrentItem().getType().equals(Material.DIAMOND_HOE)) {
                  player.closeInventory();
                  if(playerHandler.getToken(player) < 25) {
                      player.sendMessage(colorHandler.token + "Not enough tokens to purchase this!");
                      return;
                  }
                  playerHandler.removeToken(player,  25);
                  player.sendMessage(colorHandler.token +"You have purchased " + event.getCurrentItem().getType().toString());
                  player.getInventory().addItem(new ItemStack(event.getCurrentItem().getType()));
              }
              if (event.getCurrentItem().getType().equals(Material.ANVIL)) {
                  player.closeInventory();
                  if(playerHandler.getToken(player) < 1500) {
                      player.sendMessage(colorHandler.token + "Not enough tokens to purchase this!");
                      return;
                  }
                  playerHandler.removeToken(player,  1500);
                  player.sendMessage(colorHandler.token +"You have purchased " + event.getCurrentItem().getType().toString());
                  player.getInventory().addItem(new ItemStack(event.getCurrentItem().getType()));
              }
              if (event.getCurrentItem().getType().equals(Material.HOPPER)) {
                  player.closeInventory();
                  if(playerHandler.getToken(player) < 2500) {
                      player.sendMessage(colorHandler.token + "Not enough tokens to purchase this!");
                      return;
                  }
                  playerHandler.removeToken(player,  2500);
                  player.sendMessage(colorHandler.token +"You have purchased " + event.getCurrentItem().getType().toString());
                  player.getInventory().addItem(new ItemStack(event.getCurrentItem().getType()));
              }
              if (event.getCurrentItem().getType().equals(Material.BEACON)) {
                  player.closeInventory();
                  if(playerHandler.getToken(player) < 1500) {
                      player.sendMessage(colorHandler.token + "Not enough tokens to purchase this!");
                      return;
                  }
                  playerHandler.removeToken(player,  1500);
                  player.sendMessage(colorHandler.token +"You have purchased " + event.getCurrentItem().getType().toString());
                  player.getInventory().addItem(new ItemStack(event.getCurrentItem().getType()));
              }
              if (event.getCurrentItem().getType().equals(Material.BOW)) {
                  player.closeInventory();
                  if(playerHandler.getToken(player) < 50) {
                      player.sendMessage(colorHandler.token + "Not enough tokens to purchase this!");
                      return;
                  }
                  playerHandler.removeToken(player,  50);
                  player.sendMessage(colorHandler.token +"You have purchased " + event.getCurrentItem().getType().toString());
                  player.getInventory().addItem(new ItemStack(event.getCurrentItem().getType()));
              }
              if (event.getCurrentItem().getType().equals(Material.ARROW)) {
                  player.closeInventory();
                  if(playerHandler.getToken(player) < 20) {
                      player.sendMessage(colorHandler.token + "Not enough tokens to purchase this!");
                      return;
                  }
                  playerHandler.removeToken(player,  20);
                  player.sendMessage(colorHandler.token +"You have purchased " + event.getCurrentItem().getType().toString());
                  ItemStack arrow = new ItemStack(Material.ARROW);
                  arrow.setAmount(64);
                  player.getInventory().addItem(arrow);
              }
              if (event.getCurrentItem().getType().equals(Material.EXPERIENCE_BOTTLE)) {
                  player.closeInventory();
                  if(playerHandler.getToken(player) < 1000) {
                      player.sendMessage(colorHandler.token + "Not enough tokens to purchase this!");
                      return;
                  }
                  playerHandler.removeToken(player,  1000);
                  player.sendMessage(colorHandler.token +"You have purchased " + event.getCurrentItem().getType().toString());
                  ItemStack experience = new ItemStack(Material.EXPERIENCE_BOTTLE);
                  experience.setAmount(64);
                  player.getInventory().addItem(experience);
              }
              if (event.getCurrentItem().getType().equals(Material.NETHERITE_AXE)) {
                  player.closeInventory();
                  if(playerHandler.getToken(player) < 80) {
                      player.sendMessage(colorHandler.token + "Not enough tokens to purchase this!");
                      return;
                  }
                  playerHandler.removeToken(player,  80);
                  player.sendMessage(colorHandler.token +"You have purchased " + event.getCurrentItem().getType().toString());
                  player.getInventory().addItem(new ItemStack(event.getCurrentItem().getType()));
              }
              if (event.getCurrentItem().getType().equals(Material.NETHERITE_SWORD)) {
                  player.closeInventory();
                  if(playerHandler.getToken(player) < 200) {
                      player.sendMessage(colorHandler.token + "Not enough tokens to purchase this!");
                      return;
                  }
                  playerHandler.removeToken(player,  200);
                  player.sendMessage(colorHandler.token +"You have purchased " + event.getCurrentItem().getType().toString());
                  player.getInventory().addItem(new ItemStack(event.getCurrentItem().getType()));
              }
              if (event.getCurrentItem().getType().equals(Material.NETHERITE_PICKAXE)) {
                  player.closeInventory();
                  if(playerHandler.getToken(player) < 100) {
                      player.sendMessage(colorHandler.token + "Not enough tokens to purchase this!");
                      return;
                  }
                  playerHandler.removeToken(player,  100);
                  player.sendMessage(colorHandler.token +"You have purchased " + event.getCurrentItem().getType().toString());
                  player.getInventory().addItem(new ItemStack(event.getCurrentItem().getType()));
              }
              if (event.getCurrentItem().getType().equals(Material.NETHERITE_SHOVEL)) {
                  player.closeInventory();
                  if(playerHandler.getToken(player) < 50) {
                      player.sendMessage(colorHandler.token + "Not enough tokens to purchase this!");
                      return;
                  }
                  playerHandler.removeToken(player,  50);
                  player.sendMessage(colorHandler.token +"You have purchased " + event.getCurrentItem().getType().toString());
                  player.getInventory().addItem(new ItemStack(event.getCurrentItem().getType()));
              }
              if (event.getCurrentItem().getType().equals(Material.NETHERITE_HOE)) {
                  player.closeInventory();
                  if(playerHandler.getToken(player) < 50) {
                      player.sendMessage(colorHandler.token + "Not enough tokens to purchase this!");
                      return;
                  }
                  playerHandler.removeToken(player,  50);
                  player.sendMessage(colorHandler.token +"You have purchased " + event.getCurrentItem().getType().toString());
                  player.getInventory().addItem(new ItemStack(event.getCurrentItem().getType()));
              }
              if (event.getCurrentItem().getType().equals(Material.NETHERITE_HELMET)) {
                  player.closeInventory();
                  if(playerHandler.getToken(player) < 1000) {
                      player.sendMessage(colorHandler.token + "Not enough tokens to purchase this!");
                      return;
                  }
                  playerHandler.removeToken(player,  1000);
                  player.sendMessage(colorHandler.token +"You have purchased " + event.getCurrentItem().getType().toString());
                  player.getInventory().addItem(new ItemStack(event.getCurrentItem().getType()));
              }
              if (event.getCurrentItem().getType().equals(Material.NETHERITE_CHESTPLATE)) {
                  player.closeInventory();
                  if(playerHandler.getToken(player) < 1600) {
                      player.sendMessage(colorHandler.token + "Not enough tokens to purchase this!");
                      return;
                  }
                  playerHandler.removeToken(player,  1600);
                  player.sendMessage(colorHandler.token +"You have purchased " + event.getCurrentItem().getType().toString());
                  player.getInventory().addItem(new ItemStack(event.getCurrentItem().getType()));
              }
              if (event.getCurrentItem().getType().equals(Material.NETHERITE_LEGGINGS)) {
                  player.closeInventory();
                  if(playerHandler.getToken(player) < 1400) {
                      player.sendMessage(colorHandler.token + "Not enough tokens to purchase this!");
                      return;
                  }
                  playerHandler.removeToken(player,  1400);
                  player.sendMessage(colorHandler.token +"You have purchased " + event.getCurrentItem().getType().toString());
                  player.getInventory().addItem(new ItemStack(event.getCurrentItem().getType()));
              }
              if (event.getCurrentItem().getType().equals(Material.NETHERITE_BOOTS)) {
                  player.closeInventory();
                  if(playerHandler.getToken(player) < 800) {
                      player.sendMessage(colorHandler.token + "Not enough tokens to purchase this!");
                      return;
                  }
                  playerHandler.removeToken(player,  800);
                  player.sendMessage(colorHandler.token +"You have purchased " + event.getCurrentItem().getType().toString());
                  player.getInventory().addItem(new ItemStack(event.getCurrentItem().getType()));
              }
              if (event.getCurrentItem().getType().equals(Material.COOKED_BEEF)) {
                  player.closeInventory();
                  if(playerHandler.getToken(player) < 32) {
                      player.sendMessage(colorHandler.token + "Not enough tokens to purchase this!");
                      return;
                  }
                  playerHandler.removeToken(player,  32);
                  player.sendMessage(colorHandler.token +"You have purchased " + event.getCurrentItem().getType().toString());
                  ItemStack cookedBeef = new ItemStack(Material.COOKED_BEEF);
                  cookedBeef.setAmount(64);
                  player.getInventory().addItem(cookedBeef);
              }
              if (event.getCurrentItem().getType().equals(Material.GOLDEN_APPLE)) {
                  player.closeInventory();
                  if(playerHandler.getToken(player) < 500) {
                      player.sendMessage(colorHandler.token + "Not enough tokens to purchase this!");
                      return;
                  }
                  playerHandler.removeToken(player,  500);
                  player.sendMessage(colorHandler.token +"You have purchased " + event.getCurrentItem().getType().toString());
                  player.getInventory().addItem(new ItemStack(event.getCurrentItem().getType()));
              }
              if (event.getCurrentItem().getType().equals(Material.ENCHANTED_GOLDEN_APPLE)) {
                  player.closeInventory();
                  if(playerHandler.getToken(player) < 2000) {
                      player.sendMessage(colorHandler.token + "Not enough tokens to purchase this!");
                      return;
                  }
                  playerHandler.removeToken(player,  2000);
                  player.sendMessage(colorHandler.token +"You have purchased " + event.getCurrentItem().getType().toString());
                  player.getInventory().addItem(new ItemStack(event.getCurrentItem().getType()));
              }


          }

    }


}