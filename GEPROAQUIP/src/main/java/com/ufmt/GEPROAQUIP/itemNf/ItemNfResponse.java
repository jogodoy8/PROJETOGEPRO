package com.ufmt.GEPROAQUIP.itemNf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemNfResponse {
  private int quantidade;
  private String tipo;
  private String descricao;
  
  public static ItemNfResponse from(ItemNf entidade){
    ItemNfResponse response = new ItemNfResponse();
    response.setQuantidade(entidade.getQuantidade());
    response.setTipo(entidade.getTipo());
    response.setDescricao(entidade.getDescricao());
    return response;
  }
}
