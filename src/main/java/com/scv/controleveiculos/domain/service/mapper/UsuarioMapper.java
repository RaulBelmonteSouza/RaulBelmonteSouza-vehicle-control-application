package com.scv.controleveiculos.domain.service.mapper;

import com.scv.controleveiculos.domain.model.Usuario;
import com.scv.controleveiculos.domain.service.dto.UsuarioDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = { VeiculoMapper.class })
public interface UsuarioMapper {

    UsuarioDTO toDto(Usuario usuario);

    Usuario toEntity(UsuarioDTO usuarioDTO);

    List<UsuarioDTO> toDto(List<Usuario> usuarios);

    List<Usuario> toEntity(List<UsuarioDTO> usuarios);

}
