package org.setup.minecraft.navigation;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.setup.minecraft.Cosmetics;
import org.setup.minecraft.instance.Cosmetic;
import org.setup.minecraft.instance.hats.Hat;
import org.setup.minecraft.instance.hats.HatType;
import org.setup.minecraft.instance.hats.HatsUI;
import org.setup.minecraft.instance.trails.Trail;
import org.setup.minecraft.instance.trails.TrailType;
import org.setup.minecraft.instance.trails.TrailsUI;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CosmeticListener implements Listener {

    private Cosmetics cosmetics;

    public CosmeticListener(Cosmetics cosmetics) {
        this.cosmetics = cosmetics;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {

        Player player = (Player) e.getWhoClicked();

        if(e.getInventory() != null && e.getCurrentItem() != null) {
            if(e.getView().getTitle().endsWith("Cosmetics Menu!")) {
                if(e.getRawSlot() == 0) {
                    new HatsUI(cosmetics, player);
                } else if(e.getRawSlot() == 1) {
                    new TrailsUI(cosmetics, player);
                }
            } else if(e.getView().getTitle().endsWith("Trails")) {
                TrailType type = TrailType.valueOf(e.getCurrentItem().getItemMeta().getLocalizedName());

                List<Cosmetic> active;
                if(cosmetics.getActiveCosmetics().containsKey(player.getUniqueId())) {
                    active = cosmetics.getActiveCosmetics().get(player.getUniqueId());
                    Iterator<Cosmetic> itr = active.listIterator();

                    while(itr.hasNext()) {
                        Cosmetic cosmetic = itr.next();
                        if(cosmetic instanceof Trail) {
                            cosmetic.disable();
                            itr.remove();

                            if (((Trail) cosmetic).getType() == type) {
                                player.sendMessage(ChatColor.RED + "You disabled " + type.getDisplay() + "!");
                                player.closeInventory();
                                return;
                            }
                        }
                    }
                } else {
                    active = new ArrayList<>();
                }

                Trail trail = new Trail(cosmetics, player, type);
                trail.enable();
                active.add(trail);
                cosmetics.getActiveCosmetics().put(player.getUniqueId(), active);

                player.sendMessage(ChatColor.GREEN.toString() + ChatColor.BOLD + "You enabled " + type.getDisplay() + " trail!");
                player.closeInventory();


            }else if(e.getView().getTitle().endsWith("Hats")) {
                HatType type = HatType.valueOf(e.getCurrentItem().getItemMeta().getLocalizedName());
                List<Cosmetic> active;
                if(cosmetics.getActiveCosmetics().containsKey(player.getUniqueId())) {
                    active = cosmetics.getActiveCosmetics().get(player.getUniqueId());
                    Iterator<Cosmetic> itr = active.listIterator();

                    while(itr.hasNext()) {
                        Cosmetic cosmetic = itr.next();
                        if(cosmetic instanceof Hat) {
                            cosmetic.disable();
                            itr.remove();

                            if (((Hat) cosmetic).getType() == type) {
                                player.sendMessage(ChatColor.RED + "You disabled " + type.getDisplay() + "!");
                                player.closeInventory();
                                return;
                            }
                        }
                    }
                } else {
                    active = new ArrayList<>();
                }

                Hat hat = new Hat(cosmetics, player, type);
                hat.enable();
                active.add(hat);
                cosmetics.getActiveCosmetics().put(player.getUniqueId(), active);

                player.sendMessage(ChatColor.GREEN.toString() + ChatColor.BOLD + "You enabled " + type.getDisplay() + " hat!");
                player.closeInventory();

            }
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {

        Player player = e.getPlayer();

        if(cosmetics.getActiveCosmetics().containsKey(player.getUniqueId())) {
            for(Cosmetic cosmetic : cosmetics.getActiveCosmetics().get(player.getUniqueId())) {
                cosmetic.disable();
            }
            cosmetics.getActiveCosmetics().remove(player.getUniqueId());
        }
    }

}
