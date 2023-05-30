package com.ufmt.GEPROAQUIP.processoPagamento;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessoPagamentoResponse {
    private String numProtocolo;      
    private Date dataProt;    
    private Date mesCompetencia;
    private String objeto;   
    private String numAta; 
    private String numContrato;   
    private String observacao;

  public static ProcessoPagamentoResponse from(ProcessoPagamento entidade){
    ProcessoPagamentoResponse response = new ProcessoPagamentoResponse();
    response.setNumProtocolo(entidade.getNumProtocolo());
    response.setDataProt(entidade.getDataProt());
    response.setMesCompetencia(entidade.getMesCompetencia());
    response.setObjeto(entidade.getObjeto());
    response.setNumAta(entidade.getNumAta());
    response.setNumContrato(entidade.getNumContrato());
    response.setObservacao(entidade.getObservacao());
    return response;
  }
}
