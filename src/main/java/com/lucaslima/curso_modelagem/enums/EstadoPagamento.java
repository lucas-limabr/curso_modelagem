package com.lucaslima.curso_modelagem.enums;

import lombok.Getter;

@Getter
public enum EstadoPagamento {

    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    private final Integer codigo;
    private final String descricao;

    private EstadoPagamento(Integer codigo, String descricao)
    {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static EstadoPagamento toEnum(Integer codigo)
    {
        if(codigo == null)
        {
            return null;
        }

        for(EstadoPagamento element :  EstadoPagamento.values())
        {
            if(element.getCodigo().equals(codigo))
            {
                return element;
            }
        }

        throw new IllegalArgumentException("Código inválido: " + codigo);
    }
}
