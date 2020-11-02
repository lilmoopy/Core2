package com.geppi.event;

import com.geppi.other.ColorHandler;
import com.geppi.other.PlayerHandler;
import com.geppi.other.TimeFormatHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class PublicChat implements Listener {
    PlayerHandler playerHandler = new PlayerHandler();
    ColorHandler colorHandler = new ColorHandler();
    TimeFormatHandler timeFormatHandler = new TimeFormatHandler();

    @EventHandler(priority = EventPriority.HIGH)
    public void chat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage();

        if(playerHandler.getRank(player) > 5 && message.startsWith("#")) {
            event.setCancelled(true);
            for(Player online : Bukkit.getOnlinePlayers()) {
                if(playerHandler.getRank(online) > 5) {
                    online.sendMessage(colorHandler.main + "(GuardChat) " + colorHandler.message + player.getName() + colorHandler.main + ": " + colorHandler.message  + event.getMessage().replaceFirst("#", ""));
                }
            }
            return;
        }
        if(playerHandler.getRank(player) > 7 && message.startsWith("!")) {
            event.setCancelled(true);
            for(Player online : Bukkit.getOnlinePlayers()) {
                if(playerHandler.getRank(online) > 7) {
                    online.sendMessage(colorHandler.main + "(ModChat) " + colorHandler.message + player.getName() + colorHandler.main + ": " + colorHandler.message  + event.getMessage().replaceFirst("!", ""));
                }
            }
            return;
        }



        long elapsedTime = System.currentTimeMillis() - playerHandler.getMuteDate(player);
        long timeUntilReuse = ((24*60*60*1000) - elapsedTime);
        if(timeUntilReuse > 0) {
            event.setCancelled(true);
            player.sendMessage(colorHandler.coolDown + timeFormatHandler.formatTime(timeUntilReuse));
            player.sendMessage(colorHandler.main+ "Mute Information: " +colorHandler.message + playerHandler.getMutedReason(player));
            return;
        }

        event.setFormat(playerHandler.rankToString(player) + playerHandler.getNickname(player) + ChatColor.GRAY + ": " + event.getMessage().replaceFirst("%", "%%"));


        return;
    }

}
