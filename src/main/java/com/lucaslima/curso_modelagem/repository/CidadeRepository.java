package com.lucaslima.curso_modelagem.repository;

import com.lucaslima.curso_modelagem.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
