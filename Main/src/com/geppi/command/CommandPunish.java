package com.geppi.command;

import com.geppi.other.ColorHandler;
import com.geppi.other.PlayerHandler;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.UUID;

import static org.bukkit.Bukkit.getServer;

public class CommandPunish implements Listener {


    PlayerHandler playerHandler = new PlayerHandler();
    ColorHandler colorHandler = new ColorHandler();

    //KICK - BAN - MUTE

    @EventHandler
    public void hatCommand(PlayerCommandPreprocessEvent event) {

        String message = event.getMessage();
        String[] args = message.split(" ");

        Player player = event.getPlayer();

        if (args[0].equalsIgnoreCase("/mute")) {
            //0 = off || 1 = on
            event.setCancelled(true);
            if(playerHandler.getRank(player) < 8) {
                player.sendMessage(colorHandler.noPermission);
                return;
            }

            if(args.length < 3) {
                player.sendMessage(colorHandler.usage + args[0] + " <player> <reason>");
                return;
            }

            Player target = getServer().getPlayer(args[1]);
            if(target == null) {
                player.sendMessage(colorHandler.offlinePlayer);
                return;
            }

            playerHandler.setMuteDate(target, "Muted By: " + player.getName() + " for " + event.getMessage().replaceFirst(args[0], "".replaceFirst(args[1], "")));


        }
        if (args[0].equalsIgnoreCase("/ban")) {
            //0 = off || 1 = on
            event.setCancelled(true);
            if(playerHandler.getRank(player) < 8) {
                player.sendMessage(colorHandler.noPermission);
                return;
            }
            if(args.length < 3) {
                player.sendMessage(colorHandler.usage + args[0] + " <player> <reason>");
                return;
            }
            Player target = getServer().getPlayer(args[1]);
            if(target == null) {
                player.sendMessage(colorHandler.offlinePlayer);
                return;
            }

            playerHandler.setBanDate(target, "Banned By: " + player.getName() + " for " + event.getMessage().replaceFirst(args[0], "".replaceFirst(args[1], "")));
            target.kickPlayer("Banned By: " + player.getName() + " for " + event.getMessage().replaceFirst(args[0], "".replaceFirst(args[1], "")));
        }
        if (args[0].equalsIgnoreCase("/kick")) {
            //0 = off || 1 = on
            event.setCancelled(true);
            if(playerHandler.getRank(player) < 8) {
                player.sendMessage(colorHandler.noPermission);
                return;
            }
            if(args.length < 3) {
                player.sendMessage(colorHandler.usage + args[0] + " <player> <reason>");
                return;
            }
            Player target = getServer().getPlayer(args[1]);
            if(target == null) {
                player.sendMessage(colorHandler.offlinePlayer);
                return;
            }

            target.kickPlayer("Kicked By: " + player.getName() + " for " + event.getMessage().replaceFirst(args[0], "".replaceFirst(args[1], "")));

        }
        if (args[0].equalsIgnoreCase("/warn")) {
            //0 = off || 1 = on
            event.setCancelled(true);
            if(playerHandler.getRank(player) < 8) {
                player.sendMessage(colorHandler.noPermission);
                return;
            }
            if(args.length < 3) {
                player.sendMessage(colorHandler.usage + args[0] + " <player> <reason>");
                return;
            }
            Player target = getServer().getPlayer(args[1]);
            if(target == null) {
                player.sendMessage(colorHandler.offlinePlayer);
                return;
            }

            target.sendMessage("Warned By: " + player.getName() + " for " + event.getMessage().replaceFirst(args[0], "".replaceFirst(args[1], "")));

        }
        if (args[0].equalsIgnoreCase("/unmute")) {
            //0 = off || 1 = on
            event.setCancelled(true);
            if(playerHandler.getRank(player) < 8) {
                player.sendMessage(colorHandler.noPermission);
                return;
            }
            if (args.length != 2) {
                player.sendMessage(colorHandler.usage + args[0] + " <player>");
                return;
            }

            Player target = getServer().getPlayer(args[1]);
            if(target == null) {
                player.sendMessage(colorHandler.offlinePlayer);
                return;
            }

            playerHandler.removeMute(target);
        }
        if (args[0].equalsIgnoreCase("/unban")) {
            //0 = off || 1 = on

            event.setCancelled(true);
            if(playerHandler.getRank(player) < 8) {
                player.sendMessage(colorHandler.noPermission);
                return;
            }
            if (args.length != 2) {
                player.sendMessage(colorHandler.usage + args[0] + " <player>");
                return;
            }


            Player target = getServer().getPlayer(args[1]);
            if(target == null) {
                player.sendMessage(colorHandler.offlinePlayer);
                return;
            }



            playerHandler.removeBan(player);
        }
    }

}

