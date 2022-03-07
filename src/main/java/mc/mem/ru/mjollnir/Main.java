package mc.mem.ru.mjollnir;

import mc.mem.ru.mjollnir.command.GiveCommandExecutor;
import mc.mem.ru.mjollnir.listeners.EntityDamageListener;
import mc.mem.ru.mjollnir.listeners.LightningStrikeListener;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Plugin [Mjollnir] has been Enabled.");

        getCommand("mjollnir").setExecutor(new GiveCommandExecutor());
        getServer().getPluginManager().registerEvents(new LightningStrikeListener(), this);
        getServer().getPluginManager().registerEvents(new EntityDamageListener(), this);

    }
}
