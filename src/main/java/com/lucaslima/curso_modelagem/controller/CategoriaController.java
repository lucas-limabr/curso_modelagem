package com.lucaslima.curso_modelagem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @GetMapping
    public String listarCategorias()
    {
        return "Testando a rota get de categorias";
    }
}
