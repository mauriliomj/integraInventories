package com.mentoria.integraInventories.usecases;

import com.mentoria.integraInventories.domains.Inventory;
import com.mentoria.integraInventories.exceptions.NotFoundException;
import com.mentoria.integraInventories.gateways.outputs.InventoryDataGateway;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdateInventory {
  @Autowired
  private InventoryDataGateway inventoryDataGateway;

  public void execute(Inventory updateInventory) {
    if (inventoryDataGateway.findBySkuAndSellerId(updateInventory.getSku(), updateInventory
            .getSellerId())
        .isEmpty()) {
      throw new NotFoundException("sku/sellerId não encontrado!");
    }
    inventoryDataGateway.save(updateInventory);
  }
}
