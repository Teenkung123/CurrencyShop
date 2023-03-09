package com.teenkung.currencyshop;

import com.teenkung.currencyshop.utils.GUIManager;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.HashMap;

import static com.teenkung.currencyshop.CurrencyShop.colorize;

public class ConfigLoader {

    private static HashMap<String, GUIManager> managerMap = new HashMap<>();
    public static void loadConfig() {
        CurrencyShop instance = CurrencyShop.getInstance();
        FileConfiguration config = instance.getConfig();
        config.options().copyDefaults(true);
        instance.saveDefaultConfig();

        ConfigurationSection section = config.getConfigurationSection("Shops");
        if (section != null) {
            for (String filename : section.getKeys(false)) {
                File file = new File(instance.getDataFolder(), "Shops/"+filename);
                if (file.exists()) {
                    YamlConfiguration fileConfig = YamlConfiguration.loadConfiguration(file);
                    if (fileConfig.getString("ID") == null) {
                        System.out.println(colorize(config.getString("Language.Skip-Invalid-ID", "&eSkipping Shop File <file> Due to it's Invalid ID").replaceAll("<file>", filename)));
                        continue;
                    } else if (!fileConfig.getBoolean("Enabled")) {
                        System.out.println(colorize(config.getString("Language.Skip-Disabled", "&eSkipping Shop File <file> Due to it's Disabled").replaceAll("<file>", filename)));
                        continue;
                    }
                    managerMap.put(fileConfig.getString("ID"), new GUIManager(fileConfig));
                } else {

                }
            }
        } else {
            System.out.println(colorize(config.getString("Language.Invalid-Config", "&cInvalid Config File! Disabling Plugin!")));
            Bukkit.getPluginManager().disablePlugin(instance);
        }
    }

}
