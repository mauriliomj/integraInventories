package com.mentoria.integraInventories.usecases;

import com.mentoria.integraInventories.domains.Inventory;
import com.mentoria.integraInventories.exceptions.NotFoundException;
import com.mentoria.integraInventories.gateways.outputs.InventoryDataGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
@AllArgsConstructor
public class GetInventory {

  private InventoryDataGateway inventoryDataGateway;

  public Optional<Inventory> execute(String sku, String sellerId) {

    if (inventoryDataGateway.findBySkuAndSellerId(sku, sellerId).isEmpty()) {

      throw new NotFoundException("Sku/sellerId não encontrado!");

    }

    return inventoryDataGateway.findBySkuAndSellerId(sku, sellerId);

  }
}
