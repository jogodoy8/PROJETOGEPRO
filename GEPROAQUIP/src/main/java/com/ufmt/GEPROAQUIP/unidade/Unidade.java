package com.ufmt.GEPROAQUIP.unidade;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ufmt.GEPROAQUIP.setor.Setor;

import lombok.Getter;
import lombok.Setter;

@Entity
 @Table(name = "unidade")
 @SequenceGenerator(name = "seqUnidade", sequenceName = "seq_unidade_id", allocationSize = 1)
 @Getter
 @Setter

public class Unidade {

    @Id
    @GeneratedValue(generator = "seqUnidade", strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "nome", length = 200)
    private String nome;

    @OneToMany(mappedBy = "unidade")
    private List<Setor> setores;
 }