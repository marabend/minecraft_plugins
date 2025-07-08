package org.setup.minecraft;

import com.sk89q.worldedit.WorldEdit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        WorldEdit we = new WorldEdit.getInstance();
        System.out.println("api working: " + we != null);
    }

}
