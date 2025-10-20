package com.lucaslima.curso_modelagem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
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

    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Pagamento pagamento;
}
