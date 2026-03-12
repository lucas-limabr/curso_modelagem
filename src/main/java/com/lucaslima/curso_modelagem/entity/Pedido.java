package com.lucaslima.curso_modelagem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@EqualsAndHashCode
public class Pedido {

    public Pedido(Long id, LocalDateTime data, Cliente cliente, Endereco enderecoEntrega) {
        this.id = id;
        this.data = data;
        this.cliente = cliente;
        this.enderecoEntrega = enderecoEntrega;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime data;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonBackReference
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "endereco_entrega_id")
    Endereco enderecoEntrega;

    //Cascade deve ficar na entidade que controla a outra, aqui é Pedido, ao criar, atualizar ou excluir um Pedido, o Pagamento relacionado também deverá ser atualizado, ao excluir um Pedido, por exemplo, lembre que um Pagamento não existe sozinho
    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
    //No JSON de um objeto Pedido traz também o pagamento relacionado
    @JsonManagedReference
    private Pagamento pagamento;

    //Eu quis que o endpoint /pedidos/id do Controller retornasse todos os ItemPedido, bem como os Produtos destes itens de um pedido. Uma abordagem seria utilizar este código abaixo comentado, assim, eu estabeleceria uma relação bidirecional, onde Pedido também conhece ItemPedido
    //    @OneToMany(mappedBy = "pedido")
    //    @JsonManagedReference
    //    private List<ItemPedido> itemPedido = new ArrayList<>();
}
