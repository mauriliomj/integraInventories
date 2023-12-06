package com.mentoria.integraInventories.usecases;

import com.mentoria.integraInventories.domains.Inventory;
import com.mentoria.integraInventories.exceptions.NotFoundException;
import com.mentoria.integraInventories.gateways.outputs.InventoryDataGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class UpdateInventoryTest {

  @InjectMocks
  private UpdateInventory updateInventory;

  @Mock
  private InventoryDataGateway inventoryDataGateway;

  @Test
  public void shouldChangeAInventoryBySkuAndSellerId() {

    Mockito.when(
            inventoryDataGateway.findBySkuAndSellerId(mockInventory().getSku(), mockInventory()
                .getSellerId()))
        .thenReturn(Optional.of(mockInventory()));

    updateInventory.execute(mockInventory());

    Mockito.verify(inventoryDataGateway).save(any());

  }

  @Test
  public void shouldThrowExceptionForNotFindingId() {

    Mockito.when(inventoryDataGateway.findBySkuAndSellerId(any(), any()))
        .thenThrow(new NotFoundException("Id não encontrado."));

    Assertions.assertThrows(NotFoundException.class, () -> updateInventory
        .execute(mockInventoryUpdated()));

  }

  public Inventory mockInventory() {

    Inventory mockPrice = new Inventory();
    mockPrice.setSku("SkuTest");
    mockPrice.setSellerId("IdTest");
    mockPrice.setInventory(20);
    return mockPrice;

  }

  public Inventory mockInventoryUpdated() {

    Inventory mockInvnetoryUpdated = new Inventory();
    mockInvnetoryUpdated.setInventory(10);
    return mockInvnetoryUpdated;

  }
}