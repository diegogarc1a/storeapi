package com.api.store.mappers;

import com.api.store.dtos.CategoriaPostDTO;
import com.api.store.dtos.UsuarioGetBasicDTO;
import com.api.store.dtos.UsuarioGetDTO;
import com.api.store.entidades.Categoria;
import com.api.store.entidades.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper( componentModel = "spring")
public interface MapStructMapper {

    @Mapping(source = "id", target = "id")
    UsuarioGetDTO usuarioToUsuarioGetDTO(Usuario usuario);
    List<UsuarioGetDTO> mapUsuarioToUsuarioGetDTO(List<Usuario> usuarios);

    UsuarioGetBasicDTO usuarioToUsuarioGetBasicDTO(Usuario usuario);
    List<UsuarioGetBasicDTO> mapUsuarioToUsuarioGetBasicDTO(List<Usuario> usuarios);

    Categoria categoriaPostDtoToCategoria(CategoriaPostDTO lotePostDTO);


}
