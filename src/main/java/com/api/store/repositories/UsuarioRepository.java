package com.api.store.repositories;

import com.api.store.entidades.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findByUsuario(String usuario);
/*    Usuario findByNombre (String usuario);*/


}
