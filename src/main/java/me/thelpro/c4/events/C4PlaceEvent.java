package me.thelpro.c4.events;

import me.thelpro.c4.C4;
import me.thelpro.c4.utils.Items;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class C4PlaceEvent implements Listener {

    static C4 plugin = C4.plugin;
    static FileConfiguration config = plugin.getConfig();

    @EventHandler
    public void placeEvent(PlayerInteractEvent e) {

        Player player = e.getPlayer();
        String uuid = player.getUniqueId().toString();

        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getItem() != null && e.getItem().equals(Items.getC4())) {
                player.sendMessage("You placed down a C4, use the remote to ignite it.");
                config.set(uuid, e.getClickedBlock().getLocation().add(0, 1, 0));
            }
        } else if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getItem() != null && e.getItem().equals(Items.getRemote())) {
                if (config.get(uuid) != null) {
                    Location loc = config.getLocation(uuid);
                    player.sendMessage(ChatColor.RED + "BOOM!");
                    loc.getWorld().spawnEntity(loc, EntityType.PRIMED_TNT);
                    config.set(uuid, null);
                } else {
                    player.sendMessage(ChatColor.RED + "You need to place a C4 first!");
                    e.setCancelled(true);
                }
            }
        }
    }
}