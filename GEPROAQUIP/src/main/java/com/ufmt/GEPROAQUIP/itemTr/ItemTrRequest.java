package com.ufmt.GEPROAQUIP.itemTr;

public class ItemTrRequest {
    private int quantidade;
    private String descricao;
    private double valor;
  
    public void setQuantidade(int quantidade){
      this.quantidade = quantidade;
    }
  
    public int getQuantidade(){
      return quantidade;
    }
  
    
    public void setDescricao(String descricao){
      this.descricao = descricao;
    }
  
    public String getDescricao(){
      return descricao;
    }
  
    
    public void setValor(double valor){
      this.valor = valor;
    }
  
    public double getValor(){
      return valor;
    }
  
}
  
