package com.ufmt.GEPROAQUIP.itemNf;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ufmt.GEPROAQUIP.notaFiscal.NotaFiscal;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "item_nf")
@SequenceGenerator(name = "seqItemNf", sequenceName = "seq_item_nf_id", allocationSize = 1)
@Getter
@Setter

public class ItemNf {

    @Id
    @GeneratedValue(generator = "seqItemNf", strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "quantidade")
    private int quantidade;
    @Column(name = "tipo", length = 100)
    private String tipo;
    @Column(name = "descricao", length = 100)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "nota_fiscal_id")
    private NotaFiscal notaFiscal_id;
    
}
