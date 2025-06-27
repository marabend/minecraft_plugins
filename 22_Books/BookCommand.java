package org.setup.minecraft;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class BookCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {

        if(commandSender instanceof Player) {
            Player player = (Player) commandSender;
            ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
            BookMeta meta = (BookMeta) book.getItemMeta();
            meta.setTitle(ChatColor.RED + "My Epic Book!");
            meta.setAuthor(ChatColor.YELLOW + "Stephen");
            meta.addPage(ChatColor.BLUE + "Welcome to my book!" +
                    "\n\n" + ChatColor.GREEN + "This book is about.....");
            book.setItemMeta(meta);
            player.getInventory().addItem(book);

        }

        return false;
    }
}
