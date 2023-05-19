package com.ufmt.GEPROAQUIP.cadastroFornecedor;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ufmt.GEPROAQUIP.notaFiscal.NotaFiscal;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cadastro_fornecedor")
@SequenceGenerator(name = "seqCadastroFornecedor", sequenceName = "seq_cadastro_fornecedor_id", allocationSize = 1)
@Getter
@Setter


public class CadastroFornecedor {

    @Id
    @GeneratedValue(generator = "seqCadastroFornecedor", strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    private Data data;
    @Column
    private String nome;
    @Column
    private String cnpj;
    @Column
    private String endereco;
    @Column
    private String email;
    @Column
    private String fone;

    @OneToMany(mappedBy = "cadastro_fornecedor_id")
    private List<NotaFiscal> notasFiscais;
}
