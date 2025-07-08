package org.setup.minecraft;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class AutoSmeltingEnchantment extends Enchantment implements Listener {

    public AutoSmeltingEnchantment() {
       // old version only:  super(NamespacedKey.minecraft("auto_smelting"));
        super();
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        if(!e.isDropItems()) {return;}
        if(e.getPlayer().getInventory().getItemInMainHand() == null) return;
        if(e.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(this)) {return;}
        if(e.getBlock().getType() != Material.IRON_ORE) return;

        e.setDropItems(false);
        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.IRON_INGOT));
    }

    @Override
    public String getName() {
        return "Auto Smelting";
    }

    @Override
    public int getMaxLevel() {
        return 10;
    }

    @Override
    public int getStartLevel() {
        return 0;
    }

    @Override
    public EnchantmentTarget getItemTarget() {
        return EnchantmentTarget.TOOL;
    }

    @Override
    public boolean isTreasure() {
        return false;
    }

    @Override
    public boolean isCursed() {
        return false;
    }

    @Override
    public boolean conflictsWith(Enchantment other) {
        return false;
    }

    @Override
    public boolean canEnchantItem(ItemStack item) {
        return true;
    }

    @Override
    public NamespacedKey getKey() {
        return null;
    }

    @Override
    public String getTranslationKey() {
        return "";
    }
}
