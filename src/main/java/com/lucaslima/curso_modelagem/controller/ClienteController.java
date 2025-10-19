package com.lucaslima.curso_modelagem.controller;

import com.lucaslima.curso_modelagem.entity.Cliente;
import com.lucaslima.curso_modelagem.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes()
    {
       List<Cliente> Cliente = service.buscarClientes();

        return ResponseEntity.ok().body(Cliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long id)
    {
        Cliente categoria = service.buscarCliente(id);

        return ResponseEntity.ok().body(categoria);
    }
}
