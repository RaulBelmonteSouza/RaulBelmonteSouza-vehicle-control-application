package com.scv.controleveiculos.domain.service;

import com.scv.controleveiculos.domain.model.Veiculo;
import com.scv.controleveiculos.domain.repository.VeiculoRepository;
import com.scv.controleveiculos.domain.service.client.FipeClient;
import com.scv.controleveiculos.domain.service.client.FipeResponse;
import com.scv.controleveiculos.domain.service.dto.VeiculoDTO;
import com.scv.controleveiculos.domain.service.enums.DiasDaSemana;
import com.scv.controleveiculos.domain.service.mapper.VeiculoMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.stream.Collectors;

@Service
@Transactional
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    private final VeiculoMapper veiculoMapper;

    private final FipeClient fipeClient;

    public VeiculoService(VeiculoRepository veiculoRepository
            , VeiculoMapper veiculoMapper
            , FipeClient fipeClient) {
        this.veiculoRepository = veiculoRepository;
        this.veiculoMapper = veiculoMapper;
        this.fipeClient = fipeClient;
    }

    public VeiculoDTO salvar(VeiculoDTO veiculoDTO) {

        HashMap<String, String> dadosDoVeiculo = extrairDadosDoVeiculo(veiculoDTO);
        veiculoDTO.setValor(dadosDoVeiculo.get("Valor"));

        veiculoDTO.setDiaRodizio(extrairDiaRodizio(veiculoDTO.getAnoDeFabricacao()));

        Veiculo veiculoSalvo = veiculoRepository.save(veiculoMapper.toEntity(veiculoDTO));
        return veiculoMapper.toDto(veiculoSalvo);
    }

    private HashMap<String, String> extrairDadosDoVeiculo(VeiculoDTO veiculoDTO) {
        FipeResponse marcaExtraida = extrairMarca(veiculoDTO.getMarca());

        FipeResponse modeloExtraido = extrairModelo(marcaExtraida.getCodigo(), veiculoDTO.getModelo());

        FipeResponse anoExtraido = extrairAno(marcaExtraida.getCodigo()
                , modeloExtraido.getCodigo()
                , veiculoDTO.getAnoDeFabricacao());

        return fipeClient.getVeiculo(marcaExtraida.getCodigo(), modeloExtraido.getCodigo(), anoExtraido.getCodigo());
    }

    private FipeResponse extrairMarca(String marca) {
        return fipeClient.listaMarcas().stream()
                .filter(marcaBuscada -> marcaBuscada.getNome().equals(marca))
                .collect(Collectors.toList())
                .get(0);
    }

    private FipeResponse extrairModelo(String codigoMarca, String modelo) {
        return fipeClient.listaModelos(codigoMarca).get("modelos")
                .stream()
                .filter(modeloBuscado -> modeloBuscado.getNome().equals(modelo))
                .collect(Collectors.toList())
                .get(0);
    }

    private FipeResponse extrairAno(String codigoMarca, String codigoModelo, String anoDeFabricacao) {
        return fipeClient.listaAnos(codigoMarca, codigoModelo).stream()
                .filter(anoBuscado -> anoBuscado.getNome().split(" ")[0].equals(anoDeFabricacao))
                .collect(Collectors.toList())
                .get(0);
    }


    private String extrairDiaRodizio(String anoDeFabricacao) {
        int ultimoNumeroAno = Integer.parseInt("" + anoDeFabricacao.charAt(anoDeFabricacao.length() - 1));

        if (ultimoNumeroAno <= 1)
            return DiasDaSemana.SEGUNDA_FEIRA.descricao;
        else if (ultimoNumeroAno <= 3)
            return DiasDaSemana.TERCA_FEIRA.descricao;
        else if (ultimoNumeroAno <= 5)
            return DiasDaSemana.QUARTA_FEIRA.descricao;
        else if (ultimoNumeroAno <= 7)
            return DiasDaSemana.QUINTA_FEIRA.descricao;
        else
            return DiasDaSemana.SEXTA_FEIRA.descricao;
    }
}

