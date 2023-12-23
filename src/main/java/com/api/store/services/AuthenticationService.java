package com.api.store.services;

import com.api.store.entidades.JwtRequest;
import com.api.store.entidades.JwtResponse;
import com.api.store.entidades.Usuario;
import com.api.store.repositories.UsuarioRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository usuarioRepository;

    private final JwtService jwtService;

    public AuthenticationService(AuthenticationManager authenticationManager,
                                 UsuarioRepository usuarioRepository, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.usuarioRepository = usuarioRepository;
        this.jwtService = jwtService;
    }

    public JwtResponse authenticate(JwtRequest jwtRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsuario(), jwtRequest.getPassword()));
        Usuario usuario = usuarioRepository.findByUsuario(jwtRequest.getUsuario()).get();
        String token = jwtService.generateToken(usuario);
        return new JwtResponse(token);
    }

}
