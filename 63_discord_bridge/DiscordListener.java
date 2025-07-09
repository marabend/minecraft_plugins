package org.setup.minecraft;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;

public class DiscordListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if(e.getChannel().getId().equals("2345234234")) {
            Bukkit.broadcastMessage(e.getMember().getUser().getAsTag() + ": " + e.getMessage().getContentRaw());

        }
    }
}
