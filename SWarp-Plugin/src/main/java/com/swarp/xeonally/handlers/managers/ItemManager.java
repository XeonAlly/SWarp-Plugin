package com.swarp.xeonally.handlers.managers;

import com.swarp.xeonally.handlers.utils.TextUtil;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.material.MaterialData;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    private final ItemStack is;

    public ItemManager(final Material mat) {
        is = new ItemStack(mat);
    }

    public ItemManager(final ItemStack is) {
        this.is = is;
    }


    public ItemManager amount(final int amount) {
        is.setAmount(amount);
        return this;
    }


    public ItemManager name(final String name) {
        final ItemMeta meta = is.getItemMeta();
        meta.setDisplayName(TextUtil.getColor(name));
        is.setItemMeta(meta);
        return this;
    }


    public ItemManager lore(final String name) {
        final ItemMeta meta = is.getItemMeta();
        List<String> lore = meta.getLore();
        if (lore == null) {
            lore = new ArrayList<String>();
        }
        lore.add(name);
        meta.setLore(lore);
        is.setItemMeta(meta);
        return this;
    }

    public ItemManager loreColor(final String name) {
        final ItemMeta meta = is.getItemMeta();
        List<String> lore = meta.getLore();
        if (lore == null) {
            lore = new ArrayList<String>();
        }
        lore.add(TextUtil.getColor(name));
        meta.setLore(lore);
        is.setItemMeta(meta);
        return this;
    }

    public ItemManager lore(final ArrayList<String> lore) {
        final ItemMeta meta = is.getItemMeta();
        meta.setLore(lore);
        is.setItemMeta(meta);
        return this;
    }


    public ItemManager durability(final int durability) {
        is.setDurability((short) durability);
        return this;
    }


    @SuppressWarnings("deprecation")
    public ItemManager data(final int data) {
        is.setData(new MaterialData(is.getType(), (byte) data));
        return this;
    }


    public ItemManager enchantment(final Enchantment enchantment, final int level) {
        is.addUnsafeEnchantment(enchantment, level);
        return this;
    }


    public ItemManager enchantment(final Enchantment enchantment) {
        is.addUnsafeEnchantment(enchantment, 1);
        return this;
    }


    public ItemManager type(final Material material) {
        is.setType(material);
        return this;
    }


    public ItemManager clearLore() {
        final ItemMeta meta = is.getItemMeta();
        meta.setLore(new ArrayList<String>());
        is.setItemMeta(meta);
        return this;
    }


    public ItemManager clearEnchantments() {
        for (final Enchantment e : is.getEnchantments().keySet()) {
            is.removeEnchantment(e);
        }
        return this;
    }

    public ItemManager color(Color color) {
        if (is.getType() == Material.LEATHER_BOOTS || is.getType() == Material.LEATHER_CHESTPLATE || is.getType() == Material.LEATHER_HELMET
                || is.getType() == Material.LEATHER_LEGGINGS) {
            LeatherArmorMeta meta = (LeatherArmorMeta) is.getItemMeta();
            meta.setColor(color);
            is.setItemMeta(meta);
            return this;
        } else {
            throw new IllegalArgumentException("color() only applicable for leather armor!");
        }
    }

    public ItemManager unbreakable(boolean unbreak){
        ItemMeta meta = is.getItemMeta();
        meta.setUnbreakable(true);
        is.setItemMeta(meta);
        return this;
    }

    public ItemManager enchantable(boolean hidden) {
        ItemMeta meta = is.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        is.setItemMeta(meta);
        return this;
    }

    public ItemManager attributable(boolean attributable) {
        ItemMeta meta = is.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        is.setItemMeta(meta);
        return this;
    }

    public ItemManager owner(String name) {
        SkullMeta meta = (SkullMeta) is.getItemMeta();
        meta.setOwner(name);
        is.setItemMeta(meta);
        return this;
    }

    public ItemStack build() {
        return is;
    }

}
