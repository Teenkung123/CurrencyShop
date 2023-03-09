package com.teenkung.currencyshop.utils;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public class GUIManager {
    private String id;
    private String GUITitle;
    private ArrayList<String> GUIlayout;
    private HashMap<String, ItemStack> GUIItems;


    public GUIManager(YamlConfiguration fileConfig) throws InvalidConfigurationException {
        this.id = fileConfig.getString("ID");
        this.GUITitle = fileConfig.getString("GUI.Title", "");
        this.GUIlayout = new ArrayList<>(fileConfig.getStringList("GUI.Layout"));
        ConfigurationSection Itemsection = fileConfig.getConfigurationSection("GUI.Items");
        if (Itemsection == null) {
            throw new InvalidConfigurationException("GUI.Items Does not exist!");
        } else {
            for (String key : Itemsection.getKeys(false)) {

            }
        }

    }
}
