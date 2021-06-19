package com.scv.controleveiculos.api.controller;

import com.scv.controleveiculos.domain.service.UsuarioService;
import com.scv.controleveiculos.domain.service.dto.UsuarioDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<UsuarioDTO> buscarUsuarioPorId(@PathVariable("usuarioId") Long usuarioId) {
        try {
            return ResponseEntity.ok(usuarioService.buscarPorId(usuarioId));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> adicionarUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        return ResponseEntity.created(null).body(usuarioService.salvar(usuarioDTO));
    }
}
