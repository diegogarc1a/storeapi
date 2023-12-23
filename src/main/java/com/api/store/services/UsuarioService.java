package com.api.store.services;

import com.api.store.dtos.UsuarioGetBasicDTO;
import com.api.store.entidades.Usuario;
import com.api.store.entidades.UsuarioRol;

import java.util.List;
import java.util.Set;

public interface UsuarioService {
    Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;

    List<UsuarioGetBasicDTO> listaUsuarios();

    UsuarioGetBasicDTO buscarPorId(Long id) throws Exception;

    void eliminar(Long id) throws Exception;
}
