package com.swarp.xeonally.handlers.managers.warps;

import com.swarp.xeonally.handlers.managers.ItemManager;
import com.swarp.xeonally.handlers.managers.UIManager;
import com.swarp.xeonally.handlers.managers.configs.Config;
import com.swarp.xeonally.handlers.utils.TextUtil;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class WarpUI {

    public WarpUI(Player player) {
        Inventory inv = new UIManager(player).inventory(TextUtil.getColor("&8워프 목록"), 54);

        int i = 0;
        if (!new Config("warp.yml").find("warp-settings")) {
            player.openInventory(inv);
            return;
        }
        for (String name : new Config("warp.yml").getArrays("warp-settings")) {
            if (i > 53) continue;
            inv.setItem(i, new ItemManager(new ItemStack(Material.CHEST, 1)).name("&b[워프] &e" + name.replace("_", " ")).lore(TextUtil.getColor("&7이동하려면 &6&l클릭&7하세요!")).build());
            i++;
        }

        player.openInventory(inv);
    }

}
