package com.lucaslima.curso_modelagem.controller;

import com.lucaslima.curso_modelagem.entity.Categoria;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @GetMapping
    public List<Categoria> listarCategorias()
    {
        Categoria c1 = new Categoria(1L, "Informática");
        Categoria c2 = new Categoria(2L, "Escritório");

        List<Categoria> listaCategorias = new ArrayList<>();
        listaCategorias.add(c1);
        listaCategorias.add(c2);

        return listaCategorias;
    }
}
