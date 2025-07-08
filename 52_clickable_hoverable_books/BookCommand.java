package org.setup.minecraft;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.awt.*;

public class BookCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
            BookMeta meta = (BookMeta) book.getItemMeta();
            meta.setAuthor("Stpehen");
            meta.setTitle("My Book");

            TextComponent clickable = new TextComponent("§c§lClickable");
            clickable.setClickEvent(new ClickEvent(ClickEvent.Action.CHANGE_PAGE, "2"));

            TextComponent none = new TextComponent("\n\n§3None");
            TextComponent hoverable = new TextComponent("\n\n§bHoverable");
            hoverable.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Woo! This is hoverable!")));

            BaseComponent[] page = new BaseComponent[]{clickable, none, hoverable};

            meta.spigot().addPage(page);
            meta.addPage("First\nSecond\nThird");

            book.setItemMeta(meta);
            ((Player) sender).getInventory().addItem(book);
        }
        return false;
    }
}
