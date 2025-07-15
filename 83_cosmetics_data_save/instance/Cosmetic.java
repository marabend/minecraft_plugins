package org.setup.minecraft.instance;

import org.bukkit.entity.Player;
import org.setup.minecraft.Cosmetics;

public abstract class Cosmetic {

    protected Cosmetics cosmetics;
    protected Player player;

    public Cosmetic(Cosmetics cosmetics, Player player) {
        this.cosmetics = cosmetics;
        this.player = player;
    }

    public abstract void enable();

    public abstract void disable();

}
