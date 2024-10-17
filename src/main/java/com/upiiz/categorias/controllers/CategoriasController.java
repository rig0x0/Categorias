package com.upiiz.categorias.controllers;

import com.upiiz.categorias.CategoriasApplication;
import com.upiiz.categorias.models.CategoriasModel;
import com.upiiz.categorias.services.CategoriasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriasController {

    //Requiero inyectar el servicio
    CategoriasService categoriasService;

    public CategoriasController (CategoriasService categoriasService) {
        this.categoriasService = categoriasService;
    }

    // GET - Todas las categorias
    @GetMapping
    public ResponseEntity<List<CategoriasModel>> getCategorias(){
        return ResponseEntity.ok(categoriasService.getAllCategorias());
    }

    // GET - solo una categoria
    @GetMapping("/{id}")
    public ResponseEntity<CategoriasModel> getCategoriaPorID(@PathVariable Long id){
        return ResponseEntity.ok(categoriasService.getCategoriaById(id));
    }

    // POST - Crear una categoria
    @PostMapping
    public ResponseEntity<CategoriasModel> addCategoria(@RequestBody CategoriasModel categoria){
        return ResponseEntity.ok(categoriasService.crearCategoria(categoria));
    }
    // PUT . Actualizar una categoria
    @PutMapping("/{id}")
    public ResponseEntity<CategoriasModel> actualizarCategoria(@RequestBody CategoriasModel categoria, @PathVariable Long id){
        categoria.setId(id);
        return ResponseEntity.ok(categoriasService.updateCategoria(categoria));
    }

    // DELETE - Eliminar una categoria por Id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable Long id){
        categoriasService.deleteCategoria(id);
        return ResponseEntity.noContent().build();
    }
}
