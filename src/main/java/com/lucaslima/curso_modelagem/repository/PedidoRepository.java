package com.lucaslima.curso_modelagem.repository;

import com.lucaslima.curso_modelagem.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
