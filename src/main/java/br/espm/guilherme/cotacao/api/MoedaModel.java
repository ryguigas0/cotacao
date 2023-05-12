package br.espm.guilherme.cotacao.api;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "moeda")
public class MoedaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "simbolo")
    private String simbolo;

    @Column(name = "sigla")
    private String sigla;

    public MoedaModel(){}

    public MoedaModel(MoedaTORequest to){
        this.nome = to.nome();
        this.simbolo = to.simbolo();
        this.sigla = to.sigla();
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public String getSigla() {
        return sigla;
    }

}
