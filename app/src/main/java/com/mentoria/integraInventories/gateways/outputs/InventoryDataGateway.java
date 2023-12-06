package com.mentoria.integraInventories.gateways.outputs;

import com.mentoria.integraInventories.domains.Inventory;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public interface InventoryDataGateway {

    void save(Inventory inventory);

    Optional<Inventory> findBySkuAndSellerId(String sku, String sellerID);

}
