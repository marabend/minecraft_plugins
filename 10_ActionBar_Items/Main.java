package org.setup.minecraft;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.getPlayer().sendTitle(ChatColor.RED + "Hello!",
                ChatColor.GREEN + "Welcome to the server!",
                20,
                100,
                20
        );

        e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§4$lHELLO MY FRIEND"));
        e.getPlayer().setPlayerListHeaderFooter(ChatColor.RED + "Hello,", "First Line\nSecond Line!");
    }
}
