package mc.mem.ru.mjollnir.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Mjollnir {

    private Player player;
    private ItemStack item;
    private static final double damage = 13.0;
    private static final String displayName = ChatColor.GOLD + "Mjöllnir";

    public Mjollnir(Player player){
        this.player = player;
        this.item = new ItemStack(Material.WOODEN_AXE, 1);
        ItemMeta meta = item.getItemMeta();
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "❖ Изготовлен карликами-двергами Броком и Синдри, ");
        lore.add(ChatColor.GRAY + "при споре с Локи о мастерстве кузнецов.");
        lore.add("");
        lore.add(ChatColor.GRAY + "⚙ Физ. урон: " + ChatColor.RED + damage);

        meta.setDisplayName(displayName);
        meta.setLore(lore);
        item.setItemMeta(meta);
        player.getInventory().addItem(item);
    }

    public static String getDisplayName(){
        return displayName;
    }

    public static double getDamage(){
        return damage;
    }
}
