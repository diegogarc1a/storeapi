package com.api.store.controllers;

import com.api.store.dtos.UsuarioGetBasicDTO;
import com.api.store.entidades.Rol;
import com.api.store.entidades.Usuario;
import com.api.store.entidades.UsuarioRol;
import com.api.store.services.UsuarioService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {


    private final UsuarioService usuarioService;


    private final PasswordEncoder bCryptPasswordEncoder;

    public UsuarioController(UsuarioService usuarioService, PasswordEncoder bCryptPasswordEncoder) {
        this.usuarioService = usuarioService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/")
    public Usuario guardarUsuario(@RequestBody Usuario usuario)throws Exception{
        Set<UsuarioRol> usuarioRoles = new HashSet<>();

        usuario.setPassword(this.bCryptPasswordEncoder.encode(usuario.getPassword()));
        Rol rol = new Rol();
        rol.setNombre("NORMAL");

        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(usuario);
        usuarioRol.setRol(rol);

        usuarioRoles.add(usuarioRol);

        return usuarioService.guardarUsuario(usuario,usuarioRoles);
    }

    @GetMapping("/")
  /*  @PreAuthorize("hasAuthority('ADMIN')")*/

    public List<UsuarioGetBasicDTO> listaUsuarios() throws Exception{
        return usuarioService.listaUsuarios();
    }

    @GetMapping("/{id}")
    /*@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('NORMAL')")*/
    public UsuarioGetBasicDTO obtenerUsuario(@PathVariable("id") Long id) throws Exception{
        return usuarioService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable("id") Long id) throws Exception{
        usuarioService.eliminar(id);
    }
}
