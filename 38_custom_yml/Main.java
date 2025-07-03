package org.setup.minecraft;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Main extends JavaPlugin implements Listener {


    @Override
    public void onEnable() {
       try {
           initiateFile("homes.yml"); // Will be stored under TestPlugin which has been configured within plugin.yml
           initiateFile("warps.yml");
           initiateFile("data.yml");
       }catch(Exception e) {
           e.printStackTrace();
       }
    }

    private void initiateFile(String name) throws Exception {
        File file =  new File(getDataFolder(), name);

        if(!file.exists()) {
                file.createNewFile();
        }

        YamlConfiguration modifyFile = YamlConfiguration.loadConfiguration(file);
    }

}
