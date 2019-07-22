package com.henrique.manutencao.resources;

import java.util.List;
import com.henrique.manutencao.business.Retorno;
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

    @PostMapping(value="/listar-servicos", consumes = "application/json", produces = "application/json")
    public Retorno<List<Servico>> listarServicos() {
        return servicoBusiness.listarServicos();
    }

    @PostMapping(value="/criar-servico", consumes = "application/json", produces = "application/json")
    public Retorno<Servico> criar(@RequestBody ServicoModel servico) {
        return servicoBusiness.criar(servico);
    }

    @PostMapping(value="/editar-servico", consumes = "application/json", produces = "application/json")
    public Retorno<Servico> editar(@RequestBody ServicoModel servico) {
        return servicoBusiness.editar(servico);
    }
}
