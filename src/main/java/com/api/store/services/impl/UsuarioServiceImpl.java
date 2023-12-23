package com.api.store.services.impl;


import com.api.store.dtos.UsuarioGetBasicDTO;
import com.api.store.entidades.Usuario;
import com.api.store.entidades.UsuarioRol;
import com.api.store.exceptions.UsuarioFoundException;
import com.api.store.mappers.MapStructMapper;
import com.api.store.repositories.RolRepository;
import com.api.store.repositories.UsuarioRepository;
import com.api.store.services.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UsuarioServiceImpl implements UsuarioService {


    private final UsuarioRepository usuarioRepository;


    private final RolRepository rolRepository;


    private final MapStructMapper mapStructMapper;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, RolRepository rolRepository, MapStructMapper mapStructMapper) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
        this.mapStructMapper = mapStructMapper;
    }


    @Override
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
        System.out.println((usuario.getUsuario()));
        Usuario usuarioLocal = usuarioRepository.findByUsuario(usuario.getUsuario()).orElse(null);
        if (usuarioLocal != null){
            System.out.println("El usuario ya existe");
            throw new UsuarioFoundException("El usuario ya existe");
        }else{
            for (UsuarioRol usuarioRol : usuarioRoles){
                rolRepository.save(usuarioRol.getRol());
            }
            usuario.getUsuarioRoles().addAll(usuarioRoles);
            usuarioLocal = usuarioRepository.save(usuario);
        }
        return usuarioLocal;
    }



    @Override
    public List<UsuarioGetBasicDTO> listaUsuarios() {
        return mapStructMapper.mapUsuarioToUsuarioGetBasicDTO(usuarioRepository.findAll());
    }

    //Con mapstruct
    @Override
    public UsuarioGetBasicDTO buscarPorId(Long id){
        return mapStructMapper.usuarioToUsuarioGetBasicDTO(usuarioRepository.findById(id).get());
    }

    @Override
    public void eliminar(Long id) throws Exception {
        usuarioRepository.deleteById(id);
    }
}
