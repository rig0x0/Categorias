package com.upiiz.categorias.services;

import com.upiiz.categorias.models.CategoriasModel;
import com.upiiz.categorias.repository.CategoriasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// Se crea una instancia de esta clase
@Service
public class CategoriasService {
    // Requerimos el REPO - Datos/listado - Categorias

    CategoriasRepository categoriasRepository;
    // Crear constructor - cuando crea la instancia le pasa el repositorio
    public CategoriasService (CategoriasRepository categoriasRepository ){
        this.categoriasRepository= categoriasRepository;
    }

    // GET - Todas las categorias
    public List<CategoriasModel> getAllCategorias(){
        return categoriasRepository.getCategorias();
    }

    // GET - Categoria por Id
    public CategoriasModel getCategoriaById(Long id){
        return categoriasRepository.obtenerPorId(id);
    }

    // POST - Crear categoria
    public CategoriasModel crearCategoria(CategoriasModel categoria){
        return categoriasRepository.guardar(categoria);
    }

    // PUT - Actualizar categoria
    public CategoriasModel updateCategoria(CategoriasModel categoria){
        return categoriasRepository.actualizar(categoria);
    }
    // DELETE - Eliminar categoria
    public void deleteCategoria(Long id){
        categoriasRepository.eliminar(id);
    }
}
