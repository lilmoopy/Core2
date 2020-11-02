package com.geppi.event;

import com.geppi.other.PlayerHandler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlaceBlock implements Listener {

    PlayerHandler playerHandler = new PlayerHandler();

    @EventHandler
    public void onPlaceBlock(BlockPlaceEvent event) {
        playerHandler.setBlocksPlaced(event.getPlayer(), playerHandler.getBlocksPlaced(event.getPlayer()) + 1);

    }


}
