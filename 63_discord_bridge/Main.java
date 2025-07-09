package org.setup.minecraft;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import javax.security.auth.login.LoginException;

/*

        <dependency>
            <groupId>net.dv8tion</groupId>
            <artifactId>JDA</artifactId>
            <version>5.0.0-alpha.5</version>
            <scope>compile</scope>
        </dependency>

*/

public final class Main extends JavaPlugin implements Listener {

    private JDA jda;

    @Override
    public void onEnable() {
        getCommand("giverole").setExecutor(new GiveRoleCommand(this));

        JDABuilder builder = JDABuilder.createDefault("TOKEN");
        builder.setActivity(Activity.watching("your server."));
        builder.addEventListeners(new DiscordListener());
        try {
            jda = builder.build();
            System.out.println("Success!");
        } catch (LoginException e) {
            throw new RuntimeException(e);
        }

    }

    public JDA getJda() {
        return jda;
    }
}
