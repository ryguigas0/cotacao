package br.espm.guilherme.cotacao.api.cotacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.espm.guilherme.cotacao.api.moeda.MoedaTOResponse;

public record CotacaoResponseTO(
        String id,
        Double valor,
        MoedaTOResponse moeda,
        Date data) {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm");

    public CotacaoResponseTO(String id, Double valor, MoedaTOResponse moeda, String data) throws ParseException {
        this(id, valor, moeda, sdf.parse(data));
    }
}
