package com.mentoria.integraInventories.gateways.outputs.mongodb;

import com.mentoria.integraInventories.domains.Inventory;
import com.mentoria.integraInventories.gateways.outputs.InventoryDataGateway;
import com.mentoria.integraInventories.gateways.outputs.mongodb.repositories.InventoryRepository;
import com.mentoria.integraInventories.gateways.outputs.mongodb.documents.InventoryDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class InventoryDataGatewayMongoImpl implements InventoryDataGateway {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public void save(Inventory inventory) {

        inventoryRepository.save(new InventoryDocument(inventory));

    }

    @Override
    public Optional<Inventory> findBySkuAndSellerId(String sku, String sellerId) {

        return inventoryRepository.findBySkuAndSellerId(sku, sellerId)
                .map(InventoryDocument::toDomain);

    }
}
