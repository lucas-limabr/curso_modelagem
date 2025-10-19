package com.lucaslima.curso_modelagem.entity;

import jakarta.persistence.Entity;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class PagamentoComCartao extends Pagamento {

    private Integer numeroParcelas;
}
