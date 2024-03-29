package com.henrique.manutencao.business;

import java.util.List;
import com.henrique.manutencao.domain.entities.Servico;
import com.henrique.manutencao.domain.models.ServicoModel;
import com.henrique.manutencao.service.ServicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServicoBusiness {

    private ServicoService servicoService;

    @Autowired
    public ServicoBusiness(ServicoService servicoService) {
        this.servicoService = servicoService;
    }

    public Retorno<Servico> criar (ServicoModel servico){
        return new Retorno<>(true,"Servico criado com sucesso!", servicoService.criar(servico));
    }

    public Retorno<Servico> editar (ServicoModel servico){
        return new Retorno<>(true, "Serviço salvado com sucesso!", servicoService.editar(servico));
    }

    public Retorno<List<Servico>> listarServicos() {
        try {
            return new Retorno<List<Servico>>(true,"Lista de servicçs", servicoService.findAll());
        } catch (Exception ex) {
            return new Retorno<List<Servico>>(false,"Erro ao trazer lista de serviços",null);
        }
    }
}
