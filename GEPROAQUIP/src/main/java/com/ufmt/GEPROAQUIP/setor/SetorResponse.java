package com.ufmt.GEPROAQUIP.setor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetorResponse {
  private String nome;
  private String descricao;

  public static SetorResponse from(Setor entidade){
    SetorResponse response = new SetorResponse();
    response.setNome(entidade.getNome());
    response.setDescricao(entidade.getDescricao());
    return response;
  }
}

