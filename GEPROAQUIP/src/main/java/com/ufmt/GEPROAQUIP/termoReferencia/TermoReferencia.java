package com.ufmt.GEPROAQUIP.termoReferencia;

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

import com.ufmt.GEPROAQUIP.itemTr.ItemTr;
import com.ufmt.GEPROAQUIP.statusTr.StatusTr;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "termo_referencia")
@SequenceGenerator(name = "seqTermoReferencia", sequenceName = "seq_termo_referencia_id", allocationSize = 1)
@Getter
@Setter

public class TermoReferencia {
    @Id
    @GeneratedValue(generator = "seqTermoReferencia", strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    private String numProcesso;
    @Column
    private String tipoProcesso;
    @Column
    private Date aberturaProcesso;
    @Column
    private String numTR;
    @Column
    private String objeto;

    @ManyToOne
    @JoinColumn(name = "status_tr_id")
    private StatusTr statusTr_id;

    @OneToMany(mappedBy = "termoReferencia_id")
    private List<ItemTr> itensTr;
}
