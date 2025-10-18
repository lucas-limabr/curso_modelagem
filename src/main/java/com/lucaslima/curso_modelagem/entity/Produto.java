package com.lucaslima.curso_modelagem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@EqualsAndHashCode
@Data
public class Produto {

    public Produto(Long id, String nome, Double preco)
    {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Double preco;
    @ManyToMany
    @JsonBackReference
    @JoinTable(name = "produto_categoria",
    joinColumns = @JoinColumn(name = "produto_id"),
    inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private List<Categoria> categorias = new ArrayList<>();
}
