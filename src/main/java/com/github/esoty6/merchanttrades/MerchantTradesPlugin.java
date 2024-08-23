package com.github.esoty6.merchanttrades;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class MerchantTradesPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("MerchantTrades enabled!");
        getServer().getPluginManager().registerEvents(new VillagerListener(), this);
    }

}
