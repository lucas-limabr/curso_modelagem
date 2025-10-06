package com.lucaslima.curso_modelagem.service;

import com.lucaslima.curso_modelagem.entity.Categoria;
import com.lucaslima.curso_modelagem.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Optional<Categoria> buscarCategoria(Long id)
    {
        return repo.findById(id);
    }

    public List<Categoria> buscarCategorias()
    {
        return repo.findAll();
    }
}
