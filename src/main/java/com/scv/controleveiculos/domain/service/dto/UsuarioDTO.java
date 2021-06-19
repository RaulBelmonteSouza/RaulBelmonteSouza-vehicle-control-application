package com.scv.controleveiculos.domain.service.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class UsuarioDTO implements Serializable {

    private static final long serialVersionUID = -7945057773876550609L;

    private Long id;

    @NotBlank
    @Size(min = 11, max = 11)
    private String cpf;

    @NotBlank
    @Size(min = 3, max = 255)
    private String email;

    @NotBlank
    @Size(max = 255)
    private String nome;

    @NotNull
    @Past
    private LocalDate dataDeNascimento;

    private List<VeiculoDTO> veiculos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public List<VeiculoDTO> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<VeiculoDTO> veiculos) {
        this.veiculos = veiculos;
    }
}
