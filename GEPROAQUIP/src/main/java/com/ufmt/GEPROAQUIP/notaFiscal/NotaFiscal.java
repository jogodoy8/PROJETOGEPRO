package com.ufmt.GEPROAQUIP.notaFiscal;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ufmt.GEPROAQUIP.cadastroFornecedor.CadastroFornecedor;
import com.ufmt.GEPROAQUIP.itemNf.ItemNf;
import com.ufmt.GEPROAQUIP.notaFiscal.NotaFiscal;
import com.ufmt.GEPROAQUIP.processoPagamento.ProcessoPagamento;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "nota_fiscal")
@SequenceGenerator(name = "seqNotaFiscal", sequenceName = "seq_notaFiscal_id", allocationSize = 1)
@Getter
@Setter

public class NotaFiscal {

    @Id
    @GeneratedValue(generator = "seqNotaFiscal", strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "numNf", length = 20)
    private String numNf;
    @Column (name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "valor")
    private double valor;
    @Column(name = "emprenho", nullable = false)
    private boolean  empenho;
    @Column(name = "liquidacao", nullable = false)
    private boolean  liquidacao;
    @Column(name = "pagamento", nullable = false)
    private boolean  pagamento; 

    @OneToMany(mappedBy = "nota_fiscal_id")
    private List<ItemNf> itensNf;
    
    @ManyToOne
    @JoinColumn(name = "cadastro_forncedor_id")
    private CadastroFornecedor cadastroFornecedor_id;

    @ManyToOne
    @JoinColumn(name = "processo_pagamento_id")
    private ProcessoPagamento processoPagamento_id;
    
}
