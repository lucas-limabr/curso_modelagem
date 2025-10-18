package com.lucaslima.curso_modelagem.repository;

import com.lucaslima.curso_modelagem.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
