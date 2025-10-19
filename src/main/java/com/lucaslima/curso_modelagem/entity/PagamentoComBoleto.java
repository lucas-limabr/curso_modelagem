package com.lucaslima.curso_modelagem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
public class PagamentoComBoleto extends Pagamento {

   private Date dataVencimento;
   private Date dataPagamento;
}
