package com.scv.controleveiculos.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "tb_veiculo")
public class Veiculo implements Serializable {

    private static final long serialVersionUID = 7827524243719201217L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank
    private String marca;

    @Column
    @NotBlank
    private String modelo;

    @Column(name = "ano_fabricacao")
    @NotBlank
    private String anoDeFabricacao;

    @Column(name = "dia_rodizio")
    private String diaRodizio;

    @Column(name = "rodizio_ativo")
    private Boolean rodizioAtivo;

    @Column(name = "tipo_combustivel")
    private String tipoDeCombustivel;

    @Column(name = "codigo_fipe")
    private String codigoFipe;

    @Column
    private String valor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Veiculo() {

    }

    public Veiculo(Long id, String marca, String modelo, String anoDeFabricacao, String diaRodizio,
                   Boolean rodizioAtivo, String tipoDeCombustivel, String codigoFipe, String valor, Usuario usuario) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.anoDeFabricacao = anoDeFabricacao;
        this.diaRodizio = diaRodizio;
        this.rodizioAtivo = rodizioAtivo;
        this.tipoDeCombustivel = tipoDeCombustivel;
        this.codigoFipe = codigoFipe;
        this.valor = valor;
        this.usuario = usuario;
    }

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
        return rodizioAtivo;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
