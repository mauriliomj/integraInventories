package com.mentoria.integraInventories.gateways.inputs.jsons;

import com.mentoria.integraInventories.domains.Inventory;
import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class InventoryRequest {

  @NotNull(message = "{not.null}")
  private Integer inventory;


  public Inventory toDomain(String sku, String sellerId) {

    Inventory inventoryToDomain = new Inventory();

    inventoryToDomain.setInventory(inventory);
    inventoryToDomain.setSku(sku);
    inventoryToDomain.setSellerId(sellerId);

    return inventoryToDomain;

  }
}
