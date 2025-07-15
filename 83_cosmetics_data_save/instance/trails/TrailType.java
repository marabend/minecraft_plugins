package org.setup.minecraft.instance.trails;

import org.bukkit.ChatColor;
import org.bukkit.Particle;

import java.util.Arrays;
import java.util.List;

public enum TrailType {

    HEART_TRAIL(
            ChatColor.RED + "Heart Trail",
            Arrays.asList(ChatColor.GRAY + "I love you"),
                    "<ID>",
            Particle.HEART),
    FLAME_TRAIL(
            ChatColor.GOLD + "Flame",
            Arrays.asList(ChatColor.GRAY + "Fancy!"),
            "<ID>",
            Particle.FLAME);

    private String display;
    private String headTexture;
    private List<String> description;
    private Particle particle;

    TrailType(String display, List<String> description, String headTexture, Particle particle) {
        this.display = display;
        this.description = description;
        this.headTexture = headTexture;
        this.particle = particle;
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

    public Particle getParticle() {
        return particle;
    }
}
