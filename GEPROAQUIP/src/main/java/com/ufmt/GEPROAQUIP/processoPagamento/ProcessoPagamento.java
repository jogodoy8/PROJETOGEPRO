package com.ufmt.GEPROAQUIP.processoPagamento;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;

import com.ufmt.GEPROAQUIP.notaFiscal.NotaFiscal;
import com.ufmt.GEPROAQUIP.statusPpagamento.StatusPpagamento;

import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "processo_pagamento")
@SequenceGenerator(name = "seqProcessoPagamento", sequenceName = "seq_processo_pagamento_id", allocationSize = 1)
@Getter
@Setter

public class ProcessoPagamento {
    
    @Id
    @GeneratedValue(generator = "seqProcessoPagamento", strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "numProtocolo", length = 20)
    private String numProtocolo;
    
    @Column (name = "dataProt")
    @Temporal(TemporalType.DATE)
    private Date dataProt;

    @Column (name = "mesCompetencia")
    @Temporal(TemporalType.DATE)
    private Date mesCompetencia;

    @Column(name = "objeto", length = 100)
    private String objeto;

    @Column(name = "numAta", length = 20)
    private String numAta;

    @Column(name = "numContrato", length = 100)
    private String numContrato;

    @Column(name = "observacao", length = 300)
    private String observacao;

    @OneToMany(mappedBy = "processoPagamento_id")
    private List<NotaFiscal> notasFiscais;
    
    @ManyToOne
    @JoinColumn(name = "status_ppagamento_id")
    private StatusPpagamento statusPpagamento_id;

}
