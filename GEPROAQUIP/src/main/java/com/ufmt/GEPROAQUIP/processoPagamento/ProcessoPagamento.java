package com.ufmt.GEPROAQUIP.processoPagamento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import com.ufmt.GEPROAQUIP.statusPpagamento.StatusPpagamento;

import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "processoPagamento")
@SequenceGenerator(name = "seqProcessoPagamento", sequenceName = "seq_processoPagamento_id", allocationSize = 1)
@Getter
@Setter

public class ProcessoPagamento {
    
    @Id
    @GeneratedValue(generator = "seqProcessoPagamento", strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    private String numProtocolo;
    
    @Column
    private Data dataProt;

    @Column
    private Data mesCompetencia;

    @Column
    private String objeto;

    @Column
    private String numAta;

    @Column
    private String numContrato;

    @Column
    private String observacao;
    
    @ManyToOne
    @JoinColumn(name = "statusPpagamento_id")
    private StatusPpagamento statusPpagamento_id;

}
