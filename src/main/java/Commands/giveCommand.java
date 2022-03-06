package Commands;

import ItemCfg.MjollnirCfg;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class giveCommand extends MjollnirCfg implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("mjollnir.command")) {
                player.getInventory().addItem(Mjollnir());
                player.sendMessage(ChatColor.GOLD + "[" + ChatColor.GRAY + "Mjollnir" + ChatColor.GOLD + "]" + " You got legendary Thor's hammer");
                return true;
            }
            player.sendMessage(ChatColor.GOLD + "[" + ChatColor.GRAY + "Mjollnir" + ChatColor.GOLD + "]" + ChatColor.RED + " You don't have permission.");
        }
        sender.sendMessage("You must be a player.");
        return false;
    }
}
