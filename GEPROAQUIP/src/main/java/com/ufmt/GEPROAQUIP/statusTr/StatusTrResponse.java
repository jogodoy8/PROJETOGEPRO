package com.ufmt.GEPROAQUIP.statusTr;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusTrResponse {

  private Date data;
  private String andamento;

  public static StatusTrResponse from(StatusTr entidade){
    StatusTrResponse response = new StatusTrResponse();
    response.setData(entidade.getData());
    response.setAndamento(entidade.getAndamento());
    return response;
  }
}