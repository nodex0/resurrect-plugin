package dev.nodex0.spigot.resurrectplugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.ChatColor;
import org.bukkit.Bukkit;

public class EventHandlers implements Listener {

    private ResurrectPlugin plugin;

    public EventHandlers(ResurrectPlugin pl) {
        this.plugin = pl;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        // Send a message to the player
        player.sendMessage(ChatColor.RED + "> Usa " + ChatColor.YELLOW + "/resurrect" + ChatColor.RED + " para volver al lugar de muerte");
        // Save the player's location
        plugin.savePlayersDeathLocation(player.getUniqueId(), player.getLocation());
    }

}