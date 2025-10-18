package com.lucaslima.curso_modelagem.repository;

import com.lucaslima.curso_modelagem.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
