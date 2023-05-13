package com.ufmt.GEPROAQUIP.statusTr;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ufmt.GEPROAQUIP.termoReferencia.TermoReferencia;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "statusTr")
@SequenceGenerator(name = "seqStatusTr", sequenceName = "seq_statusTr_id", allocationSize = 1)
@Getter
@Setter
public class StatusTr {
    @Id
    @GeneratedValue(generator = "seqStatusTr", strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    private Data data;
    @Column
    private String andamento;

    @OneToMany(mappedBy = "statusTr_id")
    private List<TermoReferencia> TermosReferencia;
       
}
