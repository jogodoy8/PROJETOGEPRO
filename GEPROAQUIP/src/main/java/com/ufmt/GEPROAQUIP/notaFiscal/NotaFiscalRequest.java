package com.ufmt.GEPROAQUIP.notaFiscal;

import java.util.Date;

public class NotaFiscalRequest {
    private String numNf;
    private Date data;
    private double valor;
    private boolean  empenho;
    private boolean  liquidacao;
    private boolean  pagamento;

    public void setNumNf(String numNf) {
        this.numNf = numNf;
    }

    public String getNumNf() {
        return numNf;
    }

        
    public void setData(Date data) {
        this.data = data;
    }

    public Date getData() {
        return data;
    }
       
    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

   
    public void setEmpenho(boolean empenho) {
        this.empenho = empenho;
    }

    public boolean getEmpenho() {
        return empenho;
    }
    

    public void setLiquidacao(boolean liquidacao) {
        this.liquidacao = liquidacao;
    }

    public boolean getLiquidacao() {
        return liquidacao;
    }

       
    public void setPagamento(boolean pagamento) {
        this.pagamento = pagamento;
    }

    public boolean getPagamento() {
        return pagamento;
    }
    
  }
  
