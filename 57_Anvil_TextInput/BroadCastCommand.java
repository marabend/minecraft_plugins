package org.setup.minecraft;

import net.wesjd.anvilgui.AnvilGUI;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

// NOTE: Might have a few issues

public class BroadCastCommand implements CommandExecutor {

    private Main main;

    public BroadCastCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
            new AnvilGUI.Builder()
                    .onClose(target -> {
                        System.out.println("closed!!!");
                    })
                    .text("Message...")
                    .title("Broadcase message")
                    .itemLeft(new ItemStack(Material.NAME_TAG))
                    .plugin(main)
                    /*.onComplete((target, text) -> {
                        Bukkit.broadcastMessage(target.getName() + " says " + text + ".");
                        return AnvilGUI.Response.close();
                    })
                     */
                    .open(player);
        }

        return false;
    }
}
