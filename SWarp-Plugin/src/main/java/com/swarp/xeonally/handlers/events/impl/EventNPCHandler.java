package com.swarp.xeonally.handlers.events.impl;

import com.swarp.xeonally.handlers.managers.warps.WarpUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

public class EventNPCHandler implements Listener {

    @EventHandler
    public void onClick(PlayerInteractAtEntityEvent event) {
        Player player = event.getPlayer();

        if (event.getRightClicked() instanceof Player) {
            if (event.getRightClicked().getName().contains("워프 목록")) {
                new WarpUI(player);
            }
        }
    }

}
