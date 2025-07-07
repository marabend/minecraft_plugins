package org.setup.minecraft;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Bukkit;
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
    public void onPlayerJoin(PlayerJoinEvent e) {

        // Clickable!
        // None
        // Hoverable!

        TextComponent clickable = new TextComponent("§c§lClickable!");
        clickable.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND,"/help"));

        TextComponent none = new TextComponent("\n\nNothing!");

        TextComponent hoverable = new TextComponent("\n\n§e§lHoverable!");
        hoverable.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Woo! This is hoverable!")));

        e.getPlayer().spigot().sendMessage(new BaseComponent[]{clickable, none, hoverable});

        // This is my Twitter!
        TextComponent start = new TextComponent("§7This is my ");
        TextComponent twitter = new TextComponent("§bTwitter");

        twitter.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL,"https://twitter.com/home"));
        twitter.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Click for my Twitter")));
        TextComponent period = new TextComponent("§7.");

        start.addExtra(twitter);
        start.addExtra(period);

        e.getPlayer().spigot().sendMessage(start);
    }




}
