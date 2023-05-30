package com.ufmt.GEPROAQUIP.processoPagamento;

import java.util.Date;

public class ProcessoPagamentoRequest {
    private String numProtocolo;      
    private Date dataProt;    
    private Date mesCompetencia;
    private String objeto;   
    private String numAta; 
    private String numContrato;   
    private String observacao;
    
    public void setNumProtocolo(String numProtocolo) {
        this.numProtocolo = numProtocolo;
    }

    public String getNumProtocolo() {
        return numProtocolo;
    }

  
    public void setDataProt(Date dataProt) {
        this.dataProt = dataProt;
    }

    public Date getDataProt() {
        return dataProt;
    }
   
       
    public void setMesCompetencia(Date mesCompetencia) {
        this.mesCompetencia = mesCompetencia;
    }

    public Date getMesCompetencia() {
        return mesCompetencia;
    }

    

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getObjeto() {
        return objeto;
    }
      

    public void setNumAta(String numAta) {
        this.numAta = numAta;
    }

    public String getNumAta() {
        return numAta;
    }
    
    public void setNumContrato(String numContrato) {
        this.numContrato = numContrato;
    }

    public String getNumContrato() {
        return numContrato;
    }       
   
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getObservacao() {
        return observacao;
    }
       
  }