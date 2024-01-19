package com.mentoria.integraInventories.gateways.outputs;

import org.springframework.stereotype.Component;

@Component
public interface SellersDataGateway {
  boolean exists(String sellerId);
}
