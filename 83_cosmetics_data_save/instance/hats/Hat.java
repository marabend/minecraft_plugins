package org.setup.minecraft.instance.hats;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.setup.minecraft.Cosmetics;
import org.setup.minecraft.instance.Cosmetic;

import java.lang.reflect.Field;
import java.util.UUID;

public class Hat extends Cosmetic {

    private HatType type;

    public Hat(Cosmetics cosmetics, Player player, HatType type) {
        super(cosmetics, player);
        this.type = type;
    }

    @Override
    public void enable() {
        ItemStack is = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) is.getItemMeta();

        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new Property("textures"), type.getHeadTexture());
        Field field;

        try {
            field = meta.getClass().getDeclaredField("profile");
            field.setAccessible(true);
            field.set(meta, profile);
        } catch(NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return;
        }

        is.setItemMeta(meta);
        player.getInventory().setHelmet(is);
    }

    @Override
    public void disable() {
        player.getInventory().setHelmet(null);
    }

    public HatType getType() {
        return type;
    }
}
