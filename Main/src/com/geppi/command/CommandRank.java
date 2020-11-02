package com.geppi.command;

import com.geppi.other.ColorHandler;
import com.geppi.other.PlayerHandler;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import static org.bukkit.Bukkit.getServer;

public class CommandRank implements Listener {
    PlayerHandler playerHandler = new PlayerHandler();
    ColorHandler colorHandler = new ColorHandler();

    @EventHandler
    public void moneyAdminCommand(PlayerCommandPreprocessEvent event) {

        String message = event.getMessage();
        String[] args = message.split(" ");

        Player player = event.getPlayer();

        if(args[0].equalsIgnoreCase("/rankup")) {
            event.setCancelled(true);
            if(playerHandler.getRank(player) >= 5) {
                player.sendMessage(colorHandler.main + "Rank: " + colorHandler.message + "Your rank can not rankup!");
                return;
            }
            if(playerHandler.getRank(player) == 1) {
                if(playerHandler.getMoney(player) < 10000) {
                    player.sendMessage(colorHandler.main + "Rank: " + colorHandler.message + "You do not have enough money to rankup!");
                    return;
                }
                playerHandler.removeMoney(player, 10000);
                playerHandler.setRank(player, 2);
                return;
            }
            if(playerHandler.getRank(player) == 2) {
                if(playerHandler.getMoney(player) < 20000) {
                    player.sendMessage(colorHandler.main + "Rank: " + colorHandler.message + "You do not have enough money to rankup!");
                    return;
                }
                playerHandler.removeMoney(player, 20000);
                playerHandler.setRank(player, 3);
                return;
            }
            if(playerHandler.getRank(player) == 3) {
                if(playerHandler.getMoney(player) < 50000) {
                    player.sendMessage(colorHandler.main + "Rank: " + colorHandler.message + "You do not have enough money to rankup!");
                    return;
                }
                playerHandler.removeMoney(player, 50000);
                playerHandler.setRank(player, 4);
                return;
            }
            if(playerHandler.getRank(player) == 4) {
                if(playerHandler.getMoney(player) < 100000) {
                    player.sendMessage(colorHandler.main + "Rank: " + colorHandler.message + "You do not have enough money to rankup!");
                   return;
                }
                playerHandler.removeMoney(player, 100000);
                playerHandler.setRank(player, 5);
                return;
            }




        }

        if (args[0].equalsIgnoreCase("/setrank")) {
            event.setCancelled(true);

        /*    if(playerHandler.getRank(player) < 10) {
                player.sendMessage(colorHandler.noPermission);
                return;
            }*/

            if(args.length != 3) {
                player.sendMessage(colorHandler.usage + args[0] + " <player> <rank>");
                return;
            }
            Player target = getServer().getPlayer(args[1]);
            if(target == null) {
                player.sendMessage(colorHandler.offlinePlayer);
                return;
            }

            int num;
            try {
                num = Integer.parseInt(args[2]);
            } catch (NumberFormatException ex){
                player.sendMessage(colorHandler.nonNumber);
                return;
            }

            playerHandler.setRank(target, num);
            player.sendMessage(colorHandler.main + "Rank: " + colorHandler.message + "Set " + target.getName() + "'s rank to " + args[2]);
            target.sendMessage(colorHandler.main + "Rank: " + colorHandler.message + "has been updated to " + playerHandler.rankToString(target));
            target.setCustomName(playerHandler.rankToString(target) + playerHandler.getNickname(target));
            target.setPlayerListName(playerHandler.rankToString(target) + playerHandler.getNickname(target));

        }

    }
}