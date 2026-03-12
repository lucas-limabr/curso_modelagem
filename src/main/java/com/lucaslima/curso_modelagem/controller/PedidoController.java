package com.lucaslima.curso_modelagem.controller;

import com.lucaslima.curso_modelagem.dto.PedidoResponseDTO;
import com.lucaslima.curso_modelagem.entity.ItemPedido;
import com.lucaslima.curso_modelagem.entity.Pedido;
import com.lucaslima.curso_modelagem.exceptions.ObjectNotFoundException;
import com.lucaslima.curso_modelagem.repository.ItemPedidoRepository;
import com.lucaslima.curso_modelagem.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @GetMapping
    public ResponseEntity<List<Pedido>> buscarPedidos() {
        List<Pedido> pedidos = pedidoService.buscarPedidos();

        return ResponseEntity.ok().body(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> buscarPedidoPor(@PathVariable Long id) {
        Pedido pedido = pedidoService.buscarPedidoPorId(id);

        //Utilzei um repository da classe intermediária para buscar todos os itens de pedido a  partir do ID de um pedido, com ele, utilizei um DTOResponse para retornar estes dados que conceitualmente são atrelados a um Pedido
        List<ItemPedido> itemPedido = itemPedidoRepository.findByPedidoId(id);
        PedidoResponseDTO pedidoResponseDTO = new PedidoResponseDTO(pedido, itemPedido);

        return ResponseEntity.ok().body(pedidoResponseDTO);
    }
}
