package com.ufmt.GEPROAQUIP.termoReferencia;

import java.util.Date;

public class TermoReferenciaRequest {

    private String numProcesso;
    private String tipoProcesso;
    private Date aberturaProcesso;
    private String numTR;
    private String objeto;
    
    public void setNumProcesso(String numProcesso) {
        this.numProcesso = numProcesso;
    }
    public String getNumProcesso() {
        return numProcesso;
    }
       
    public void setTipoProcesso(String tipoProcesso) {
        this.tipoProcesso = tipoProcesso;
    }
    public String getTipoProcesso() {
        return tipoProcesso;
    }
   
    public void setAberturaProcesso(Date aberturaProcesso) {
        this.aberturaProcesso = aberturaProcesso;
    }
    public Date getAberturaProcesso() {
        return aberturaProcesso;
    }
      
    public void setNumTR(String numTR) {
        this.numTR = numTR;
    }
    public String getNumTR() {
        return numTR;
    }
    
    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }
    public String getObjeto() {
        return objeto;
    }
       
}
