package com.lucaslima.curso_modelagem.repository;

import com.lucaslima.curso_modelagem.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
