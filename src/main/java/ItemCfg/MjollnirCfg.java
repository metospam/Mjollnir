package ItemCfg;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

import static org.bukkit.enchantments.Enchantment.DAMAGE_ALL;

public class MjollnirCfg {
    public ItemStack Mjollnir() {
        ItemStack Mjollnir = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta hammerMeta = Mjollnir.getItemMeta();
        hammerMeta.setDisplayName(ChatColor.GOLD + "Mjöllnir");
        ArrayList<String> Lore = new ArrayList<String>();
        Lore.add(ChatColor.DARK_PURPLE + "Мьёльнир изготовлен карликами-двергами Броком и Синдри при споре с Локи о мастерстве кузнецов.");
        hammerMeta.setLore(Lore);
        hammerMeta.addEnchant(DAMAGE_ALL, 1337, true);
        Mjollnir.setItemMeta(hammerMeta);
        return Mjollnir;
    }
}
