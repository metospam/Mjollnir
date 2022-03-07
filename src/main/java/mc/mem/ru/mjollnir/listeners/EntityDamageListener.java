package mc.mem.ru.mjollnir.listeners;

import mc.mem.ru.mjollnir.items.Mjollnir;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamageListener implements Listener {

    public EntityDamageListener(){

    }

    @EventHandler
    public void onEvent(EntityDamageByEntityEvent e){
        if(e.getDamager() instanceof Player){
            Player damager = (Player) e.getDamager();
            if(damager.getItemInHand() != null
                    && damager.getItemInHand().hasItemMeta()
                    && damager.getItemInHand().getItemMeta().hasDisplayName()
                    && damager.getItemInHand().getItemMeta().getDisplayName().equals(Mjollnir.getDisplayName())){
                e.setDamage(Mjollnir.getDamage());
            }
        }
    }
}
