package com.lucaslima.curso_modelagem.repository;

import com.lucaslima.curso_modelagem.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
}
