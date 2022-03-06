package mc.mem.ru.mjollnir;

import Commands.giveCommand;
import Events.onLightningStrikeEvent;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Mjollnir extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Plugin [Mjollnir] has been Enabled.");
        getCommand("mjollnir").setExecutor(new giveCommand());
        getServer().getPluginManager().registerEvents(new onLightningStrikeEvent(), this);
    }
}
