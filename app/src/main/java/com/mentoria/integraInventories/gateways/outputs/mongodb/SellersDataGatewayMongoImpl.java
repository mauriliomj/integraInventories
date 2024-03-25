package com.mentoria.integraInventories.gateways.outputs.mongodb;

import com.mentoria.integraInventories.domains.Seller;
import com.mentoria.integraInventories.gateways.outputs.SellersDataGateway;
import com.mentoria.integraInventories.gateways.outputs.mongodb.documents.SellerDocument;
import com.mentoria.integraInventories.gateways.outputs.mongodb.repositories.SellersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Slf4j
@Primary
@Component
public class SellersDataGatewayMongoImpl implements SellersDataGateway {

  @Autowired
  private SellersRepository sellersRepository;

  @Override
  public boolean exists(String sellerId) {
    return sellersRepository.existsById(sellerId);
  }

  @Override
  public void save(Seller seller) {
    SellerDocument sellerDocument = new SellerDocument(seller);
    sellersRepository.save(sellerDocument);
  }
}
