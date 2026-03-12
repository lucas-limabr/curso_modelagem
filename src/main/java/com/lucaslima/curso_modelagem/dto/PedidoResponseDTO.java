package com.lucaslima.curso_modelagem.dto;

import com.lucaslima.curso_modelagem.entity.Endereco;
import com.lucaslima.curso_modelagem.entity.ItemPedido;
import com.lucaslima.curso_modelagem.entity.Pagamento;
import com.lucaslima.curso_modelagem.entity.Pedido;

import java.time.LocalDateTime;
import java.util.List;

public record PedidoResponseDTO(LocalDateTime dataPedido, Endereco enderecoEntrega, Pagamento pagamento,
                                List<ItemPedido> itemPedido) {

    public PedidoResponseDTO(Pedido pedido, List<ItemPedido> itemPedido) {
        this(
                pedido.getData(),
                pedido.getEnderecoEntrega(),
                pedido.getPagamento(),
                itemPedido
        );
    }
}
