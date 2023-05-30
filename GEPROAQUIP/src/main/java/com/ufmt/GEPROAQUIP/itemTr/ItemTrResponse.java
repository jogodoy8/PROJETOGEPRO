package com.ufmt.GEPROAQUIP.itemTr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemTrResponse {
  private int quantidade;
  private String descricao;
  private double valor;

  public static ItemTrResponse from(ItemTr entidade){
    ItemTrResponse response = new ItemTrResponse();
    response.setQuantidade(entidade.getQuantidade());
    response.setDescricao(entidade.getDescricao());
    response.setValor(entidade.getValor());
    return response;
  }
}

