package org.setup.minecraft.kit.type;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.setup.minecraft.Minigame;
import org.setup.minecraft.kit.Kit;
import org.setup.minecraft.kit.KitType;

import java.util.UUID;

public class FighterKit extends Kit {
    public FighterKit(Minigame minigame, UUID uuid) {
        super(minigame, KitType.FIGHTER, uuid);
    }

    @Override
    public void onStart(Player player) {
        player.getInventory().addItem(new ItemStack(Material.IRON_SWORD));
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 3));

    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {

        if(uuid.equals(e.getPlayer().getUniqueId())) {
            System.out.println(e.getPlayer().getName() + " the Fighter just broke a block!");
        }

    }
}
