package com.ufmt.GEPROAQUIP.statusTr;

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

import com.ufmt.GEPROAQUIP.termoReferencia.TermoReferencia;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "status_tr")
@SequenceGenerator(name = "seqStatusTr", sequenceName = "seq_status_tr_id", allocationSize = 1)
@Getter
@Setter
public class StatusTr {
    @Id
    @GeneratedValue(generator = "seqStatusTr", strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "andamento", length = 200)
    private String andamento;

    @OneToMany(mappedBy = "status_tr_id")
    private List<TermoReferencia> TermosReferencia;
       
}
