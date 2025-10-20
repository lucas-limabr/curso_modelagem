package com.lucaslima.curso_modelagem.entity;

import com.lucaslima.curso_modelagem.enums.EstadoPagamento;
import jakarta.persistence.Entity;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class PagamentoComCartao extends Pagamento {

    private Integer numeroParcelas;

    public PagamentoComCartao(Long id, EstadoPagamento estadoPagamento, Pedido pedido, Integer numeroParcelas) {
        super(id, estadoPagamento, pedido);
        this.numeroParcelas = numeroParcelas;
    }
}
