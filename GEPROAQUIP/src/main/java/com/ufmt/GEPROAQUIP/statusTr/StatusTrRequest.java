package com.ufmt.GEPROAQUIP.statusTr;

import java.util.Date;

public class StatusTrRequest {

    private Date data;
    private String andamento;
    
    
    public void setData(Date data) {
        this.data = data;
    }
    public Date getData() {
        return data;
    }
        
    public void setAndamento(String andamento) {
        this.andamento = andamento;
    }
    public String getAndamento() {
        return andamento;
    }
   
}
