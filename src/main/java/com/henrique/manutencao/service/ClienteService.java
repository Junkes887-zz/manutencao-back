package com.henrique.manutencao.service;

import java.util.List;
import com.henrique.manutencao.domain.entities.Cliente;
import com.henrique.manutencao.domain.models.ClienteModel;
import com.henrique.manutencao.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public  ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    private Cliente converterEmEntidade(ClienteModel model){
        Cliente cliente = new Cliente();
        cliente.setId(model.getId() != null ? model.getId() : null);
        cliente.setNome(model.getNome());
        cliente.setEmail(model.getEmail());
        cliente.setEndereco(model.getEndereco());
        cliente.setTelefone(model.getTelefone());
        return cliente;
    }

    public boolean validaSeClienteExiste(ClienteModel model){
        return clienteRepository.existsByNomeOrEmailOrTelefone(model.getNome(),model.getEmail(), model.getTelefone());
    }

    public Cliente criar(ClienteModel model){
        Cliente cliente = converterEmEntidade(model);
        return clienteRepository.save(cliente);
    }

    public Cliente editar(ClienteModel model) {
        Cliente cliente = converterEmEntidade(model);
        return clienteRepository.save(cliente);
    }

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }
}
