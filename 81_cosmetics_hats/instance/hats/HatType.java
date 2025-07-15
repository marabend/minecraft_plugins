package org.setup.minecraft.instance.hats;


import org.bukkit.ChatColor;

import java.util.Arrays;
import java.util.List;

public enum HatType {

    TOP_HAT(
            ChatColor.RED + "Top Hat",
            Arrays.asList(ChatColor.GRAY + "Fancy!"),
                    "<ID>"),
    TIGER_HAT(
            ChatColor.GOLD + "Tiger Hat",
            Arrays.asList(ChatColor.GRAY + "Keep away!"),
            "<ID>"),
    DOG_HAT(
            ChatColor.YELLOW + "Dog Hat",
            Arrays.asList(ChatColor.GRAY + "Careful I bite!"),
            "<ID>");

    private String display;
    private String headTexture;
    private List<String> description;

    HatType(String display, List<String> description, String headTexture) {
        this.display = display;
        this.description = description;
        this.headTexture = headTexture;
    }

    public String getDisplay() {
        return display;
    }

    public List<String> getDescription() {
        return description;
    }

    public String getHeadTexture() {
        return headTexture;
    }


}
