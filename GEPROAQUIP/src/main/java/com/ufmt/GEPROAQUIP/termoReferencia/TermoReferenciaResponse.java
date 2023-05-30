package com.ufmt.GEPROAQUIP.termoReferencia;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TermoReferenciaResponse {
    private String numProcesso;
    private String tipoProcesso;
    private Date aberturaProcesso;
    private String numTR;
    private String objeto;

  public static TermoReferenciaResponse from(TermoReferencia entidade){
    TermoReferenciaResponse response = new TermoReferenciaResponse();
    response.setNumProcesso(entidade.getNumProcesso());
    response.setTipoProcesso(entidade.getTipoProcesso());
    response.setAberturaProcesso(entidade.getAberturaProcesso());
    response.setNumTR(entidade.getNumTR());
    response.setObjeto(entidade.getObjeto());
    return response;
  }
}
