package com.geppi.other;

import com.geppi.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class JailHandler {

    PlayerHandler playerHandler = new PlayerHandler();
    ColorHandler colorHandler = new ColorHandler();
     public void Jail() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                for(Player player : Bukkit.getOnlinePlayers()) {
                    if(playerHandler.getJailTime(player) > 0) {
                        playerHandler.setJailTime(player, playerHandler.getJailTime(player) - 1);
                        if(playerHandler.getJailTime(player) == 1) {
                            player.sendMessage(colorHandler.main + "Jail: " + colorHandler.message + "You have been released!");
                            playerHandler.resetJailTime(player);
                            Location spawn = new Location(Bukkit.getWorld("world"), -0.5,125,-0.5);
                            player.teleport(spawn);
                        }
                    }


                }
            }
        }, 0L, 20L);
    }

}
