package com.lucaslima.curso_modelagem.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@Entity
public class Categoria {

    public Categoria(Long id, String nome)
    {
        this.id = id;
        this.nome = nome;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    //Anotação do JPA/Hibernate: sgnifica que esse lado não é o dono da relação no BD
    @ManyToMany(mappedBy = "categorias")

    //Anotação do Jackson: significa que apenas este lado (Categoria) vai trazer um array de objetos da lista do outro lado (Produto) no JSON
    @JsonManagedReference
    private List<Produto> produtos = new ArrayList<>();
}
