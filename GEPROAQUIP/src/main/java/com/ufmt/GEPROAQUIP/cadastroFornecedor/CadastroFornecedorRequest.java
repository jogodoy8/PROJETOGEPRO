package com.ufmt.GEPROAQUIP.cadastroFornecedor;

import java.util.Date;

import lombok.Data;

public class CadastroFornecedorRequest {
    
  
private Date data;

public void setData(Date data) {
    this.data = data;
}
public Date getData() {
    return data;
}

private String nome;

public void setNome(String nome) {
    this.nome = nome;
}

public String getNome() {
    return nome;
}

  private String cnpj;

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
}

  public String getCnpj() {
    return cnpj;
}

private String endereco;
  
  public void setEndereco(String endereco) {
    this.endereco = endereco;
}

  public String getEndereco() {
    return endereco;
}

private String email;
  
 public void setEmail(String email) {
    this.email = email;
}

  public String getEmail() {
    return email;
}

  private String fone;

  public void setFone(String fone){
    this.fone = fone;
  }

  public String getFone(){
    return fone;
  }
}

