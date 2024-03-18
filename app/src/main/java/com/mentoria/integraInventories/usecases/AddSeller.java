package com.mentoria.integraInventories.usecases;

import com.mentoria.integraInventories.domains.Seller;
import com.mentoria.integraInventories.exceptions.AlreadyRegisteredException;
import com.mentoria.integraInventories.gateways.outputs.mongodb.SellersDataGatewayMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AddSeller {
  @Autowired
  @Qualifier("sellersDataGatewayMongoImpl")
  private SellersDataGatewayMongoImpl sellersDataGatewayMongoImpl;

  public void execute(Seller seller){
    if(sellersDataGatewayMongoImpl.exists(seller.getSellerId())){
      throw new AlreadyRegisteredException("Seller já registrado!");
    }
    sellersDataGatewayMongoImpl.save(seller);
  }
}
