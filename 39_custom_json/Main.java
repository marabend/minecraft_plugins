package org.setup.minecraft;

import com.google.gson.Gson;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.util.Date;

public final class Main extends JavaPlugin implements Listener {


    @Override
    public void onEnable() {
        Data data = new Data("Marcel", true, new Date());
        try {
            getDataFolder().mkdir();
            File file = new File(getDataFolder(), "data.json");
            if(!file.exists()) {
                file.createNewFile();
            }

            Gson gson = new Gson();


           Reader reader = new FileReader(file);
           Data readData = gson.fromJson(reader, Data.class);
           System.out.println(readData.getPlayerName());
           System.out.println(readData.getValue());
           System.out.println(readData.getDate().toString());


            /*
            Writer writer = new FileWriter(file, false );
            gson.toJson(data, writer);

            writer.flush();
            writer.close();

            System.out.println("Saved data!");

        */

        }catch(IOException e) {
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
