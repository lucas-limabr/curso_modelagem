package com.lucaslima.curso_modelagem.repository;

import com.lucaslima.curso_modelagem.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
