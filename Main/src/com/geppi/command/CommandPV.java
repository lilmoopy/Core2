package com.geppi.command;

import com.geppi.other.ColorHandler;
import com.geppi.other.PlayerHandler;
import com.geppi.other.PlayerVaultHandler;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.Inventory;

public class CommandPV implements Listener {


    PlayerHandler playerHandler = new PlayerHandler();
    PlayerVaultHandler playerVaultHandler = new PlayerVaultHandler();
    ColorHandler colorHandler = new ColorHandler();


    @EventHandler
    public void hatCommand(PlayerCommandPreprocessEvent event) {

        String message = event.getMessage();
        String[] args = message.split(" ");

        Player player = event.getPlayer();

        if (args[0].equalsIgnoreCase("/pv") || args[0].equalsIgnoreCase("/playervault")) {
            //0 = off || 1 = on
          event.setCancelled(true);

          Inventory inv = Bukkit.createInventory(player, 54, player.getName() + "'s Private Vault");

            if (playerVaultHandler.menus.containsKey(player.getUniqueId().toString()))
                inv.setContents(playerVaultHandler.menus.get(player.getUniqueId().toString()));

            player.openInventory(inv);


        }
    }

}

