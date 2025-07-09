package org.setup.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public final class Main extends JavaPlugin implements Listener {

    /*
     <dependency>
            <groupId>com.thekanning.openai-gpt3-java</groupId>
            <artifactId>client</artifactId>
            <version>0.8.0</version>
            <scope>compile</scope>
        </dependency>
     */

    @Override
    public void onEnable() {
        TalkCommand cmd = new TalkCommand(this);
        getCommand("talk").setExecutor(cmd);
        Bukkit.getPluginManager().registerEvents(cmd, this);
    }


}
