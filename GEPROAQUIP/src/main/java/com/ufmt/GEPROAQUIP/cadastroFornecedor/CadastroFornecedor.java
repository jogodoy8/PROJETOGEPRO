package com.ufmt.GEPROAQUIP.cadastroFornecedor;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.boot.TempTableDdlTransactionHandling;

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
    @Column (name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column (name = "nome", length = 200)
    private String nome;
    @Column(name = "cnpj", length = 200)
    private String cnpj;
    @Column(name = "endereco", length = 200)
    private String endereco;
    @Column(name = "email", length = 200)
    private String email;
    @Column(name = "fone", length = 30)
    private String fone;

    @OneToMany(mappedBy = "cadastroFornecedor_id")
    private List<NotaFiscal> notasFiscais;
}
