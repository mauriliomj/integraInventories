package com.mentoria.integraInventories.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {

  private Integer inventory;
  private String sellerId;
  private String sku;

}
