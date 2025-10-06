package com.lucaslima.curso_modelagem.controller;

import com.lucaslima.curso_modelagem.entity.Categoria;
import com.lucaslima.curso_modelagem.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public ResponseEntity<List<Categoria>> listarCategorias()
    {
       List<Categoria> categorias = service.buscarCategorias();

        return ResponseEntity.ok().body(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscar(@PathVariable Long id)
    {
        Optional<Categoria> categoria = service.buscarCategoria(id);
        if(categoria.isPresent())
        {
            return  ResponseEntity.ok().body(categoria.get());
        }

        return ResponseEntity.notFound().build();
    }
}
