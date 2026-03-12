package com.lucaslima.curso_modelagem.repository;

import com.lucaslima.curso_modelagem.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {
    List<ItemPedido> findByPedidoId(Long id);
}
