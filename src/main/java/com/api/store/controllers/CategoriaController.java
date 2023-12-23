package com.api.store.controllers;

import com.api.store.dtos.CategoriaPostDTO;
import com.api.store.entidades.Categoria;
import com.api.store.services.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
@CrossOrigin("*")
public class CategoriaController {


    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }


    @PostMapping("/")
    public ResponseEntity<Categoria> guardarLote(@RequestBody CategoriaPostDTO categoriaPostDTO)throws Exception{
        return ResponseEntity.ok(categoriaService.guardarCategoria(categoriaPostDTO));
    }

    @PutMapping("/")
    public Categoria editarLote(@RequestBody CategoriaPostDTO categoriaPostDTO) throws Exception{
        return categoriaService.editarCategoria(categoriaPostDTO);
    }

    @GetMapping("/{id}")
    public Categoria buscarPorId(@PathVariable("id") Long id) throws Exception {
        return categoriaService.buscarPorId(id);
    }
    
    @GetMapping("/")
    public ResponseEntity<?> listaLotes() throws Exception{
        return ResponseEntity.ok(categoriaService.listaCategorias());
    }


    @GetMapping("/descripcion")
    public ResponseEntity<?> categoriasPorDescripcion(@RequestParam(required = false) String descripcion) throws Exception{
        return ResponseEntity.ok(categoriaService.categoriasPorDescripcion(descripcion));
    }

    @DeleteMapping("/{id}")
    public void eliminarLote(@PathVariable("id") Long id) throws Exception{
        categoriaService.eliminar(id);
    }
}
