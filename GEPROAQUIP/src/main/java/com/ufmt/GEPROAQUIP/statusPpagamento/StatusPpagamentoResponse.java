package com.ufmt.GEPROAQUIP.statusPpagamento;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusPpagamentoResponse {
  private Date data;
  private String ocorrencia;

  public static StatusPpagamentoResponse from(StatusPpagamento entidade){
    StatusPpagamentoResponse response = new StatusPpagamentoResponse();
    response.setData(entidade.getData());
    response.setOcorrencia(entidade.getOcorrencia());
    return response;
  }
}
