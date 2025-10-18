package com.lucaslima.curso_modelagem;

import com.lucaslima.curso_modelagem.entity.Categoria;
import com.lucaslima.curso_modelagem.entity.Cidade;
import com.lucaslima.curso_modelagem.entity.Estado;
import com.lucaslima.curso_modelagem.entity.Produto;
import com.lucaslima.curso_modelagem.repository.CategoriaRepository;
import com.lucaslima.curso_modelagem.repository.CidadeRepository;
import com.lucaslima.curso_modelagem.repository.EstadoRepository;
import com.lucaslima.curso_modelagem.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CursoModelagemApplication implements CommandLineRunner {

	@Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    public static void main(String[] args) {
		SpringApplication.run(CursoModelagemApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

        Categoria c1 = new Categoria(null, "Informática");
        Categoria c2 = new Categoria(null, "Escritório");

        Produto p1 = new Produto(null, "Computador", 2000.00);
        Produto p2 = new Produto(null, "Impressora", 800.00);
        Produto p3 = new Produto(null, "Mouse", 80.00);

        c1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        c2.getProdutos().add(p2);

        p1.getCategorias().add(c1);
        p2.getCategorias().addAll(Arrays.asList(c1, c2));
        p3.getCategorias().add(c1);

        categoriaRepository.saveAll(Arrays.asList(c1,c2));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

        Estado est1 = new Estado(null, "Minas Gerais");
        Estado est2 = new Estado(null, "São Paulo");

        Cidade cid1 = new Cidade(null, "Uberlândia", est1);
        Cidade cid2 = new Cidade(null, "São Paulo", est2);
        Cidade cid3 = new Cidade(null, "Campinas", est2);

        est1.getCidades().add(cid1);
        est2.getCidades().addAll(Arrays.asList(cid2, cid3));

        estadoRepository.save(est1);
        estadoRepository.save(est2);

        cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
    }
}
