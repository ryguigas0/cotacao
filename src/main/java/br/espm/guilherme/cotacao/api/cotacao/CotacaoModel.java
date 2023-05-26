package br.espm.guilherme.cotacao.api.cotacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cotacao")
@NoArgsConstructor()
@Getter
public class CotacaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "valor")
    private Double valor;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data")
    private Date data;

    @Column(name = "moeda_id")
    private String moedaId;

    public CotacaoModel(CotacaoRequestTO cotacaoRequestTO) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-LL-dd HH:mm");

        this.valor = cotacaoRequestTO.valor();
        this.moedaId = cotacaoRequestTO.moedaId();
        try {
            this.data = sdf.parse(cotacaoRequestTO.date());
        } catch (ParseException e) {
            throw new RuntimeException("ERROR PARSING DATE");
        }
    }
}
