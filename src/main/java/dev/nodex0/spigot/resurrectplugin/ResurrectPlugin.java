package dev.nodex0.spigot.resurrectplugin;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.HashMap;
import org.bukkit.plugin.PluginManager;
import org.bukkit.Location;
import java.util.UUID;
import dev.nodex0.spigot.resurrectplugin.EventHandlers;
import dev.nodex0.spigot.resurrectplugin.CommandResurrect;

public class ResurrectPlugin extends JavaPlugin {

    private HashMap<UUID, Location> playersLastDeathLocation;

    public void savePlayersDeathLocation(UUID playerUUID, Location deathLocation) {
        playersLastDeathLocation.put(playerUUID, deathLocation);
    }

    public void removePlayersDeathLocation(UUID playerUUID) {
        playersLastDeathLocation.remove(playerUUID);
    }

    public Location getPlayersDeathLocation(UUID playerUUID) {
        return playersLastDeathLocation.remove(playerUUID);
    }

    @Override
    public void onEnable() {
        // Initialize the map
        playersLastDeathLocation = new HashMap<UUID, Location>();
        // Register the event handler
        PluginManager manager = getServer().getPluginManager();
        manager.registerEvents(new EventHandlers(this), this);
        // Register the resurrect command
        this.getCommand("resurrect").setExecutor(new CommandResurrect(this));
    }

    @Override
    public void onDisable() {
        // Free the map
        playersLastDeathLocation = null;
    }

}