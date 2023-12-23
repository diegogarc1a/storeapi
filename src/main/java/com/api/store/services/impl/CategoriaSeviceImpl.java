package com.api.store.services.impl;

import com.api.store.dtos.CategoriaPostDTO;
import com.api.store.entidades.Categoria;
import com.api.store.mappers.MapStructMapper;
import com.api.store.repositories.CategoriaRepository;
import com.api.store.services.CategoriaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaSeviceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    private final MapStructMapper mapStructMapper;

    public CategoriaSeviceImpl(CategoriaRepository categoriaRepository, MapStructMapper mapStructMapper) {
        this.categoriaRepository = categoriaRepository;
        this.mapStructMapper = mapStructMapper;
    }

    @Override
    public Categoria guardarCategoria(CategoriaPostDTO CategoriaPostDTO) throws Exception {
        return categoriaRepository.save(mapStructMapper.categoriaPostDtoToCategoria(CategoriaPostDTO));
    }

    @Override
    public Categoria editarCategoria(CategoriaPostDTO CategoriaPostDTO) throws Exception {
        return categoriaRepository.save(mapStructMapper.categoriaPostDtoToCategoria(CategoriaPostDTO));
    }

    @Override
    public List<Categoria> listaCategorias() throws Exception {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria buscarPorId(Long id) throws Exception {
        return categoriaRepository.findById(id).get();
    }

    @Override
    public List<Categoria> categoriasPorDescripcion(String descripcion) throws Exception {
        return categoriaRepository.findByDescripcionContaining(descripcion);
    }


    @Override
    public void eliminar(Long id) throws Exception {
        Categoria Categoria = new Categoria();
        Categoria.setId(id);
        categoriaRepository.delete(Categoria);
    }
}
