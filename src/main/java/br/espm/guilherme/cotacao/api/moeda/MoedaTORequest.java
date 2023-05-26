package br.espm.guilherme.cotacao.api.moeda;

public record MoedaTORequest(
        String nome,
        String simbolo,
        String sigla) {}
