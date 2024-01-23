package com.mentoria.integraInventories.usecases;

import com.mentoria.integraInventories.domains.Inventory;
import com.mentoria.integraInventories.exceptions.AlreadyRegisteredException;
import com.mentoria.integraInventories.gateways.outputs.InventoryDataGateway;
import com.mentoria.integraInventories.gateways.outputs.SellersDataGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class AddInventoryTest {
  @InjectMocks
  private AddInventory addInventory;

  @Mock
  private InventoryDataGateway inventoryDataGateway;

  @Mock
  private SellersDataGateway sellersDataGateway;

  @Test
  public void shouldSaveAPrice() {

    Inventory inventoryTest = mockInventory();

    Mockito.when(sellersDataGateway.exists(inventoryTest.getSellerId())).thenReturn(true);

    Mockito.when(inventoryDataGateway
            .findBySkuAndSellerId(inventoryTest.getSku(), inventoryTest.getSellerId()))
        .thenReturn(Optional.empty());

    addInventory.execute(mockInventory());

    Mockito.verify(inventoryDataGateway).save(mockInventory());

  }

  @Test
  public void shouldThrowAnExceptionBySellerId() {
    Inventory inventoryTest = mockInventory();

    Mockito.when(sellersDataGateway.exists(inventoryTest.getSellerId())).thenReturn(true);

    Mockito.when(inventoryDataGateway.findBySkuAndSellerId(inventoryTest.getSku(),
            inventoryTest.getSellerId()))
        .thenThrow(new AlreadyRegisteredException("O estoque já foi cadastrado!"));

    Assertions.assertThrows(AlreadyRegisteredException.class,
        () -> addInventory.execute(mockInventory()));

  }

  @Test
  public void shouldThrowAnExceptionBySku() {
    Inventory inventoryTest = mockInventory();

    Mockito.when(sellersDataGateway.exists(inventoryTest.getSellerId())).thenReturn(true);

    Mockito.when(inventoryDataGateway.findBySkuAndSellerId(inventoryTest.getSku(),
            inventoryTest.getSellerId()))
        .thenThrow(new AlreadyRegisteredException("O estoque já foi cadastrado!"));

    Assertions.assertThrows(AlreadyRegisteredException.class,
        () -> addInventory.execute(mockInventory()));

  }

  public Inventory mockInventory() {

    Inventory mockInventory = new Inventory();
    mockInventory.setSku("SkuTest");
    mockInventory.setSellerId("IdTest");
    mockInventory.setInventory(10);
    return mockInventory;

  }

}