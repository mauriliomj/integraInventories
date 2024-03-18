package com.mentoria.integraInventories.domains;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Contact {

  private String type;
  private String value;

}
