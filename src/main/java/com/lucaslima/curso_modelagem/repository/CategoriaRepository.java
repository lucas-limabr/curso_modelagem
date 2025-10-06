package com.lucaslima.curso_modelagem.repository;

import com.lucaslima.curso_modelagem.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
