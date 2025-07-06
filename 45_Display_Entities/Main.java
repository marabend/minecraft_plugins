package org.setup.minecraft;


import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin   {


    @Override
    public void onEnable() {
        World world = Bukkit.getWorld("world");
        // TEXT DISPLAYS
        TextDisplay textDisplay = (TextDisplay) world.spawnEntity(world.getBlockAt(0,65,0).getLocation(), EntityType.TEXT_DISPLAY);
        textDisplay.setText(ChatColor.RED + "Join my Minecraft course!");
        textDisplay.setBackgroundColor(Color.AQUA);

        // textDisplay.setBillboard(Display.Billboard.FIXED);

        // BLOCK DISPLAYS
        BlockDisplay blockDisplay = (BlockDisplay) world.spawnEntity(world.getBlockAt(0,70,0).getLocation(), EntityType.FALLING_BLOCK);
        blockDisplay.setBlock(Material.BIRCH_PLANKS.createBlockData());
        blockDisplay.setBrightness(new Display.Brightness(10,10));


        // ITEM DISPLAYS
        ItemDisplay itemDisplay = (ItemDisplay) world.spawnEntity(world.getBlockAt(0,75,0).getLocation(), EntityType.ITEM_DISPLAY);
        itemDisplay.setItemStack(new ItemStack(Material.WOODEN_SWORD));
        itemDisplay.setItemDisplayTransform(ItemDisplay.ItemDisplayTransform.GUI);

    }

}
