package com.geppi.event;

import com.geppi.other.ColorHandler;
import com.geppi.other.PlayerHandler;
import com.geppi.other.TimeFormatHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener {
    PlayerHandler playerHandler = new PlayerHandler();
    ColorHandler colorHandler = new ColorHandler();
    TimeFormatHandler timeFormatHandler = new TimeFormatHandler();

    @EventHandler(priority = EventPriority.HIGH)
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        playerHandler.setupPlayer(event.getPlayer());
        player.setCustomName(playerHandler.rankToString(player) + playerHandler.getNickname(player));
        player.setPlayerListName(playerHandler.rankToString(player) + playerHandler.getNickname(player));

        long elapsedTime = System.currentTimeMillis() - playerHandler.getBanDate(player);
        long timeUntilReuse = ((24*60*60*1000) - elapsedTime);
        if(timeUntilReuse > 0) {
            event.setJoinMessage(null);
            player.kickPlayer(colorHandler.coolDown + timeFormatHandler.formatTime(timeUntilReuse) + "\nBan Information: " + playerHandler.getBanReason(player));
            return;
        }


        if(playerHandler.isVanished(player) == 1) {
            event.setJoinMessage("");
            player.hidePlayer(player);
            return;
        }


        if(!player.hasPlayedBefore()) {
            event.setJoinMessage(ChatColor.YELLOW + ChatColor.BOLD.toString() + "Welcome " + player.getName());
            Location cspawn = new Location(Bukkit.getWorld("world"), -0.5,138,198.5);
            player.teleport(cspawn);
            return;
        }

        event.setJoinMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "+ " + ChatColor.GRAY + event.getPlayer().getName());

        return;
    }

}
