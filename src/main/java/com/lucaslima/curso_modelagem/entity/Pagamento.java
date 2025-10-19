package com.lucaslima.curso_modelagem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.lucaslima.curso_modelagem.enums.EstadoPagamento;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pagamento {

    public Pagamento(Long id, EstadoPagamento estadoPagamento) {
        this.id = id;
        this.estadoPagamento = estadoPagamento.getCodigo();
    }

    @Id
    @Getter
    @Setter
    private Long id;

    private Integer estadoPagamento;

    @OneToOne()
    @JoinColumn(name = "pedido_id")
    @JsonBackReference
    @MapsId
    private Pedido pedido;

    public EstadoPagamento getEstadoPagamento() {
        return EstadoPagamento.toEnum(estadoPagamento);
    }

    public void setEstadoPagamento(EstadoPagamento estadoPagamento) {
        this.estadoPagamento = estadoPagamento.getCodigo();
    }
}
