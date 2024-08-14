package com.github.esoty6.merchanttrades;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.Material;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Villager.Profession;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.VillagerAcquireTradeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class MerchantTradesPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("MerchantTradesPlugin enabled!");

        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
    private final void onAcquireTradeEvent(VillagerAcquireTradeEvent event) {
        if (event.getEntity() instanceof Villager villager) {
            Profession vProfession = villager.getProfession();

            if (vProfession == Profession.CLERIC) {
                setUpClericTrades(villager);
            }
        }
    }

    private final void setUpClericTrades(Villager villager) {
        if (villager.getVillagerLevel() > 1) {
            return;
        }

        ItemStack emerald = new ItemStack(Material.EMERALD, 1);
        ItemStack gunpowder = new ItemStack(Material.GUNPOWDER, 32);

        MerchantRecipe newTrade = new MerchantRecipe(emerald, 0, 16, true, 1, 0.05f);
        newTrade.addIngredient(gunpowder);

        List<MerchantRecipe> list = new ArrayList<>();

        for (MerchantRecipe merchantRecipe : villager.getRecipes()) {

            if (merchantRecipe.getIngredients().get(0).getType() == Material.ROTTEN_FLESH && canReplaceTrade()) {
                list.add(newTrade);
                continue;
            }

            list.add(merchantRecipe);
        }

        villager.setRecipes(list);
    }

    private final Boolean canReplaceTrade() {
        return ThreadLocalRandom.current().nextDouble() > 0.5d;
    }

}