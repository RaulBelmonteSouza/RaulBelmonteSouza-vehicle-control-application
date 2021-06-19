package com.scv.controleveiculos.domain.service.enums;

public enum DiasDaSemana {

    SEGUNDA_FEIRA("Segunda-feira"),
    TERCA_FEIRA("Terça-feira"),
    QUARTA_FEIRA("Quarta-feira"),
    QUINTA_FEIRA("Quinta-feira"),
    SEXTA_FEIRA("Sexta-feira"),
    SABADO("Sábado"),
    DOMINGO("Domingo");

    public String descricao;

    DiasDaSemana(String dia) {
        descricao = dia;
    }

}

