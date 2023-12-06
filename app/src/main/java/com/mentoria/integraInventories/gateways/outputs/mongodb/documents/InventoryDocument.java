package com.mentoria.integraInventories.gateways.outputs.mongodb.documents;

import com.mentoria.integraInventories.domains.Inventory;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document("inventories")
public class InventoryDocument {

    @Id
    private String sku;
    @Indexed
    private String sellerId;
    private Integer inventory;

    public InventoryDocument(Inventory inventory){

        this.sku = inventory.getSku();
        this.sellerId = inventory.getSellerId();
        this.inventory = inventory.getInventory();

    }

    public Inventory toDomain(){

        Inventory inventoryToDomain = new Inventory();
        inventoryToDomain.setSku(this.sku);
        inventoryToDomain.setSellerId(this.sellerId);
        inventoryToDomain.setInventory(this.inventory);

        return inventoryToDomain;

    }
}
