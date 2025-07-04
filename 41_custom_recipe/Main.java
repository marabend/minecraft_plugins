package org.setup.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {


    @Override
    public void onEnable() {

        /*
        1. Recipe
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(this, "custom_diamond_sword"), new ItemStack(Material.DIAMOND_SWORD));

        recipe.shape(
                  " D ",
                " D ",
                " D "
        );

        recipe.setIngredient('D', Material.DIAMOND);

        Bukkit.addRecipe(recipe);
         */

        /*
        2.

        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(this, "custom_diamond_sword"), new ItemStack(Material.BARRIER));

        recipe.shape(
                "R R",
                " R ",
                "R R"
        );

        recipe.setIngredient('R', Material.RED_WOOL);

        Bukkit.addRecipe(recipe);

         */


        // 3

        ItemStack is = new ItemStack(Material.STICK);
        is.addUnsafeEnchantment(Enchantment.AQUA_AFFINITY, 1); // Does not work as API does not provide DURABILITY

        ItemMeta isMeta = is.getItemMeta();
        is.setItemMeta(isMeta);
        isMeta.setDisplayName(ChatColor.BLUE.toString() + ChatColor.BOLD + "Custom Stick!");

        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(this, "custom_diamond_sword"), is);

        recipe.shape(
                "GGG",
                "GSG",
                "GGG"
        );

        recipe.setIngredient('G', Material.RED_WOOL);
        recipe.setIngredient('S', Material.STICK);

        Bukkit.addRecipe(recipe);
    }
}
