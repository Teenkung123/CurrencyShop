package com.teenkung.currencyshop;

import com.iridium.iridiumcolorapi.IridiumColorAPI;
import org.bukkit.plugin.java.JavaPlugin;

public final class CurrencyShop extends JavaPlugin {

    private static CurrencyShop instance;
    @Override
    public void onEnable() {
        instance = this;

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static CurrencyShop getInstance() { return instance; }
    public static String colorize(String str) { return IridiumColorAPI.process(str); }
}
