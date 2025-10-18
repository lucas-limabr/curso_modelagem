package com.lucaslima.curso_modelagem.enums;

import lombok.Getter;

@Getter
public enum TipoCliente {

    PESSOA_JURIDICA(1, "Pessoa Jurídica"),
    PESSOA_FISICA(2, "Pessoa Física");

    private final Integer codigo;
    private final String descricao;

    private TipoCliente(Integer codigo, String descricao)
    {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static TipoCliente toEnum(Integer codigo)
    {
        if(codigo == null)
        {
            return null;
        }

        for(TipoCliente element :  TipoCliente.values())
        {
            if(element.getCodigo().equals(codigo))
            {
                return element;
            }
        }

        throw new IllegalArgumentException("Código inválido: " + codigo);
    }
}
