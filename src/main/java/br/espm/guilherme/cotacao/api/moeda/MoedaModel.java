package br.espm.guilherme.cotacao.api.moeda;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "moeda")
@NoArgsConstructor()
@Getter
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

    public MoedaModel(MoedaTORequest to) {
        this.nome = to.nome();
        this.simbolo = to.simbolo();
        this.sigla = to.sigla();
    }
}
