package mc.mem.ru.mjollnir.listeners;

import mc.mem.ru.mjollnir.items.Mjollnir;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class LightningStrikeListener implements Listener {

    public LightningStrikeListener(){

    }

    @EventHandler
    public void onLightningStrike(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack handItem = player.getItemInHand();

        if(event.getAction().equals(Action.RIGHT_CLICK_AIR)
                || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){

            if (handItem != null
                    && handItem.hasItemMeta()
                    && handItem.getItemMeta().hasDisplayName()) {

                if (handItem.getItemMeta().getDisplayName().equals(Mjollnir.getDisplayName())) {

                        Block targetBlock = player.getTargetBlock(null, 50);
                        player.getWorld().strikeLightning(targetBlock.getLocation());
                        if(handItem.getType().getMaxDurability() < handItem.getDurability() + 10){
                            player.setItemInHand(new ItemStack(Material.AIR));
                        }
                        else{
                            handItem.setDurability((short) (handItem.getDurability() + 10));
                        }

                }
            }
        }

    }
}
