package com.api.store.securityconfig;

import com.api.store.services.JwtService;
import com.api.store.services.impl.UsuarioDetailsServiceImpl;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final UsuarioDetailsServiceImpl usuarioDetailsService;


    private final JwtService jwtService;

    public JwtAuthenticationFilter(UsuarioDetailsServiceImpl usuarioDetailsService, JwtService jwtService) {
        this.usuarioDetailsService = usuarioDetailsService;
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain)
            throws ServletException, IOException {
        final String requestTokenHeader = request.getHeader("Authorization");
        String jwtToken = null;
        String usuario = null;

        if (requestTokenHeader == null || !requestTokenHeader.startsWith("Bearer ")){
            filterChain.doFilter(request, response);
            logger.warn("El token JWT no comienza con Bearer String");
            System.out.println("El token JWT no comienza con Bearer String");
            return;
        }
        jwtToken = requestTokenHeader.substring(7);
        usuario = jwtService.extractUsername(jwtToken);
        if (usuario  != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = this.usuarioDetailsService.loadUserByUsername(usuario);
            if (jwtService.validateToken(jwtToken, userDetails)){
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }

}
