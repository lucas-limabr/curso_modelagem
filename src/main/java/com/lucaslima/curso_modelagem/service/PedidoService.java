package com.lucaslima.curso_modelagem.service;

import com.lucaslima.curso_modelagem.entity.Pedido;
import com.lucaslima.curso_modelagem.exceptions.ObjectNotFoundException;
import com.lucaslima.curso_modelagem.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> buscarPedidos()
    {
        return pedidoRepository.findAll();
    }

    public Pedido buscarPedidoPorId(Long id)
    {
        return pedidoRepository.findById(id).orElseThrow(() ->  new ObjectNotFoundException("Pedido não encontrado"));
    }
}
