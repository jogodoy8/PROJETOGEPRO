package com.ufmt.GEPROAQUIP.notaFiscal;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotaFiscalResponse {
    private String numNf;
    private Date data;
    private double valor;
    private boolean  empenho;
    private boolean  liquidacao;
    private boolean  pagamento;

  public static NotaFiscalResponse from(NotaFiscal entidade){
    NotaFiscalResponse response = new NotaFiscalResponse();
    response.setNumNf(entidade.getNumNf());
    response.setData(entidade.getData());
    response.setValor(entidade.getValor());
    response.setEmpenho(entidade.isEmpenho());
    response.setLiquidacao(entidade.isLiquidacao());
    response.setPagamento(entidade.isPagamento());
    return response;
  }
}
