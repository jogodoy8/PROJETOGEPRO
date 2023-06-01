package com.ufmt.GEPROAQUIP.itemTr;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ufmt.GEPROAQUIP.termoReferencia.TermoReferencia;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "item_tr")
@SequenceGenerator(name = "seqItemTr", sequenceName = "seq_item_tr_id", allocationSize = 1)
@Getter
@Setter

public class ItemTr {
    @Id
    @GeneratedValue(generator = "seqItemTr", strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "quantidade")
    private int quantidade;
    @Column(name = "descricao", length = 100)
    private String descricao;
    @Column(name = "valor")
    private double valor;

    @ManyToOne
    @JoinColumn(name = "termo_referencia_id")
    private TermoReferencia termoReferencia_id;

}