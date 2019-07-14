package com.henrique.manutencao.resources;

import com.henrique.manutencao.business.ServicoBusiness;
import com.henrique.manutencao.domain.entities.Servico;
import com.henrique.manutencao.domain.models.ServicoModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/servico")
public class ServicoResource {

    private ServicoBusiness servicoBusiness;

    @Autowired
    public ServicoResource(ServicoBusiness servicoBusiness) {
        this.servicoBusiness = servicoBusiness;
    }

    @GetMapping(consumes = "application/json", produces = "application/json")
    public Servico pesquisar() {
        Servico servico = new Servico();
        servico.setId(100L);
        return servico;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public Servico criar(@RequestBody ServicoModel servico) {
        return servicoBusiness.criar(servico);
    }

}
