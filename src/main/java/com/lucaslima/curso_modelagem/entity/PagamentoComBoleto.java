package com.lucaslima.curso_modelagem.entity;

import com.lucaslima.curso_modelagem.enums.EstadoPagamento;
import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
public class PagamentoComBoleto extends Pagamento {

    public PagamentoComBoleto(Long id, EstadoPagamento estadoPagamento, Pedido pedido, LocalDateTime dataVencimento, LocalDateTime dataPagamento) {
        super(id, estadoPagamento, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }

    private LocalDateTime dataVencimento;
   private LocalDateTime dataPagamento;
}
