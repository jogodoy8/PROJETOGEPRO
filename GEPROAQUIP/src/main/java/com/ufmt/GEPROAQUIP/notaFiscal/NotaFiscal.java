package com.ufmt.GEPROAQUIP.notaFiscal;

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

import com.ufmt.GEPROAQUIP.cadastroFornecedor.CadastroFornecedor;
import com.ufmt.GEPROAQUIP.itemNf.ItemNf;
import com.ufmt.GEPROAQUIP.notaFiscal.NotaFiscal;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "notaFiscal")
@SequenceGenerator(name = "seqNotaFiscal", sequenceName = "seq_notaFiscal_id", allocationSize = 1)
@Getter
@Setter

public class NotaFiscal {

    @Id
    @GeneratedValue(generator = "seqNotaFiscal", strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    private String numNf;
    @Column
    private Date data;
    @Column
    private double valor;
    @Column
    private boolean  empenho;
    @Column
    private boolean  liquidacao;
    @Column
    private boolean  pagamento; 

    @OneToMany(mappedBy = "notaFiscal_id")
    private List<ItemNf> itensNf;
    
    @ManyToOne
    @JoinColumn(name = "cadastroForncedor_id")
    private CadastroFornecedor cadastroFornecedor_id;
    
}
