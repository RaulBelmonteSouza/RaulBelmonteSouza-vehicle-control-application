package com.scv.controleveiculos.domain.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;

@FeignClient(name = "fipe", url = "https://parallelum.com.br/fipe/api/v1/carros/")
public interface FipeClient {

    @GetMapping("marcas")
    List<FipeResponse> listaMarcas();

    @GetMapping("marcas/{codigoMarca}/modelos")
    HashMap<String, List<FipeResponse>> listaModelos(@PathVariable("codigoMarca") String codigoMarca);

    @GetMapping("marcas/{codigoMarca}/modelos/{codigoModelo}/anos")
    List<FipeResponse> listaAnos(@PathVariable("codigoMarca") String codigoMarca,
                               @PathVariable("codigoModelo") String codigoModelo);

    @GetMapping("/marcas/{codigoMarca}/modelos/{codigoModelo}/anos/{anoVeiculo}")
    HashMap<String,String> getVeiculo(@PathVariable("codigoMarca") String codigoMarca,
                                      @PathVariable("codigoModelo") String idModelo,
                                      @PathVariable("anoVeiculo") String anoVeiculo);
}
