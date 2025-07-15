package org.setup.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.setup.minecraft.command.ManageCosmeticsCommands;
import org.setup.minecraft.instance.Cosmetic;
import org.setup.minecraft.navigation.CosmeticListener;
import org.setup.minecraft.navigation.CosmeticsCommand;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;


public class Cosmetics extends JavaPlugin  {

    // Useful resource: minecraft-heads.com
    private HashMap<UUID, List<Cosmetic>> activeCosmetics = new HashMap<>();

    @Override
    public void onEnable() {
        getCommand("cosmetics").setExecutor(new CosmeticsCommand(this));
        getCommand("managecosmetics").setExecutor(new ManageCosmeticsCommands(this));
        saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(new CosmeticListener(this), this);
    }

    @Override
    public void onDisable() {

    }

    public HashMap<UUID, List<Cosmetic>> getActiveCosmetics() {
        return activeCosmetics;
    }
}
