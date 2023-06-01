package com.ufmt.GEPROAQUIP.setor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ufmt.GEPROAQUIP.unidade.Unidade;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "setor")
@SequenceGenerator(name = "seqSetor", sequenceName = "seq_setor_id", allocationSize = 1)
@Getter
@Setter
public class Setor {
    @Id
    @GeneratedValue(generator = "seqSetor", strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "nome", length = 200)
    private String nome;
    @Column(name = "descricao", length = 300)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "unidade_id")
    private Unidade unidade;
}
