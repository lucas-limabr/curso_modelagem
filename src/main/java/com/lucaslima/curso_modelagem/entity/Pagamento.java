package com.lucaslima.curso_modelagem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.lucaslima.curso_modelagem.enums.EstadoPagamento;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
public abstract class Pagamento {

    public Pagamento(Long id, EstadoPagamento estadoPagamento, Pedido pedido) {
        this.id = id;
        this.estadoPagamento = estadoPagamento.getCodigo();
        this.pedido = pedido;
    }

    @Id
    @Getter
    @Setter
    private Long id;

    private Integer estadoPagamento;

    //Se utilizar uma relação forte com a anotação @MapsId utilzie também uma relação bidirecional com o cascade type.all na classe que controla a outra

    @OneToOne()
    @JoinColumn(name = "pedido_id")
    //No JSON de um objeto Pagamento não traz o Pedido relacionado
    @JsonBackReference
    //Para dizer que o ID de pedido além de ser FK também é PK, ou seja, é uma relação forte, onde um pagamento não existe sem um pedido relacionado
    @MapsId
    private Pedido pedido;

    public EstadoPagamento getEstadoPagamento() {
        return EstadoPagamento.toEnum(estadoPagamento);
    }

    public void setEstadoPagamento(EstadoPagamento estadoPagamento) {
        this.estadoPagamento = estadoPagamento.getCodigo();
    }
}
