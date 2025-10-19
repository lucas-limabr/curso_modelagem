package com.lucaslima.curso_modelagem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@EqualsAndHashCode
@Entity
public class Estado {

    public Estado(Long id, String nome)
    {
        this.id = id;
        this.nome = nome;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    @OneToMany(mappedBy = "estado")
    @JsonBackReference
    private List<Cidade> cidades = new ArrayList<>();

}
