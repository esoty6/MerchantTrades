package com.github.esoty6.merchanttrades.merchants;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.bukkit.Material;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.MerchantRecipe;

public abstract class CustomMerchant {
  protected Villager villager;
  protected List<MerchantRecipe> recipesList;

  public abstract void createCustomRecipe(MerchantRecipe recipe);

  protected Boolean isFirstIngredientTheSameType(MerchantRecipe recipe, Material targetMaterial) {
    return recipe.getIngredients().get(0).getType().equals(targetMaterial);
  }

  protected MerchantRecipe replaceRecipe(Material ingredientToReplace, MerchantRecipe customRecipe,
      MerchantRecipe villagerRecipe) {

    if (!isFirstIngredientTheSameType(villagerRecipe, ingredientToReplace)) {
      return villagerRecipe;
    }

    if (!canReplaceRecipe()) {
      return villagerRecipe;
    }

    return customRecipe;
  }

  protected void addRecipe(MerchantRecipe newRecipe) {
    recipesList.add(newRecipe);
    villager.setRecipes(recipesList);
  };

  protected void updateRecipes() {
    villager.setRecipes(recipesList);
  };

  private Boolean canReplaceRecipe() {
    return ThreadLocalRandom.current().nextDouble() > 0.5d;
  };
}
