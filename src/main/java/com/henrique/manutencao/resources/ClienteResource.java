package com.henrique.manutencao.resources;

import java.util.List;
import com.henrique.manutencao.business.ClienteBusiness;
import com.henrique.manutencao.business.Retorno;
import com.henrique.manutencao.domain.entities.Cliente;
import com.henrique.manutencao.domain.models.ClienteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cliente")
public class ClienteResource {

    private ClienteBusiness clienteBusiness;

    @Autowired
    public  ClienteResource(ClienteBusiness clienteBusiness){
        this.clienteBusiness = clienteBusiness;
    }

    @PostMapping(value="/listar-clientes", consumes = "application/json", produces = "application/json")
    public Retorno<List<Cliente>> listarClientes() {
        return clienteBusiness.listarClientes();
    }

    @PostMapping(value="/criar-cliente", consumes = "application/json", produces = "application/json")
    public Retorno<Cliente> criar(@RequestBody ClienteModel cliente){
        return clienteBusiness.criar(cliente);
    }

    @PostMapping(value="/editar-cliente", consumes = "application/json", produces = "application/json")
    public  Retorno<Cliente> editar(@RequestBody ClienteModel cliente) {
        return  clienteBusiness.editar(cliente);
    }
}
