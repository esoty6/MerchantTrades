package com.github.esoty6.merchanttrades.merchants;

import java.util.ArrayList;
import org.bukkit.Material;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.MerchantRecipe;
import com.github.esoty6.merchanttrades.merchants.recipes.Recipes;

public class Cleric extends CustomMerchant {

  public Cleric(Villager villager) {
    this.villager = villager;
    this.recipesList = new ArrayList<>(villager.getRecipes());
  }

  private void replaceRottenFleshWithGunpowder(MerchantRecipe recipe) {
    if (villager.getVillagerLevel() > 1) {
      return;
    }

    MerchantRecipe newRecipe =
        replaceRecipe(Material.ROTTEN_FLESH, Recipes.GunpowderRecipe(), recipe);

    for (int i = 0; i < recipesList.size(); i++) {
      if (recipesList.get(i).equals(recipe) && !recipe.equals(newRecipe)) {
        recipesList.set(i, newRecipe);
        break;
      }
    }

    updateRecipes();
  }

  @Override
  public void createCustomRecipe(MerchantRecipe recipe) {
    addRecipe(recipe);
    replaceRottenFleshWithGunpowder(recipe);
  }

}
