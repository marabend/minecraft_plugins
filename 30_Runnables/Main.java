package org.setup.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {


    @Override
    public void onEnable() {
        Bukkit.getScheduler().runTaskLater(this, () -> {
            for(Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage("Server has been up for 10 seconds!");
            }
        }, 200); // 10 * 20

        Bukkit.getScheduler().runTaskTimer(this, () -> {

            for(Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage("It's been 15 seconds - and this goes every 1 second!");
            }

        }, 300, 20); // 15 * 20
    }


}
