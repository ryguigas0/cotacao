package br.espm.guilherme.cotacao.api;

public record MoedaTORequest(
        String nome,
        String simbolo,
        String sigla) {}
