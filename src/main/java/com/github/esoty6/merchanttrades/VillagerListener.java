package com.github.esoty6.merchanttrades;

import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.VillagerAcquireTradeEvent;

public class VillagerListener implements Listener {

  private final MerchantsManager merchantsManager;

  public VillagerListener() {
    merchantsManager = new MerchantsManager();
  };

  @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
  private void onAcquireTradeEvent(VillagerAcquireTradeEvent event) {
    if (event.getEntity() instanceof Villager villager) {
      merchantsManager.createMerchant(villager, event);
    }
  }
}
