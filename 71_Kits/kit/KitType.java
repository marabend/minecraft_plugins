package org.setup.minecraft.kit;

import org.bukkit.ChatColor;
import org.bukkit.Material;

public enum KitType {

    MINER(ChatColor.RED + "Miner", Material.DIAMOND_PICKAXE, "The best mining kit!"),
    FIGHTER(ChatColor.RED + "Fighter" , Material.DIAMOND_SWORD, "The best fighting kit!");

    private String display;
    private String description;
    private Material material;

    KitType(String display, Material material, String description) {
        this.display = display;
        this.material = material;
        this.description = description;
    }

    public String getDisplay() {
        return display;
    }

    public String getDescription() {
        return description;
    }

    public Material getMaterial() {
        return material;
    }

}
