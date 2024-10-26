package org.setup.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    private BossBar bossBar;

    @Override
    public void onEnable() {
        bossBar = Bukkit.createBossBar(
                ChatColor.LIGHT_PURPLE + "This server is awesome!",
                BarColor.PINK,
                BarStyle.SEGMENTED_6);

        bossBar.setProgress(0.5);

        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        bossBar.addPlayer(e.getPlayer());
    }
}
