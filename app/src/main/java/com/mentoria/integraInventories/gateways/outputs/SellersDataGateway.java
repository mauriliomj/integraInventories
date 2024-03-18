package com.mentoria.integraInventories.gateways.outputs;

import com.mentoria.integraInventories.domains.Seller;
import org.springframework.stereotype.Component;

@Component
public interface SellersDataGateway {
  boolean exists(String sellerId);

  void save(Seller seller);
}
