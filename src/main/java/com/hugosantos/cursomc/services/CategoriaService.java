package com.hugosantos.cursomc.services;

import java.util.Optional;

import com.hugosantos.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hugosantos.cursomc.domain.Categoria;
import com.hugosantos.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repository;
    
    /**
     * Busca uma categoria no banco de dados pelo ID
     * @param id : id da categoria
     * @return a categoria ou null caso não exista
     */
    public Categoria buscarCategoriaPeloId(Integer id){
        Optional<Categoria> categoria = repository.findById(id);

        return categoria.orElseThrow(() -> {
            throw new ObjectNotFoundException(String.format("Nenhum objeto com o id %d foi encontrado!", id));
        });
    }
}
