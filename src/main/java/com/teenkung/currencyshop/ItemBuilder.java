package com.teenkung.currencyshop;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class ItemBuilder {

    private Material material;
    private Integer amount;
    private String displayName;
    private ArrayList<String> lore;
    private Integer modelData;
    private Boolean glowing;
    private ItemStack item;

    public ItemBuilder(Material material, Integer amount) {
        this.material = material;
        this.amount = amount;
        this.displayName = "";
        this.lore = new ArrayList<>();
        this.modelData = 0;
        this.glowing = false;
        this.item = new ItemStack(material);
        this.item.setAmount(amount);
    }

    public ItemBuilder(ItemStack stack) {
        this.item = stack;
        this.material = stack.getType();
        this.amount = stack.getAmount();
        ItemMeta meta = stack.getItemMeta();
        if (meta != null) {
            this.displayName = meta.getDisplayName();
            if (meta.hasLore()) {
                this.lore = new ArrayList<>(meta.getLore());
            }
        }
    }

    public void applyProperties() {
        this.item = new ItemStack(material);
        item.setAmount(amount);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(displayName);
            meta.setLore(lore);
            if (meta.hasCustomModelData()) {
                meta.setCustomModelData(modelData);
            }
            if (glowing) {
                meta.addEnchant(Enchantment.DURABILITY, 1, true);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            }
            item.setItemMeta(meta);
        }

    }
    public void setMaterial(Material material) {
        this.material = material;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public void setLore(ArrayList<String> lore) {
        this.lore = lore;
    }
    public void setModelData(Integer modelData) {
        this.modelData = modelData;
    }
    public void setGlow(Boolean glowing) {
        this.glowing = glowing;
    }

}
