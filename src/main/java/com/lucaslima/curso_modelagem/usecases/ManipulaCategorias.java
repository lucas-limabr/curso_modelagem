package com.lucaslima.curso_modelagem.usecases;

import com.lucaslima.curso_modelagem.entity.Categoria;

import java.util.List;

public interface ManipulaCategorias {

    public void addCategoria(Categoria cat);
    public void addNCategories(List<Categoria> categorias);
}
