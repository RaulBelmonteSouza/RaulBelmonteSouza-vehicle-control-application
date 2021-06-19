package com.scv.controleveiculos.domain.service;

import com.scv.controleveiculos.domain.model.Usuario;
import com.scv.controleveiculos.domain.repository.UsuarioRepository;
import com.scv.controleveiculos.domain.service.dto.UsuarioDTO;
import com.scv.controleveiculos.domain.service.mapper.UsuarioMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
@Transactional
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {
        Usuario usuarioSalvo = usuarioRepository.save(usuarioMapper.toEntity(usuarioDTO));
        return usuarioMapper.toDto(usuarioSalvo);
    }

    public UsuarioDTO buscarPorId(Long id){
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        return usuarioMapper.toDto(usuario);
    }
}
