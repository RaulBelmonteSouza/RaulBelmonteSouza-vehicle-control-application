package com.scv.controleveiculos.domain.service.dto;

import com.scv.controleveiculos.domain.service.enums.DiasDaSemana;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class VeiculoDTO implements Serializable {

    private static final long serialVersionUID = -2363531184201302226L;

    private Long id;

    @NotBlank
    @Size(max = 255)
    private String marca;

    @NotBlank
    @Size(max = 255)
    private String modelo;

    @NotBlank
    @Size(min = 4)
    private String anoDeFabricacao;

    private String diaRodizio;

    private Boolean rodizioAtivo;

    @Size(max = 255)
    private String tipoDeCombustivel;

    @Size(max = 255)
    private String codigoFipe;

    private String valor;

    @NotNull
    private Long usuarioId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnoDeFabricacao() {
        return anoDeFabricacao;
    }

    public void setAnoDeFabricacao(String anoDeFabricacao) {
        this.anoDeFabricacao = anoDeFabricacao;
    }

    public String getDiaRodizio() {
        return diaRodizio;
    }

    public void setDiaRodizio(String diaRodizio) {
        this.diaRodizio = diaRodizio;
    }

    public Boolean getRodizioAtivo() {
        if (this.diaRodizio != null){
            this.setRodizioAtivo(this.isRodizioAtivo());
        }
        return rodizioAtivo;
    }

    private Boolean isRodizioAtivo() {
        DayOfWeek diaDeHoje = LocalDateTime.now().getDayOfWeek();
        boolean isRodizioAtivo = false;
        if (diaDeHoje.equals(DayOfWeek.FRIDAY)) {
            isRodizioAtivo = this.getDiaRodizio().equals(DiasDaSemana.SEXTA_FEIRA.descricao);

        } else if (diaDeHoje.equals(DayOfWeek.THURSDAY)) {
            isRodizioAtivo = this.getDiaRodizio().equals(DiasDaSemana.QUINTA_FEIRA.descricao);

        } else if (diaDeHoje.equals(DayOfWeek.WEDNESDAY)) {
            isRodizioAtivo = this.getDiaRodizio().equals(DiasDaSemana.QUARTA_FEIRA.descricao);

        } else if (diaDeHoje.equals(DayOfWeek.TUESDAY)) {
            isRodizioAtivo = this.getDiaRodizio().equals(DiasDaSemana.TERCA_FEIRA.descricao);

        } else if (diaDeHoje.equals(DayOfWeek.MONDAY)) {
            isRodizioAtivo = this.getDiaRodizio().equals(DiasDaSemana.SEGUNDA_FEIRA.descricao);
        }

        return isRodizioAtivo;
    }

    public void setRodizioAtivo(Boolean rodizioAtivo) {
        this.rodizioAtivo = rodizioAtivo;
    }

    public String getTipoDeCombustivel() {
        return tipoDeCombustivel;
    }

    public void setTipoDeCombustivel(String tipoDeCombustivel) {
        this.tipoDeCombustivel = tipoDeCombustivel;
    }

    public String getCodigoFipe() {
        return codigoFipe;
    }

    public void setCodigoFipe(String codigoFipe) {
        this.codigoFipe = codigoFipe;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuario) {
        this.usuarioId = usuario;
    }
}
