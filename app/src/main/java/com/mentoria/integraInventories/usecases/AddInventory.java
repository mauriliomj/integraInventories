package com.mentoria.integraInventories.usecases;

import com.mentoria.integraInventories.domains.Inventory;
import com.mentoria.integraInventories.exceptions.AlreadyRegisteredException;
import com.mentoria.integraInventories.gateways.outputs.InventoryDataGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AddInventory {

  private InventoryDataGateway inventoryDataGateway;

  public void execute(Inventory price) {

    if (inventoryDataGateway.findBySkuAndSellerId(price.getSku(), price.getSellerId()).isPresent()) {

      throw new AlreadyRegisteredException("Preço já cadastrado para o sellerId/sku");

    }

    inventoryDataGateway.save(price);

  }
}
