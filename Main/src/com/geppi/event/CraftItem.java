package com.geppi.event;

import com.geppi.other.ColorHandler;
import com.geppi.other.PlayerHandler;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;

public class CraftItem implements Listener{

    ColorHandler colorHandler = new ColorHandler();
    PlayerHandler playerHandler = new PlayerHandler();

    @EventHandler
    public void onCraft(CraftItemEvent e) {
        HumanEntity he = e.getWhoClicked();
        if (e.getWhoClicked() instanceof Player) {
            if (e.getInventory().getResult().equals(Material.DIAMOND_SWORD)) {
                e.setCancelled(true);
                e.getInventory().setResult(new ItemStack(Material.AIR));
                he.sendMessage("no craft");
            }
        }
    }
}
