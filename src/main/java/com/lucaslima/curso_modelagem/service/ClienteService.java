package com.lucaslima.curso_modelagem.service;

import com.lucaslima.curso_modelagem.entity.Cliente;
import com.lucaslima.curso_modelagem.exceptions.ObjectNotFoundException;
import com.lucaslima.curso_modelagem.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public Cliente buscarCliente(Long id)
    {
        return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("ID não encontrado"));
    }

    public List<Cliente> buscarClientes()
    {
        return repo.findAll();
    }
}
