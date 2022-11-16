package com.swarp.xeonally.handlers.events.impl;

import com.swarp.xeonally.handlers.managers.configs.Config;
import com.swarp.xeonally.handlers.managers.warps.Warp;
import com.swarp.xeonally.handlers.utils.TextUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class EventInventory implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (player.getOpenInventory().getTitle().contains("워프 목록")) {
            for (String name : new Config("warp.yml").getArrays("warp-settings")) {
                if (event.getCurrentItem() != null && event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b[워프] §e" + name.replace("_", " "))) {
                    player.teleport(new Warp().getLocation(name));
                    player.sendMessage(TextUtil.getColor("&8▶ &b" + name.replace("_", " ") + "&e으로 이동하셨습니다!"));
                }
            }
        }
    }

}
