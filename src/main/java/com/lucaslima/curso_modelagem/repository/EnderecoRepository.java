package com.lucaslima.curso_modelagem.repository;

import com.lucaslima.curso_modelagem.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
