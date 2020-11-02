package com.geppi.event;

import com.geppi.main.Main;
import com.geppi.other.PlayerHandler;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener {

    PlayerHandler playerhandler = new PlayerHandler();

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        playerhandler.setBlocksBroken(event.getPlayer(), playerhandler.getBlocksBroken(event.getPlayer()) + 1);
    }

   /* @EventHandler
    public void Replant(BlockBreakEvent e){
        if(e.getBlock().getType()==Material.LEGACY_CROPS){
            e.getBlock().setBlockData((byte) 7);
            e.getBlock().getState().getType()
        }
        /*
         if(e.getBlock().getType() == Material.CROPS){
        e.getBlock().setData((byte) 7);
    }
         */
    }

