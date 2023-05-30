package com.ufmt.GEPROAQUIP.unidade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnidadeResponse {
  private int id;

  public static UnidadeResponse from(Unidade entidade){
    UnidadeResponse response = new UnidadeResponse();
    response.setId(entidade.getId());
    return response;
  }
}