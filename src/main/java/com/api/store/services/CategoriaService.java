package com.api.store.services;



import com.api.store.dtos.CategoriaPostDTO;
import com.api.store.entidades.Categoria;

import java.util.List;


public interface CategoriaService {



    Categoria guardarCategoria(CategoriaPostDTO CategoriaPostDTO) throws Exception;

    Categoria editarCategoria(CategoriaPostDTO CategoriaPostDTO) throws Exception;
    List<Categoria> listaCategorias () throws Exception;

    Categoria buscarPorId(Long id) throws Exception;

    List<Categoria> categoriasPorDescripcion(String descripcion) throws Exception;

    void eliminar(Long id) throws Exception;

}
