package com.hugosantos.cursomc.resources;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hugosantos.cursomc.domain.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource{
    
    @RequestMapping(method = RequestMethod.GET)
    public ArrayList<Categoria> getCategorias(){
        ArrayList<Categoria> categorias = new ArrayList<Categoria>();
        categorias.add(new Categoria(1, "Informática"));
        categorias.add(new Categoria(2, "Escritório"));
        
        return categorias;
    }
}
