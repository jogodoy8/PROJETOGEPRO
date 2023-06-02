package com.ufmt.GEPROAQUIP.cadastroFornecedor;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CadastroFornecedorResponse {
  private Date data;
  private String nome;
  private String cnpj;
  private String endereco;
  private String email;
  private String fone;

  public static CadastroFornecedorResponse from(CadastroFornecedor entidade){
    CadastroFornecedorResponse response = new CadastroFornecedorResponse();
    response.setData(entidade.getData());
    response.setNome(entidade.getNome());
    response.setCnpj(entidade.getCnpj());
    response.setEndereco(entidade.getEndereco());
    response.setEmail(entidade.getEmail());
    response.setFone(entidade.getFone());
    return response;
  }
}