package com.ufmt.GEPROAQUIP.statusPpagamento;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Id;

import com.ufmt.GEPROAQUIP.processoPagamento.ProcessoPagamento;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "statusPpagamento")
@SequenceGenerator(name = "seqStatusPpagamento", sequenceName = "seq_statusPpagamento_id", allocationSize = 1)
@Getter
@Setter

public class StatusPpagamento {

    @Id
    @GeneratedValue(generator = "seqStatusPpagamento", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column
    private Data data;
    
    @Column
    private String ocorrencia;

     @OneToMany(mappedBy = "statusPpagamento_id")
     private List<ProcessoPagamento> processospagamentos;
}
