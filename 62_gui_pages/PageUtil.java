package org.setup.minecraft;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class PageUtil {

    // [XXXXX] [XXXXX] [XXXXX] [XXXXX]XXXXXXXXXXXXXXXXXXXXX

    public static List<ItemStack> getPageItems(List<ItemStack> items, int page, int spaces) {
        int upperBound = page * spaces;
        int lowerBound = upperBound - spaces;

        List<ItemStack> newItems = new ArrayList<>();

        for(int i = lowerBound; i < upperBound; i++) {
            try {
                newItems.add(items.get(i));
            }catch(IndexOutOfBoundsException x) {
                break;
            }
            return newItems;
        }

        return newItems;
    }

    // [XXXXX] [XXXXX] [XXXXX] [XXXXX] [XXXXX] [XXXXX] [XXXXX] [XXXXX]

    public static boolean isPageValid(List<ItemStack> items, int page, int spaces) {

        if(page <= 0) { return false;}

        int upperBound = page * spaces;
        int lowerBound = upperBound - spaces;

        return items.size() > lowerBound;

    }
}
