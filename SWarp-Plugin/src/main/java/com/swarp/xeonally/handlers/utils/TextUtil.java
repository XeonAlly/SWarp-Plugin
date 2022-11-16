package com.swarp.xeonally.handlers.utils;

import org.bukkit.ChatColor;

import java.util.List;
import java.util.Random;

public class TextUtil {

    public static String getColor(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static String getRandomPlayer(List<String> givenList) {
        Random rand = new Random();
        String randomElement = givenList.get(rand.nextInt(givenList.size()));
        return randomElement;
    }

}
