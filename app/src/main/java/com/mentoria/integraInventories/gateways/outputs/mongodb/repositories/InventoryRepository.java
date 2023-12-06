package com.mentoria.integraInventories.gateways.outputs.mongodb.repositories;

import com.mentoria.integraInventories.gateways.outputs.mongodb.documents.InventoryDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface InventoryRepository extends MongoRepository<InventoryDocument, String> {

    public Optional<InventoryDocument> findBySkuAndSellerId(String sku, String sellerId);

}
