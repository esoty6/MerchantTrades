package com.github.esoty6.merchanttrades;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Villager.Profession;
import org.bukkit.event.entity.VillagerAcquireTradeEvent;
import com.github.esoty6.merchanttrades.merchants.Cleric;
import com.github.esoty6.merchanttrades.merchants.CustomMerchant;

public class MerchantsManager {
  private Map<Villager, CustomMerchant> merchantsMap = new HashMap<>();

  public void createMerchant(Villager villager, VillagerAcquireTradeEvent event) {
    Profession villagerProfession = villager.getProfession();

    if (villagerProfession.equals(Profession.CLERIC)) {
      merchantsMap.putIfAbsent(villager, new Cleric(villager));
      merchantsMap.get(villager).createCustomRecipe(event.getRecipe());

      event.setCancelled(true);
    }
  }

  public void removeMerchant(Villager villager) {
    merchantsMap.remove(villager);
  }
}
