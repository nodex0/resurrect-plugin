package dev.nodex0.spigot.resurrectplugin;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;

public class CommandResurrect implements CommandExecutor {

    private ResurrectPlugin plugin;

    public CommandResurrect(ResurrectPlugin pl) {
        this.plugin = pl;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            // Get the player location (and remove it)
            Location deathLocation = plugin.getPlayersDeathLocation(player.getUniqueId());
            // If it has not died before, dont do anything
            if (deathLocation != null) {
                // Teleport the player to the location
                player.teleport(deathLocation);
            }
        }
        return true;
    }

}