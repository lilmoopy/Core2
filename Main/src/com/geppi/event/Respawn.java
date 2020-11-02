package com.geppi.event;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class Respawn implements Listener  {


    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        Location spawn = new Location(Bukkit.getWorld("world"), -0.5,125,-0.5);
        event.setRespawnLocation(spawn);
    }
}
