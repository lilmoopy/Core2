package com.geppi.event;

import com.geppi.other.PlayerVaultHandler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class InventoryClose implements Listener {

    PlayerVaultHandler playerVaultHandler = new PlayerVaultHandler();

    @EventHandler
    public void onGUIClose(InventoryCloseEvent event) {
        if (event.getView().getTitle().contains(event.getPlayer().getName() + "'s Private Vault"))
            playerVaultHandler.menus.put(event.getPlayer().getUniqueId().toString(), event.getInventory().getContents());

    }

}
