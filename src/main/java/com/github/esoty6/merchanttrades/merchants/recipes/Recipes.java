package com.github.esoty6.merchanttrades.merchants.recipes;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

public class Recipes {

  public static MerchantRecipe GunpowderRecipe() {
    ItemStack emerald = new ItemStack(Material.EMERALD, 1);
    ItemStack gunpowder = new ItemStack(Material.GUNPOWDER, 32);

    MerchantRecipe newRecipe = new MerchantRecipe(emerald, 0, 16, true, 1, 0.05f);
    newRecipe.addIngredient(gunpowder);

    return newRecipe;
  }

}
