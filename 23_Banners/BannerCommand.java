package org.setup.minecraft;

import org.bukkit.DyeColor;
import org.bukkit.Material;

import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;

public class BannerCommand implements CommandExecutor {

// TODO: Check API, as it throws a runtime exception
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            if(Material.WHITE_BANNER.isItem()) {
                ItemStack item = new ItemStack(Material.WHITE_BANNER);
                BannerMeta meta = (BannerMeta) item.getItemMeta();

                meta.setPattern(0, new Pattern(DyeColor.LIGHT_BLUE, PatternType.RHOMBUS));
                meta.setPattern(1, new Pattern(DyeColor.YELLOW, PatternType.BORDER));

                item.setItemMeta(meta);

                ((Player) sender).getInventory().addItem(item);
            } else {
                System.out.println("ERRRRRRRROOOOOOOOOOOOOOOOORRRRRRRRRRRR!!!!!!!!!!!!!!!!!!!!!! Material is not an ITEM");
            }
        }
        return false;
    }
}
