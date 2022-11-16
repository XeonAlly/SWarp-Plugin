package com.swarp.xeonally.handlers.managers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class UIManager {

    private Player player;

    private Inventory inventory;
    private ItemStack is;

    public UIManager(Player player) {
        this.player = player;
    }

    public Inventory inventory(String title, int slot) {
        return Bukkit.createInventory(null, slot, title);
    }

}
