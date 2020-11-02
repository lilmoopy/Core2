package com.geppi.other;

import com.geppi.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.print.DocFlavor;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;


public class PlayerVaultHandler {
    ColorHandler colorHandler = new ColorHandler();
    public Map<String, ItemStack[]> menus = new HashMap<String, ItemStack[]>();

    public void setupPV() {
        File f = new File("plugins/GameCore/" + "pv.yml");
        if (!f.exists())
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);

        yml.addDefault("playervault", "test");

        yml.options().copyDefaults(true);
        try {
            yml.save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveInvs() {
        File f = new File("plugins/GameCore/" + "pv.yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);

        for (Map.Entry<String, ItemStack[]> entry : menus.entrySet()) {
            yml.set("PV." + entry.getKey(), entry.getValue());
        }
        try {
            yml.save(f);
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    public void restoreInvs() {
        File f = new File("plugins/GameCore/" + "pv.yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        yml.getConfigurationSection("PV").getKeys(false).forEach(key ->{
            @SuppressWarnings("unchecked")
            ItemStack[] content = ((List<ItemStack>) yml.get("PV." + key)).toArray(new ItemStack[0]);
            menus.put(key, content);
        });
    }





}