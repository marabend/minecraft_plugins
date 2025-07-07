package org.setup.minecraft;


import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.setup.minecraft.manager.NametagManager;
import org.setup.minecraft.manager.RankManager;

public final class Main extends JavaPlugin {

    /*
        Rank System:
            - / rank command
            - SAve in .yml file
            - Custom permissions
            - Nametags & chat display
     */

    private RankManager rankManager;
    private NametagManager nametagManager;

    @Override
    public void onEnable() {
        getCommand("rank").setExecutor(new RankCommand(this));
        rankManager = new RankManager(this);
        nametagManager = new NametagManager(this);

        Bukkit.getPluginManager().registerEvents(new RankListener(this), this);
    }

    public RankManager getRankManager() {
        return rankManager;
    }

    public NametagManager getNametagManager() {
        return nametagManager;
    }


}
