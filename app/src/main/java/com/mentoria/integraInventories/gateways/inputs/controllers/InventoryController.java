package com.mentoria.integraInventories.gateways.inputs.controllers;

import com.mentoria.integraInventories.domains.Inventory;
import com.mentoria.integraInventories.gateways.inputs.jsons.InventoryRequest;
import com.mentoria.integraInventories.usecases.AddInventory;
import com.mentoria.integraInventories.usecases.GetInventory;
import com.mentoria.integraInventories.usecases.UpdateInventory;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/products/{sku}/inventories")
public class InventoryController {

  @Autowired
  private AddInventory addInventory;
  @Autowired
  private GetInventory getInventory;
  @Autowired
  private UpdateInventory updateInventory;

  @PostMapping
  @ApiOperation("Cadastra o estoque de um determinado produto.")
  public void AddInventory(@PathVariable String sku, @RequestHeader String sellerId,
      @RequestBody InventoryRequest inventoryRequest) {

    addInventory.execute(inventoryRequest.toDomain(sku, sellerId));

  }

  @GetMapping
  @ApiOperation("Pesquisa e retorna o estoque do produto pelo sku e sellerId.")
  public Optional<Inventory> getInventory(@PathVariable String sku, @RequestHeader String sellerId) {

    return getInventory.execute(sku, sellerId);

  }

  @PutMapping
  @ApiOperation("Atualiza o estoque dos produtos.")
  public void UpdateInventoryBySku(@PathVariable String sku, @RequestHeader String sellerId,
      @RequestBody InventoryRequest inventoryRequest) {

    updateInventory.execute(inventoryRequest.toDomain(sku, sellerId));

  }
}
