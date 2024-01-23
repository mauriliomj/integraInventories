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

@ExtendWith(MockitoExtension.class)
class GetInventoryTest {

  @InjectMocks
  private GetInventory getInventory;
  @Mock
  private InventoryDataGateway inventoryDataGateway;

  @Test
  public void shouldShowAPrice() {

    Mockito.when(inventoryDataGateway.findBySkuAndSellerId(mockInventory().getSku(),
        mockInventory().getSellerId())).thenReturn(Optional.of(mockInventory()));

    Optional<Inventory> resultPrice = getInventory
        .execute(mockInventory().getSku(), mockInventory().getSellerId());

    Assertions.assertEquals(resultPrice.get().getSku(), mockInventory().getSku());
    Assertions.assertEquals(resultPrice.get().getSellerId(), mockInventory().getSellerId());
    Assertions.assertEquals(resultPrice.get().getInventory(), mockInventory().getInventory());

  }

  @Test
  public void shouldThrowAnException() {

    Mockito.when(inventoryDataGateway
            .findBySkuAndSellerId(mockInventory().getSku(), mockInventory().getSellerId()))
        .thenReturn(Optional.empty());

    Assertions.assertThrows(NotFoundException.class, () -> getInventory
        .execute(mockInventory().getSku(), mockInventory().getSellerId()));

    Mockito.verify(inventoryDataGateway).findBySkuAndSellerId(mockInventory().getSku(),
        mockInventory().getSellerId());

  }

  public Inventory mockInventory() {

    Inventory mockInventory = new Inventory();
    mockInventory.setSku("SkuTest");
    mockInventory.setSellerId("IdTest");
    mockInventory.setInventory(10);
    return mockInventory;

  }
}