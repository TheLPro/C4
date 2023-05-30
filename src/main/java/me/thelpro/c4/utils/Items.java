package me.thelpro.c4.utils;

import me.thelpro.c4.C4;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Items {

    static C4 plugin = C4.plugin;
    static FileConfiguration config = plugin.getConfig();


    public static ItemStack getC4() {

        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&#99714d&lC4&r, a dangerous explosive.\nCombine it with a remote and it will\n&4destroy&ryour enemies!"));

        ItemStack c4 = new ItemStack(Material.POLISHED_BLACKSTONE_BUTTON);
        ItemMeta meta = c4.getItemMeta();

        assert meta != null;
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', config.getString("item-title")));
        meta.setLore(lore);

        c4.setItemMeta(meta);

        return c4;
    }

    public static ItemStack getRemote() {

        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "Use this to ignite&#99714d&lC4&r."));

        ItemStack remote = new ItemStack(Material.REDSTONE_TORCH);
        ItemMeta meta = remote.getItemMeta();

        assert meta != null;
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', config.getString("remote-title")));
        meta.setLore(lore);

        remote.setItemMeta(meta);

        return remote;
    }
}