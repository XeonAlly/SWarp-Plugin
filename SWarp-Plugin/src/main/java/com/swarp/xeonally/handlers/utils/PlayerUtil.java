package com.swarp.xeonally.handlers.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Random;

public class PlayerUtil {

    public static Player getRandomPlayer(List<Player> givenList) {
        Random rand = new Random();
        Player randomElement = givenList.get(rand.nextInt(givenList.size()));
        return randomElement;
    }

    public static void clearInventories(Player player) {
        player.getInventory().setHelmet(new ItemStack(Material.AIR));
        player.getInventory().setChestplate(new ItemStack(Material.AIR));
        player.getInventory().setLeggings(new ItemStack(Material.AIR));
        player.getInventory().setBoots(new ItemStack(Material.AIR));
        player.getInventory().clear();
    }

}
