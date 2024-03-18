package com.mentoria.integraInventories.usecases;

import com.mentoria.integraInventories.domains.Inventory;
import com.mentoria.integraInventories.exceptions.AlreadyRegisteredException;
import com.mentoria.integraInventories.exceptions.NotFoundException;
import com.mentoria.integraInventories.gateways.outputs.CheckSellerId;
import com.mentoria.integraInventories.gateways.outputs.InventoryDataGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddInventory {

  @Autowired
  private InventoryDataGateway inventoryDataGateway;

  @Autowired
  private CheckSellerId checkSellerId;

  public void execute(Inventory price) {
    boolean validation = checkSellerId.validate(price.getSellerId());

    if(validation){
      if (inventoryDataGateway.findBySkuAndSellerId(price.getSku(), price.getSellerId())
          .isPresent()){
        throw new AlreadyRegisteredException("Preço já cadastrado para o sellerId/sku");
      }
      inventoryDataGateway.save(price);
    } else {
      throw new NotFoundException("SellerId não encontrado!");
    }
  }
}
