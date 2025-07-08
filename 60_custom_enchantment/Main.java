package org.setup.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;


public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        AutoSmeltingEnchantment as = new AutoSmeltingEnchantment();
        Bukkit.getPluginManager().registerEvents(as, this);
        registerEnchantment(as);

        Bukkit.getPluginManager().registerEvents(new JoinListener(as.getKey()), this);
    }

    private void registerEnchantment(Enchantment enchantment) {
        try {
            Field field = Enchantment.class.getDeclaredField("acceptingNew");
            field.setAccessible(true);
            field.set(null, true);
            // The line below does not work any more
            //Enchantment.registerEnchantment(enchantment);
        }catch(NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
