package com.mentoria.integraInventories.usecases;

import com.mentoria.integraInventories.domains.Inventory;
import com.mentoria.integraInventories.exceptions.AlreadyRegisteredException;
import com.mentoria.integraInventories.exceptions.NotFoundException;
import com.mentoria.integraInventories.gateways.outputs.InventoryDataGateway;
import com.mentoria.integraInventories.gateways.outputs.SellersDataGateway;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AddInventory {

  @Autowired
  private InventoryDataGateway inventoryDataGateway;

  @Autowired
  private SellersDataGateway sellersDataGateway;

  public void execute(Inventory price) {
    boolean validation = new CheckSellerId(sellersDataGateway).validation(price.getSellerId());

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
