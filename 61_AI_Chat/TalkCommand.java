package org.setup.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

public class TalkCommand implements CommandExecutor, Listener {

    private Main main;
    private OPenAiService service = new OpenAiService("Access-TOKEN", 0);
    private HashMap<UUID, StringBuilder> conversations = new HashMap<>();

    public TalkCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(conversations.containsKey(player.getUniqueId())) {

                conversations.remove(player.getUniqueId());
                player.sendMessage("Your conversation with the AI bot has ended.");

            } else {
                conversations.put(player.getUniqueId(), new StringBuilder("The following is a conversation with an AI assistant. The assistant is helpful, creative, clever, and very friendly"
                        + "\n"
                        + "Human: Hello!\n"
                        + "AI:"));
                player.sendMessage("You have started a conversation with the AI bot. Say hello!");
            }
        }

        return false;
    }

    @EventHandler
    public void onAsyncPlayerChat(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();

        if(conversations.containsKey(player.getUniqueId())) {
            e.setCancelled(true);
            player.sendMessage("You: " + e.getMessage());

            Bukkit.getScheduler().runTaskAsynchronously(main, () -> player.sendMessage("AI: " + getResponse(player.getUniqueId(), e.getMessage())));
        }
    }

    private String getResponse(UUID uuid, String message) {
        conversations.get(uuid).append("\nHuman:").append(message).append("\nAI:");
        CompletionRequest request = CompletionRequest.builder()
                .prompt(conversations.get(uuid).toString())
                .model("text-davinci-003")
                .temperature(0.9D)
                .maxTokens(150)
                .topP(1.0D)
                .frequencyPenalty(0)
                .presencePenalty(0.6D)
                .stop(Arrays.asList("Human:", "AI:"))
                .build();

        return service.createCompletion(request).getChoices().get(0).getText();
    }
}
