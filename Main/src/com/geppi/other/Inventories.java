package com.geppi.other;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;



public class Inventories {



    PlayerHandler playerHandler = new PlayerHandler();
    ColorHandler colorHandler = new ColorHandler();

    // /STATS - INVENTORY - REWARDS

    public Inventory statsInventory;
    public Inventory killStreakInventory;
    public Inventory rewardsInventory;
    public Inventory totalsInventory;
    public Inventory tokenShopInventory;
    public Inventory donationShopInventory;



    public void statsInv(Player player) {
        statsInventory = Bukkit.createInventory(null, InventoryType.HOPPER, colorHandler.main +"Stats");
        createItem(Material.IRON_SWORD, statsInventory, 0, "Kill Streak", null);
        createItem(Material.PAPER, statsInventory, 2, "Rewards", null);
        createItem(Material.BOOK, statsInventory, 4, "Totals", null);
        player.openInventory(statsInventory);
    }
    public void killStreakInv(Player player) {
        int kills = playerHandler.getKills(player);
        double deaths = playerHandler.getDeaths(player);
        double ratio = kills / deaths;

        killStreakInventory = Bukkit.createInventory(null, InventoryType.HOPPER, colorHandler.main +"KillStreak");
        createItem(Material.IRON_SWORD, killStreakInventory, 0, "Kills", String.valueOf(playerHandler.getKills(player)));
        createItem(Material.REDSTONE, killStreakInventory, 1, "Deaths", String.valueOf(playerHandler.getDeaths(player)));
        createItem(Material.BOW, killStreakInventory, 2, "Kill Streak", String.valueOf(playerHandler.getKillStreak(player)));
        createItem(Material.PAPER, killStreakInventory, 3, "Last Killed By", String.valueOf(playerHandler.getLKBP(player)));
        createItem(Material.BOOK, killStreakInventory, 4, "K/D", String.valueOf(ratio));
        player.openInventory(killStreakInventory);
    }
    public void rewardsInv(Player player) {
        rewardsInventory = Bukkit.createInventory(null, 9, colorHandler.main +"Rewards");
        createItem(Material.DIAMOND_PICKAXE, rewardsInventory, 1, "Blocks Broken", String.valueOf(playerHandler.getBlocksBroken(player)));
        createItem(Material.BRICK, rewardsInventory, 2, "Blocks Placed", String.valueOf(playerHandler.getBlocksPlaced(player)));
        createItem(Material.ZOMBIE_HEAD, rewardsInventory, 3, "Entities Killed",  String.valueOf(playerHandler.getEntitiesKilledReward(player)));
        createItem(Material.PLAYER_HEAD, rewardsInventory, 4, "Players Killed", String.valueOf(playerHandler.getPlayersKilledReward(player)));
        createItem(Material.NETHER_STAR, rewardsInventory, 5, "Vote", null);
        player.openInventory(rewardsInventory);
    }
    public void totalsInv(Player player) {
        totalsInventory = Bukkit.createInventory(null, 9, colorHandler.main +"Totals");
        createItem(Material.DIAMOND_PICKAXE, totalsInventory, 1, "Blocks Broken", null);
        createItem(Material.BRICK, totalsInventory, 2, "Blocks Placed", null);
        createItem(Material.ZOMBIE_HEAD, totalsInventory, 3, "Entities Killed", null);
        createItem(Material.PLAYER_HEAD, totalsInventory, 4, "Players Killed", null);
        createItem(Material.NETHER_STAR, totalsInventory, 5, "Vote", null);
        player.openInventory(totalsInventory);
    }
    public void donationShopInv(Player player) {
        donationShopInventory = Bukkit.createInventory(null, 9, colorHandler.main +"Donation Shop: " + colorHandler.message + "(" + String.valueOf(playerHandler.getDonationPoints(player)) + " Available)");
        createItem(Material.PUMPKIN, donationShopInventory, 0, "/hat", "(#) Put an item on your head!");
        createItem(Material.DIAMOND_SWORD, donationShopInventory, 1, "/pvp", "(#) Disable/Enable pvp!");
        createItem(Material.NAME_TAG, donationShopInventory, 2, "/namecolor", "(#) Have a custom namecolor!");
        createItem(Material.COOKED_CHICKEN, donationShopInventory, 3, "/feed", "(#) Satisfy your hunger!");
        createItem(Material.IRON_BARS, donationShopInventory, 4, "/bail", "(#) Bail yourself out of jail! ($5000)");
        createItem(Material.NETHER_STAR, donationShopInventory, 5, "/spawn", "(#) Teleport to spawn!");
        createItem(Material.BOOK, donationShopInventory, 6, "/stats", "(#) View stats, totals, redeem rewards, and more!");

        player.openInventory(donationShopInventory);
    }
    public void tokenShopInv(Player player) {
        tokenShopInventory = Bukkit.createInventory(null, 45, colorHandler.main + "Token Shop: " + colorHandler.message + "(" + String.valueOf(playerHandler.getToken(player)) + " Available) " + ChatColor.RED + ChatColor.BOLD.toString() + "Ensure Open Inv Slot!");
        createItem(Material.DIAMOND_HELMET, tokenShopInventory, 0, "Diamond Helmet", "500 Tokens");
        createItem(Material.DIAMOND_AXE, tokenShopInventory, 1, "Diamond Axe", "40 Tokens");
        createItem(Material.ANVIL, tokenShopInventory, 3, "Anvil", "1500 Tokens");
        createItem(Material.HOPPER, tokenShopInventory, 4, "Hopper", "2500 Tokens");
        createItem(Material.BEACON, tokenShopInventory, 5, "Beacon", "1500 Tokens");
        createItem(Material.NETHERITE_AXE, tokenShopInventory, 7, "Netherite Axe", "80 Tokens");
        createItem(Material.NETHERITE_HELMET, tokenShopInventory, 8, "Netherite Helmet", "1000 Tokens");
        createItem(Material.DIAMOND_CHESTPLATE, tokenShopInventory, 9, "Diamond Chestplate", "800 Tokens");
        createItem(Material.DIAMOND_SWORD, tokenShopInventory, 10, "Diamond Sword", "100 Tokens");
      // MENDING  createItem(Material.MENDING, tokenShopInventory, 13, "Vote", null);
        createItem(Material.NETHERITE_SWORD, tokenShopInventory, 16, "Netherite Sword", "200 Tokens");
        createItem(Material.NETHERITE_CHESTPLATE, tokenShopInventory, 17, "Netherite Chestplate", "1600 Tokens");
        createItem(Material.DIAMOND_LEGGINGS, tokenShopInventory, 18, "Diamond Leggings", "700 Tokens");
        createItem(Material.DIAMOND_PICKAXE, tokenShopInventory, 19, "Diamond Pickaxe", "50 Tokens");
        createItem(Material.BOW, tokenShopInventory, 21, "Bow", "50 Tokens");
        createItem(Material.ARROW, tokenShopInventory, 22, "Arrows x64", "20 Tokens");
        createItem(Material.EXPERIENCE_BOTTLE, tokenShopInventory, 23, "Experience Bottles x64", "1000 Tokens");
        createItem(Material.NETHERITE_PICKAXE, tokenShopInventory, 25, "Netherite Pickaxe", "100 Tokens");
        createItem(Material.NETHERITE_LEGGINGS, tokenShopInventory, 26, "Netherite Leggings", "1400 Tokens");
        createItem(Material.DIAMOND_BOOTS, tokenShopInventory, 27, "Diamond Boots", "400 Tokens");
        createItem(Material.DIAMOND_SHOVEL, tokenShopInventory, 28, "Diamond Shovel", "25 Tokens");
        createItem(Material.COOKED_BEEF, tokenShopInventory, 30, "Cooked Beef x64", "32 Tokens");
        createItem(Material.ENCHANTED_GOLDEN_APPLE, tokenShopInventory, 31, "Enchanted Golden Apple", "2000 Tokens");
        createItem(Material.GOLDEN_APPLE, tokenShopInventory, 32, "Golden Apple", "500 Tokens");
        createItem(Material.NETHERITE_SHOVEL, tokenShopInventory, 34, "Netherite Shovel", "50 Tokens");
        createItem(Material.NETHERITE_BOOTS, tokenShopInventory, 35, "Netherite Boots", "800 Tokens");
        createItem(Material.DIAMOND_HOE, tokenShopInventory, 37, "Diamond Hoe", "25 Tokens");
        createItem(Material.NETHERITE_HOE, tokenShopInventory, 43, "Netherite Hoe", "50 Tokens");


        player.openInventory(tokenShopInventory);
    }


    public void createItem(Material material, Inventory inv, int Slot, String name, String lore) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(colorHandler.message + name);
        ArrayList<String> Lore = new ArrayList<String>();
        Lore.add(lore);
        meta.setLore(Lore);
        item.setItemMeta(meta);

        inv.setItem(Slot, item);

    }

}
