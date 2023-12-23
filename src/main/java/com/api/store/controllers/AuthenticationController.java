package com.api.store.controllers;

import com.api.store.entidades.JwtRequest;
import com.api.store.entidades.Usuario;
import com.api.store.services.AuthenticationService;
import com.api.store.services.impl.UsuarioDetailsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    private final UsuarioDetailsServiceImpl usuarioDetailsService;

    public AuthenticationController(AuthenticationService authenticationService, UsuarioDetailsServiceImpl usuarioDetailsService) {
        this.authenticationService = authenticationService;
        this.usuarioDetailsService = usuarioDetailsService;
    }


    @PostMapping("/generate-token")
    public ResponseEntity<?> generarToken(@RequestBody JwtRequest jwtRequest){
        return ResponseEntity.ok(authenticationService.authenticate(jwtRequest));
    }

    @GetMapping("/actual-usuario")
    public Usuario obtenerUsuarioActual(Principal principal){
        return (Usuario) this.usuarioDetailsService.loadUserByUsername(principal.getName());
    }

}
