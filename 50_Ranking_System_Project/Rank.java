package org.setup.minecraft;

import org.bukkit.ChatColor;

public enum Rank {


    OWNER(ChatColor.DARK_RED + "Owner", new String[]{"worldedit.help"}),
    ADMIN(ChatColor.RED + "Admin", new String[]{"worldedit.help"}),
    MEMBER(ChatColor.YELLOW + "Member", new String[]{}),
    GUEST(ChatColor.GRAY + "Guest", new String[]{});

    private String display;
    private String[] permissions;

    Rank(String display, String[] permissions) {
        this.display = display;
        this.permissions = permissions;
    }

    public String getDisplay() {
        return display;
    }

    public String[] getPermissions() {
        return permissions;
    }
}
