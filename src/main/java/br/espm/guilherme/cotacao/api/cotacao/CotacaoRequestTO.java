package br.espm.guilherme.cotacao.api.cotacao;

public record CotacaoRequestTO(
        Double valor,
        String moedaId,
        String date) {
}
