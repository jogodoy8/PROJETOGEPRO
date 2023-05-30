package com.ufmt.GEPROAQUIP.statusPpagamento;

import java.util.Date;

public class StatusPpagamentoRequest {
    private Date data;
    private String ocorrencia;
   
    public void setData(Date data) {
        this.data = data;
    }
    public Date getData() {
        return data;
    }
    
    public void setOcorrencia(String ocorrencia) {
        this.ocorrencia = ocorrencia;
    }
    public String getOcorrencia() {
        return ocorrencia;
    }
        
  }
