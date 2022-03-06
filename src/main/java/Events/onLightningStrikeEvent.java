package Events;

import ItemCfg.MjollnirCfg;
import mc.mem.ru.mjollnir.Mjollnir;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Set;

public class onLightningStrikeEvent extends MjollnirCfg implements Listener {

    @EventHandler
    public void onLightningStrike(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();
        ItemStack itemHand = new ItemStack(player.getInventory().getItemInMainHand());
        ItemMeta itemHandMeta = itemHand.getItemMeta();
        itemHand.setItemMeta(itemHandMeta);
        if (itemHand.hasItemMeta() && itemHandMeta.hasDisplayName()) {
            if (itemHand.getItemMeta().getDisplayName().equals(Mjollnir().getItemMeta().getDisplayName())) {
                if (action == Action.RIGHT_CLICK_BLOCK || action == Action.RIGHT_CLICK_AIR) {
                    Block targetBlock = player.getTargetBlock((Set<Material>) null, 50);
                    player.getWorld().strikeLightning(targetBlock.getLocation());
                    itemHand.setDurability((short) (itemHand.getDurability() - 10));
                }
            }
        }
    }
}
