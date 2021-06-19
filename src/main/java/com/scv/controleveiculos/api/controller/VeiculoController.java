package com.scv.controleveiculos.api.controller;

import com.scv.controleveiculos.domain.service.VeiculoService;
import com.scv.controleveiculos.domain.service.dto.VeiculoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("veiculos")
public class VeiculoController {

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @PostMapping
    public ResponseEntity<VeiculoDTO> adicionarVeiculo(@RequestBody @Valid VeiculoDTO veiculoDTO){
        return ResponseEntity.created(null).body(veiculoService.salvar(veiculoDTO));
    }
}
