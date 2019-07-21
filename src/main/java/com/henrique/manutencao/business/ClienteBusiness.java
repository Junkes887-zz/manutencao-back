package com.henrique.manutencao.business;

import java.util.List;
import com.henrique.manutencao.domain.entities.Cliente;
import com.henrique.manutencao.domain.models.ClienteModel;
import com.henrique.manutencao.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClienteBusiness {

    private ClienteService clienteService;

    @Autowired
    public ClienteBusiness(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    private boolean validaSeClienteExiste(ClienteModel model){
        return clienteService.validaSeClienteExiste(model);
    }

    public  Retorno<Cliente> criar (ClienteModel model){
        boolean clienteExiste = validaSeClienteExiste(model);
        if (clienteExiste){
            return new Retorno<>(false,"Cliente ja existe!!!",null);
        }
        return new Retorno<>(true,"Cliente criado com sucesso!", clienteService.criar(model));
    }
    public Retorno<Cliente> editar(ClienteModel model) {
        Cliente cliente = clienteService.editar(model);
        if (cliente != null){
            return new Retorno<>(true,"Cliente editado com sucesso!",cliente);
        }
        return new Retorno<>(false,"Não foi pssivel editar o cliente!",null);
    }
    public Retorno<List<Cliente>> listarClientes() {
        try {
            return new Retorno<List<Cliente>>(true,"Lista de clientes", clienteService.findAll());
        } catch (Exception ex) {
            return new Retorno<List<Cliente>>(false,"Erro ao trazer lista de clientes",null);
        }
    }
}
