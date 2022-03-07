package mc.mem.ru.mjollnir.command;

import mc.mem.ru.mjollnir.items.Mjollnir;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GiveCommandExecutor implements CommandExecutor {
    public GiveCommandExecutor(){
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("mjollnir.give")) {
                new Mjollnir(player);
                player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "Mjollnir" + ChatColor.GRAY + "]:" + " You got legendary Thor's hammer");
            }
            else{
                player.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "Mjollnir" + ChatColor.GRAY + "]:" + ChatColor.RED + " You don't have permission.");
            }
        }
        else{
            sender.sendMessage("You must be a player.");
        }
        return true;
    }
}
