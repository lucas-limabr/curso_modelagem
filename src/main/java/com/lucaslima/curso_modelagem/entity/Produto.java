package com.lucaslima.curso_modelagem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.lucaslima.curso_modelagem.usecases.ManipulaCategorias;
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
public class Produto implements ManipulaCategorias {

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

    //Anotaçâo do JPA/Hibernate, para controlar quem é o lado dono no BD, isso, na prática, diz que apenas a partir do lado dono (Produto) eu vou conseguir inserir objetos do outro lado (Categoria) no BANCO, e não o contrário
    //add na memória primária e ao banco: produto.getCategorias().add(categ1) seguido de produtoRepository.save(produto)
    //add na memória primária e não add ao banco: categoria.getProduto().add(prod1);
    @JoinTable(name = "produto_categoria",
    joinColumns = @JoinColumn(name = "produto_id"),
    inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    //Anotação do Jackson, para controlar serialização, usado em respostas JSON de uma api REST, significa que este lado (Produto) não irá trazer objetos da lista do outro lado (Categoria)
    @JsonBackReference
    private List<Categoria> categorias = new ArrayList<>();

    //Implementei uma interface para ser obrigado a implementar esses métodos que servem para fazer a sincronização bidirecional que o relacionamento N X N exige para integridade dos dados na MEMÓRIA PRINCIPAL
    @Override
    public void addCategoria(Categoria cat)
    {
        this.categorias.add(cat);
        cat.getProdutos().add(this);
    }

    @Override
    public void addNCategories(List<Categoria> categorias)
    {
        this.categorias.addAll( categorias );

        for(Categoria item : categorias)
        {
            item.getProdutos().add(this);
        }
    }
}
