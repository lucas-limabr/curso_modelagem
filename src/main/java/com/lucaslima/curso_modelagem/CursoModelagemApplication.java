package com.lucaslima.curso_modelagem;

import com.lucaslima.curso_modelagem.entity.*;
import com.lucaslima.curso_modelagem.enums.TipoCliente;
import com.lucaslima.curso_modelagem.repository.*;
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

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

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

        Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "12345", TipoCliente.PESSOA_FISICA);

        Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "38220834", cid1, cli1);

        Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cid2, cli1);

        cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

        cli1.getTelefones().addAll(Arrays.asList("2567891", "2567433"));

        clienteRepository.save(cli1);
        enderecoRepository.save(e1);
        enderecoRepository.save(e2);
    }
}
