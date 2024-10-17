package com.upiiz.categorias.repository;

import com.upiiz.categorias.models.CategoriasModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CategoriasRepository {
    // Almacenar en un listado las categorias; salvar, listar, eliminar, actualizar
    // Generar de manera unica el id para cada categoria

    // Generar de manera unica el id para cada categoria
    private List<CategoriasModel> categorias  = new ArrayList<>(); // Evitar el null pointer exception
    private AtomicLong id = new AtomicLong(); // Para incrementar automaticamente el id

    // Agregamos la categoria al listado y la regresamos
    // Post
    public CategoriasModel guardar(CategoriasModel categoria){
        categoria.setId(id.incrementAndGet());
        categorias.add(categoria);
        return categoria;
    }

    //GET - Todas las categorias
    public List<CategoriasModel> getCategorias(){
        return categorias;
    }

    //GET - solo una categoria
    public CategoriasModel obtenerPorId(Long id){
        // Estructurada
//        for(CategoriasModel categoria : categorias){
//            if (categoria.getId() == id){
//                return categoria;
//            }
//        }
//        return null;

        // Funcional
        return categorias.stream().filter(categorias -> categorias.getId().equals(id)).findFirst().orElse(null);

    }

    //DELETE
    public void eliminar(Long id){
        categorias.removeIf(categorias -> categorias.getId().equals(id));
    }

    //PUT
    public CategoriasModel actualizar(CategoriasModel categoria){
        eliminar(categoria.getId());
        categorias.add(categoria);
        return categoria;
    }

}
