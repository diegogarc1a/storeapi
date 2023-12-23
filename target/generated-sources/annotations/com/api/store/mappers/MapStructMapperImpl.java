package com.api.store.mappers;

import com.api.store.dtos.CategoriaPostDTO;
import com.api.store.dtos.UsuarioGetBasicDTO;
import com.api.store.dtos.UsuarioGetDTO;
import com.api.store.entidades.Categoria;
import com.api.store.entidades.Usuario;
import com.api.store.entidades.UsuarioRol;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-23T11:33:55-0600",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class MapStructMapperImpl implements MapStructMapper {

    @Override
    public UsuarioGetDTO usuarioToUsuarioGetDTO(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioGetDTO usuarioGetDTO = new UsuarioGetDTO();

        usuarioGetDTO.setId( usuario.getId() );
        usuarioGetDTO.setUsuario( usuario.getUsuario() );
        usuarioGetDTO.setNombre( usuario.getNombre() );
        usuarioGetDTO.setApellido( usuario.getApellido() );
        usuarioGetDTO.setEmail( usuario.getEmail() );
        usuarioGetDTO.setTelefono( usuario.getTelefono() );
        usuarioGetDTO.setEstado( usuario.isEstado() );
        Set<UsuarioRol> set = usuario.getUsuarioRoles();
        if ( set != null ) {
            usuarioGetDTO.setUsuarioRoles( new LinkedHashSet<UsuarioRol>( set ) );
        }

        return usuarioGetDTO;
    }

    @Override
    public List<UsuarioGetDTO> mapUsuarioToUsuarioGetDTO(List<Usuario> usuarios) {
        if ( usuarios == null ) {
            return null;
        }

        List<UsuarioGetDTO> list = new ArrayList<UsuarioGetDTO>( usuarios.size() );
        for ( Usuario usuario : usuarios ) {
            list.add( usuarioToUsuarioGetDTO( usuario ) );
        }

        return list;
    }

    @Override
    public UsuarioGetBasicDTO usuarioToUsuarioGetBasicDTO(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioGetBasicDTO usuarioGetBasicDTO = new UsuarioGetBasicDTO();

        usuarioGetBasicDTO.setId( usuario.getId() );
        usuarioGetBasicDTO.setUsuario( usuario.getUsuario() );
        usuarioGetBasicDTO.setNombre( usuario.getNombre() );
        usuarioGetBasicDTO.setApellido( usuario.getApellido() );
        usuarioGetBasicDTO.setEmail( usuario.getEmail() );
        usuarioGetBasicDTO.setTelefono( usuario.getTelefono() );
        usuarioGetBasicDTO.setEstado( usuario.isEstado() );

        return usuarioGetBasicDTO;
    }

    @Override
    public List<UsuarioGetBasicDTO> mapUsuarioToUsuarioGetBasicDTO(List<Usuario> usuarios) {
        if ( usuarios == null ) {
            return null;
        }

        List<UsuarioGetBasicDTO> list = new ArrayList<UsuarioGetBasicDTO>( usuarios.size() );
        for ( Usuario usuario : usuarios ) {
            list.add( usuarioToUsuarioGetBasicDTO( usuario ) );
        }

        return list;
    }

    @Override
    public Categoria categoriaPostDtoToCategoria(CategoriaPostDTO lotePostDTO) {
        if ( lotePostDTO == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        categoria.setNombre( lotePostDTO.getNombre() );
        categoria.setDescripcion( lotePostDTO.getDescripcion() );

        return categoria;
    }
}
