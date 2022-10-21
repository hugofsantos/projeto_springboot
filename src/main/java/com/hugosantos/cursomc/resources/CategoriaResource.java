package com.hugosantos.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hugosantos.cursomc.domain.Categoria;
import com.hugosantos.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource{
    @Autowired
    private CategoriaService service;
    
    /**
     * Busca uma categoria pelo ID
     * @param id : id da categoria a ser buscada 
     * @return 
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCategoria(@PathVariable Integer id){
        Categoria categoria = service.buscarCategoriaPeloId(id);
        
        return ResponseEntity.ok().body(categoria);
    }
}
