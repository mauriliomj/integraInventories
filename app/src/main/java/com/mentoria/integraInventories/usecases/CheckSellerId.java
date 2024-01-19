package com.mentoria.integraInventories.usecases;

import com.mentoria.integraInventories.gateways.outputs.SellersDataGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckSellerId {
  @Autowired
  private final SellersDataGateway sellersDataGateway;

  @Autowired
  public CheckSellerId(SellersDataGateway sellersDataGateway) {
    this.sellersDataGateway = sellersDataGateway;
  }

  public Boolean validation(String sellerId) {
    return sellersDataGateway.exists(sellerId);
  }
}
