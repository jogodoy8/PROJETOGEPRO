package com.ufmt.GEPROAQUIP.statusPpagamento;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Id;

import com.ufmt.GEPROAQUIP.processoPagamento.ProcessoPagamento;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "status_ppagamento")
@SequenceGenerator(name = "seqStatusPpagamento", sequenceName = "seq_status_ppagamento_id", allocationSize = 1)
@Getter
@Setter

public class StatusPpagamento {

    @Id
    @GeneratedValue(generator = "seqStatusPpagamento", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column (name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    
    @Column(name = "ocorrencia", length = 300)
    private String ocorrencia;

     @OneToMany(mappedBy = "status_ppagamento_id")
     private List<ProcessoPagamento> processospagamentos;
}
